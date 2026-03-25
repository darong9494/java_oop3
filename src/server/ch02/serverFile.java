package server.ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class serverFile {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("서버 시작 - 포트 번호 5001번");
            Socket clientSocket = serverSocket.accept(); // 블로킹 메소드
            System.out.println("클라이언트 연결됨");

            // 간단한 흐름 약속 (연결 후 클라이언트가 먼저 서버측으로 메세지를 보낼 예정)

            // 읽을 수 있는 전용 스트림을 준비함 (클라이언트에서 서버로)
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));

            // 쓰기 스트림 준비 (서버에서 클라이언트로 추가)
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // 기능 호출해보기
            // 1. 먼저 클라이언트에서 보낸 메세지를 받기
            String message = reader.readLine();
            System.out.println("클라이언트 측 메세지: " + message);

            // 2. 서버가 클라이언트에게 응답 전송할거임
            writer.println("안녕 나는 서버야, ㅎㅇ");

        } catch (IOException e) {
            System.out.println("오류 발생: " + e.getMessage());
        }
    } // end of main
} // end of class
