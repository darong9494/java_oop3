package My.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MultiClientServer {
    private static final int PORT = 5000;
    // 연결된 모든 클라이언트의 출력 스트림을 보관할 자료 구조 생성
    // Vector는 멀티 스레드 환경에서 안전한 동작을 한다.
    // 연결된 모든 클라이언트의 PrintWriter를 보관한다.
    private static Vector<PrintWriter> clientWriterList = new Vector<>();

    public static void main(String[] args) {
        System.out.println("서버 시작...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                // 클라이언트 접속 >> 전담 스레드 생성 >> 메인 스레드는 다시 대기
                new ClientHandler(clientSocket).start(); // start() 되면 서브 작업자가 일을한다.
                System.out.println("클라이언트 접속. 현재 접속자" + clientWriterList.size() + "명");
                // size() clientWriterList에 사람이 몇명있는지 알려준다.
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } // end of main

    // 각 클라이언트와의 통신을 담당하는 정적 내부 클래스 만들기 Thread
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out; // 쓸거
        private BufferedReader in; // 읽어낼거

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        // 스레드가 start() 호출되면 서브 작업자가 일한다.
        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 거꾸로 보면 socket.getInputStream은 클라이언트 데이터를 받아오라는말
                // new InputStreamReader는 바이트를 문자로 변환해주는 번역기
                // new BufferedReader >> 문자 하나씩 읽는거 느리니까 버퍼에 모아뒀다가 한번에 읽음
                // 그래서 in은 클라이언트에서 받은 문자를 읽어내는거
                out = new PrintWriter(socket.getOutputStream(),true);
                // socket.getOutputStream 보낼수있는 통로를 가져오라
                // new PrintWriter >> 바이트를 문자열로 출력하게 해줌
                // true >> 데이터 보낼때 버퍼가 가득찰때까지 기다리지말고 println() 호출할때마다
                // 바로바로 상대방에게 전송하라는 뜻이다.

                // 추후 접속자 명수 확인 또는 방송(브로드캐스트)를 하기 위해 벡터 자료 구조
                clientWriterList.add(out);
                // 클라이언트 접속자들이 쓴다.

                String message; // 문자열 선언
                while((message = in.readLine()) != null) {
                    // 메세지들이 null이 아닌 동안에
                    System.out.println("수신: " + message);
                    // 받은 메세지를 연결된 모든 클라이언트에게 전송해라 (브로드캐스트)
                    broadcast(message);
                }
            } catch (Exception e) {
                System.out.println("누군가 채팅을 종료했습니다.");
                //throw new RuntimeException(e);
            } finally {
                // 클라이언트가 강제 종료 및 exit 요청을 했다면 서버에서 관리하고 있는
                // 벡터안에 나의 출력 스트림을 제거해줘야함. >> 다른사람이 종료한 후에
                // 더이상 입력할 수 없게 스트림을 제거해줘야 된다는 말임.
                clientWriterList.remove(out); // 출력 스트림 제거
                try {
                    if(socket != null) {
                        // 만약 socket이 null이 아니라면
                        socket.close(); // 채팅이 종료됐는데 socket이 계속 있으면 안되니까 닫아줘야함
                    }
                } catch (Exception e) {
                    System.out.println("클라이언트 퇴장: " + clientWriterList.size());
                    // 몇명이 나갔는지 알려줌
                }
            }
        } // end of run

        // 방송하기
        private void broadcast(String message) {
            for(PrintWriter writer : clientWriterList) {
                // clientWriterList 사람들의 데이터를 하나씩 꺼내서 쓰기 반복해라
                writer.println(message);
                // 쓴 메세지가 출력된다.
            }
        }
    } // end of inner ClientHandler
} // end of class