package client.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

// 클라이언트 소켓 통신을 위한 클라이언트 측 코드
public class ClientFIle {
    public static void main(String[] args) {
        // 클라이언트는 접근할 서버 컴퓨터에 IP 주소와 포트 번호를 알고 있어야 된다.
        try (Socket socket = new Socket("192.168.4.12", 5000)) {
            // (Socket socket = new Socket("localhost", 5000))
            // 위 코드가 실행되는 순간 내부적으로 이미 서버 컴퓨터와 열결을 시도한 상태다.

            // 이걸로 메세지를 쓸 수 있다.
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
            //writer.write("Hello - server---" + "\n"); // 개행 문자까지 보내야 정상적으로 보내진다.

            writer.println("배고프당...");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
