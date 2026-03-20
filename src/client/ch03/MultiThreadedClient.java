package client.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiThreadedClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000)) {
            // 소켓에서 연결할 입력, 출력 스트림 2개가 필요
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 클라이언트 입장에서도 키보드에서 값을 입력 받을 스트림이 필요하다.
            BufferedReader KeyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 읽기 스레드 (서버측에서 값을 받을 수 있도록 처리)
            Thread readThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String serverMessage;
                        while ((serverMessage = reader.readLine()) != null) {
                            if("exit".equalsIgnoreCase(serverMessage)) {
                                System.out.println("서버가 종료 했습니다.");
                                break;
                            }
                            System.out.println("서버: " +serverMessage);
                        }
                    }catch (Exception e) {
                        System.out.println("서버측과 연결이 끊겼습니다.");
                    }
                }
            });

            // 쓰기 스레드 생성 (클라이언트 측 키보드에서 값을 받아서 서버측으로 전송하기)
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String clientMessage;
                        while ((clientMessage = KeyboardReader.readLine()) != null) {
                            // null이 아니면 값이 들어갈것이다.
                            writer.println(clientMessage);
                            if("exit".equalsIgnoreCase(clientMessage)) {
                                System.out.println("클라이언트가 종료했습니다.");
                                break;
                            }
                        }
                    }catch (IOException e) {
                        System.out.println("메세지 전송 중 오류가 발생했습니다.");
                    }
                }
            });
            readThread.start();
            writeThread.start();
            readThread.join();
            writeThread.join();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    } // end of main
} // end of class
