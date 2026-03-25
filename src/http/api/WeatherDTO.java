package http.api;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherDTO {
    private List<Weather> weather = new ArrayList<>();
    private Main main;
    private Wind wind;
    @Data
    public static class Weather {
        private String description;
    }
    @Data
    public static class Main {
        private double temp;
        private int humidity;
    }
    @Data
    public static class Wind {
        private double speed;
    }
} // end of class
