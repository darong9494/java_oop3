package http.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleHttpClient2 {

    public static void main(String[] args) {
        // 가짜 서버에 user 10의 정보를 요청하고 응답을 받고 콘솔창에 출력하세요.
        // HTTP 요청과 응답 만들기
        String urlString = "https://jsonplaceholder.typicode.com/users/2";
        // HTTP 통신하는 클래스
        HttpURLConnection connection = null; // 초기화값을 넣어줘야 오류발생 막을수 있다.

        // 1단계 : URL 객체 생성
        try {
            URL url = new URL(urlString);

            // 2단계 : HTTP 연결 객체 생성
            connection = (HttpURLConnection)url.openConnection();

            // 3단계 : 요청방식 설정(GET, POST, PUT, DELETE)
            // 자원의 요청 >> GET 방식에 던지기
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("Accept", "application/json");

            // 4단계 : 실제 요청 전송 >> 즉시 응답 >> 응답코드
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드 확인: " +responseCode);

            if(responseCode != 200) {
                // responseCode가 200이 아니라면
                System.out.println("요청 실패");
                return;
            }

            // 5단계 : 응답 본문 읽기
            // I/O 단원에서 배운 체인 그대로 사용가능
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                // 문자가 많을 때 StringBuffer를 사용하는게 좋다.
                StringBuffer response = new StringBuffer();
                String line;
                while((line = reader.readLine()) != null) {
                    response.append(line).append("\n");
                }
                System.out.println("응답내용 : ");
                System.out.println(response.toString());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    } // end of main
} // end of class
