package http.toJson;

import com.google.gson.Gson;

public class ToJasonUser2 {
    public static void main(String[] args) {
        User12 user12 = new User12();
        Address address = new Address();
        Geo geo = new Geo();
        Company company = new Company();

        user12.setId(1);
        user12.setName("홍길동");
        user12.setEmail("a@naver.com");
        user12.setAddress(address);
        address.setCity("부산");
        address.setStreet("중앙대로");
        user12.getAddress().setGeo(geo);
        geo.setLat("123.1");
        geo.setLng("44.5");
        user12.setCompany(company); // null point 뜨기 때문에 이렇게 써줘야함.

        user12.getCompany().setName("코리아IT");

        // 객체 >> (직렬화) JSON 텍스트 형식
        Gson gson = new Gson();
        String userJson = gson.toJson(user12); // 제이슨으로 변경해줘
        System.out.println(userJson);
    }
}
