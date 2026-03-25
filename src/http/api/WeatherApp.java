package http.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WeatherApp {

    public static void main(String[] args) {
        String apiKey = "48f17fd9e73e60977fa6d8246d59eb27"; // 발급받은 API 키 입력
        String city = "Busan";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city +
                "&appid=" + apiKey + "&units=metric&lang=kr";

        try {
            // 1. URL 객체 생성 및 연결 설정
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000); // 연결 타임아웃 5초
            conn.setReadTimeout(5000);    // 읽기 타임아웃 5초

            // 2. 응답 코드 확인 (200 OK 인지 체크)
            int responseCode = conn.getResponseCode();
            StringBuilder  response = new StringBuilder();

            if (responseCode == 200) {
                // 3. 입력 스트림을 통해 데이터 읽기
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                String inputLine;


                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 4. 결과 출력
                System.out.println("응답 성공!");
                System.out.println(response.toString());

            } else {
                System.out.println("호출 실패. 응답 코드: " + responseCode);
            }

            conn.disconnect();

            // 도전 문제 1. 파싱 처리 직접

            // 출력 값
            // 상태: 맑음
            // 기온: 18.5도
            // 습도: 42%
            // 풍속: 2.1m/s

            Gson gson = new Gson();
            WeatherDTO weatherDTO = gson.fromJson(response.toString(), WeatherDTO.class);
            System.out.println("날씨: " + weatherDTO.getWeather().get(0).getDescription());
            System.out.println("기온: " + weatherDTO.getMain().getTemp() + "°C");
            System.out.println("습도: " + weatherDTO.getMain().getHumidity() + "%");
            System.out.println("풍속: " + weatherDTO.getWind().getSpeed() + "m/s");

            // 간단한 날씨 알림 로직
            // 만약 25도보다 크다면 오늘 덥다.
                if(weatherDTO.getMain().getTemp() > 25) {
                    System.out.println("오늘 더움");
                } else {
                    System.out.println("오늘 쌀쌀함");
                }
            // 그 이하라면 날씨가 쌀쌀합니다.
            // 오늘은 날씨가 따뜻하네요. 산책하기 좋아요!

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
