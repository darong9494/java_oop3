package http.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AirQualityClient {
    public static void main(String[] args) {
        String urlString = "";
        HttpURLConnection connection;

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection(); // 통신하겠다.
            System.out.println("통신 성공 여부 확인: ");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                StringBuffer responseBody = new StringBuffer(); // 한줄씩 읽는거 긴글자 모두 읽어내기
                String line;
                while((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }
                String jsonString = responseBody.toString();
                System.out.println("JSON 응답: " +responseBody);

                Gson gson = new Gson();

                TypeToken<List<AirQualityDto.Item>> typeToken = new TypeToken<>() {};
                List<AirQualityDto.Item> items = gson.fromJson(jsonString, typeToken.getType());

                for (int i = 0; i < 1; i++) {
                    System.out.println(items.get(i));
                }
            }
        } catch (IOException e) {
            System.out.println("통신실패: " + e.getMessage());
        }
    }
}
