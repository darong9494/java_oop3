package http.gson;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// 주소 : https://jsonplaceholder.typicode.com/posts/1
public class PostClient {
    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/posts/1";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            // HTTP 요청 메세지 만들어서 연결 요청
            connection.setRequestMethod("GET");

            // 바로 연결 요청
            int responseHttpCode = connection.getResponseCode(); // 통신
            System.out.println("통신 성공 여부 확인: " + responseHttpCode);

            // 응답 본문 추출
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                StringBuffer responseBody = new StringBuffer();
                String line;
                while((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }

                // StringBuffer >> 문자열로 형 변환 toString() 호출
                String jsonString = responseBody.toString();
                System.out.println("JSON 응답: " + responseBody);

                Gson gson = new Gson();
                Post post = gson.fromJson(jsonString,Post.class);
                System.out.println("-------------");
                System.out.println(post.getId());
                System.out.println(post.getUserId());
                System.out.println(post.getTitle());
                System.out.println(post.getBody());
                System.out.println(post.toString());
            }
        } catch (Exception e) {
            System.out.println("통신 실패: " + e.getMessage());
        }
    } // end of main
} // end of class
