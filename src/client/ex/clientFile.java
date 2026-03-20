package client.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class clientFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket("192.168.7.211", 5000)) {
            //Socket socket = new Socket("localhost", 5000) 생성되는 순간
            // 서버측이랑 연결된 상태가 됨

            // 쓰는 스트림 준비 (클라이언트에서 서버로 보내는거) 써서 출력할거니까 OutputStream
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

            // 받을 수 있는 읽기 스트림 준비 (서버에서 클라이언트로)
            BufferedReader reader = new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));

                    // 기능 실행

            while (true) {
                writer.println(sc.nextLine()); // 쓴거 입력해라
                String response = reader.readLine(); // response가 전체 줄을 받아내라
                System.out.println("서버 측 응답: " + response); // 서버에서 받은 내용 출력
            }

            // 서버에서 보낸 응답 수신

        } catch (UnknownHostException e) {
            System.out.println("서버측을 알수 없다." + e.getMessage());
        } catch (IOException e) {
            System.out.println("서버측에 연결할 수 없다.");
        }
    } // end of main
} // end of class
