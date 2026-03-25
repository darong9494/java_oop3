package http.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

// 주소 : https://jsonplaceholder.typicode.com/posts/1
public class PostClient2 {
    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/posts";
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
                TypeToken<List<Post>> typeToken = new TypeToken<>() {};
                List<Post> postList = gson.fromJson(jsonString, typeToken.getType());
                System.out.println("전체 개수: " + postList.size() + "개");
                //200개 중에 앞에있는 1개만 출력
                for (int i = 0; i < 1; i++) {
                    System.out.println(postList.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("통신 실패: " + e.getMessage());
        }
    } // end of main
} // end of class
