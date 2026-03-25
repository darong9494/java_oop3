package http.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AirQualityDto {

    // 클래스 안에 뭐가 있는지 확인하고 각각 넣어주기

    @Data
    public static class Response {
        // Response 안에 Header랑 Body가 있으니까 넣어주고
        private  Header header;
        private Body body;
    }
    @Data
    public static class Header {
        // Header안에 넣을거 넣고
        private String resultMsg;
        private String resultCode;
    }
    @Data
    public static class Body {
        // Body안에 items를 리스트에 넣어서 선언하기
        private int totalCount;
        private List<Item> items;
        private int pageNo;
        private int numOfRows;
    }

    @Data
    public static class Item {
        private int clearVal;
        private int sn;
        private String districtName;
        private String dataData;
        private int issueVal;
        private String issueTime;
        private String clearDate;
        private String issueDate;
        private String moveName;
        private String clearTime;
        private String issueGbn;
        private String itemCode;
        private int pageNo;
        private int numOfRows;
    }
} // end of class
