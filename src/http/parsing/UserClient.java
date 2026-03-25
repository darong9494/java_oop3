package http.parsing;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// https://jsonplaceholder.typicode.com/users/1
public class UserClient {
    public static void main(String[] args) {
        // 통신할 주소 : https://jsonplaceholder.typicode.com/users/1

        String urlString = "https://jsonplaceholder.typicode.com/users";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection(); // 통신하겠다
            System.out.println("통신 성공 여부 확인: " );

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                StringBuffer responseBody = new StringBuffer(); // 한줄씩 읽는거를 긴글자 모두 읽어내겠다.
                String line;
                while ((line = reader.readLine()) != null){
                    responseBody.append(line);
                }
                String jsonString = responseBody.toString();
                System.out.println("JSON 응답: " + responseBody);

                Gson gson = new Gson();


                TypeToken<List<User>> typeToken = new TypeToken<>() {};
                List<User> users = gson.fromJson(jsonString, typeToken.getType());

                for (int i = 0; i < 3; i++) {
                    System.out.println(users.get(i));
                }
            }

        } catch (Exception e) {
            System.out.println("통신실패: " + e.getMessage());
        }
    }
}
