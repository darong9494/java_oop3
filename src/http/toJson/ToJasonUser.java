package http.toJson;

import com.google.gson.Gson;

public class ToJasonUser {
    public static void main(String[] args) {
        // 자바 객체 생성 >> 텍스트 형식인 json 변환
        User12 user12 = new User12();
        user12.setId(1);
        user12.setName("Leanne Graham");
        user12.setUsername("Bret");
        user12.setEmail("Sincere@april.biz");
        user12.getAddress().setStreet("Kulas Light");
        user12.getAddress().setSuite("Apt. 556");
        user12.getAddress().setCity("Gwenborough");
        user12.getAddress().setCity("92998-3874");
        user12.getAddress().getGeo().setLat("-37.3159");
        user12.getAddress().getGeo().setLng("81.1496");
        user12.setPhone("1-770-736-8031 x56442");
        user12.setWebsite("hildegard.org");
        user12.getCompany().setName("Romaguera-Crona");
        user12.getCompany().setCatchPhrase("Multi-layered client-server neural-net");
        user12.getCompany().setBs("harness real-time e-markets");
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user12);
        System.out.println(jsonUser);
    }
}
