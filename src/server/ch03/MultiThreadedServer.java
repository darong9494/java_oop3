package server.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("클라이언트에 연결 요청을 기다립니다...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("--- 서 버 실 행 ---");

            //소켓과 연결된 스트림
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            ///

            ///  키보드와 연결할 스트림
            BufferedReader KeyboardReader = new BufferedReader(new InputStreamReader(System.in));

            // 읽기 스레드 : 클라이언트 메세지를 계속 수신하는 작업 만들기
            Thread readThread = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        String clientMessage;
                        while ((clientMessage = reader.readLine()) != null) {
                            // null이 아니면 입력한 값이 들어올것이다. // 블로킹 상태 멈춰있음.
                            if ("exit".equalsIgnoreCase(clientMessage)) {
                                System.out.println("클라이언트가 종료했습니다.");
                                break;
                            }
                            System.out.println("클라이언트 메세지: " + clientMessage);
                        }
                    } catch (IOException e) {
                        System.err.println("클라이언트와 연결이 끊겼습니다.");
                    }
                }
            });

            // 쓰기 스레드: 키보드 입력을 받아 클라이언트에게 전송
            Thread writeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                try{
                    String serverMessage;
                    while ((serverMessage = KeyboardReader.readLine()) != null) {
                        writer.println(">>>" +serverMessage); // 개행문자까지 \n이 포함
                        if("exit".equalsIgnoreCase(serverMessage)) {
                            System.out.println("서버가 종료했습니다.");
                            break;
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                }
            });

            readThread.start(); // 스레드 일 실행 // 읽기 스레드 시작
            writeThread.start(); // 쓰기 스레드 시작

            readThread.join(); // 읽기 스레드가 종료까지 대기
            writeThread.join(); // 쓰기 스레드가 종료까지 대기

            /**
             * join() = 이 스레드가 끝날 때 까지 기다려줘 라는 의미이다.
             * Thread.sleep()이 "N초동안 잠깐 잠들어 멈춰" 라면
             * join()은 저 스레드가 끝날 때 까지 멈춰 이다.
             * join()이 없으면
             * main 스레드 바로 try 블록을 벗어난다.
             * 소켓 자동 close()됨
             * 아직 실행중인 readThread, writeThread가 닫힌 소켓으로 통신 시도 오류발생
             */
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    } // end of main
} // end of class
