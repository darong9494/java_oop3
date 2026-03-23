package My.ch01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("채팅 이름을 입력하세요: ");
        String name = sc.nextLine();
        // 이름을 입력받아라

        try (Socket socket = new Socket("localhost", 5000)) {
            System.out.println(name + "님, 채팅방 입장 (종료: exit");

            // 소켓에서 연결할 입력, 출력 스트림 2개가 필요함.
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            // socket.getOutputStream() 상대방에게 데이터 보낼수 있는 통로 가져오라
            // new PrintWriter() >> writer.println("안녕하세여")와 같은 문자열 그대로 보낸다.
            // 상대방한테 문자 보내기위해 writer를 socket에 연결해라

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 상대방이 보낸 데이터를 글자로 번역해서 한줄씩 읽기 편하게 버퍼에 담은것을 reader로 쓰겠다.
            BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
            // 키보드에서 입력받은거를 한줄씩 읽기 편하게 버퍼에 담아라

            // 읽기 스레드 (서버측에서 값을 계속 받을 수 있도록 처리)
            Thread readThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String serverMessage;
                        while ((serverMessage = reader.readLine()) != null) {
                            // 상대방이 보낸 메세지가 연결이 끊기지 않는 한
                            // null이 아닐때까지 계속 반복해라
                            System.out.println("서버: " + serverMessage);
                        }
                    } catch (Exception e) {
                        System.out.println("서버측과 연결이 끊겼습니다.");
                    }
                }
            });

            // 쓰기 스레드 (클라이언트 측 키보드에서 값을 받아서 서버측으로 전송)
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String clientMessage;
                        while((clientMessage = keyboardReader.readLine()) != null) {
                            // keyboardReader.readLine() >>키보드를 치고 엔터 누를때까지 기다린다.
                            // 키보드에 입력한 줄을 clientMessage에 담고 입력이 중단되지 않는한 계속 반복해라
                            if("exit".equalsIgnoreCase(clientMessage)) {
                                // 만약 대소문자 구분없이 clientMessage에서 exit를 입력했다면
                                System.out.println("채팅방 종료");
                                writer.println("[" + name + "] 님이 퇴장했습니다.");
                                break;
                            }
                            // 서버에 메세지 전송
                            writer.println("[" + name + "]" + clientMessage);
                        }
                    } catch (Exception e) {
                        System.out.println("메세지 전송 중 오류가 발생했습니다.");
                    }
                }
            });

            readThread.start();
            writeThread.start();
            // 읽기스레드, 쓰기 스레드 시작시켜라
            readThread.join();
            writeThread.join();
            // join() >> 1. 이 스레드 작업 끝날 때 까지 나(현재 스레드)는 여기서 대기할게
            //           2. 스레드들 실행 순서 맞추려면 써야됨

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    } // end of main
}
