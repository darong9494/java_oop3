package http.jason;

public class NotJasonEx2 {
    public static void main(String[] args) {
        String json = "{\"userId\": 1,\"id\": 1,\"title\": \"quidem molestiae enim\"}";
        // JSON 형식에 문자열을 파싱해서 Album 객체로 변환해 보자.
        // 1단계 : 불필요한 기호 제거 (replace)
        String step1 = json.replace("{","").replace("}","");
        System.out.println(step1);

        // 2단계 : 항목별 자르기 (split)
        String[] parts = step1.split(",");
        System.out.println("size: " + parts.length);
        System.out.println(parts[0]);
        System.out.println(parts[1]);
        System.out.println(parts[2]);

        // 3단계 : 데이터 추출 및 할당
        String nameValue = (parts[0].split(":"))[1];
        // 0번째 userId : 1 에서 / userId = 0번째 , 1은 1번째. 그래서 1을 추출해냄
        System.out.println(nameValue);
        String nameValue1 = (parts[1].split(":"))[0];
        System.out.println(nameValue1);
        String nameValue2 = (parts[2].split(":"))[1];
        System.out.println(nameValue2);

    } // end of main
} // end of class

class Album1 {
    int userId;
    int id;
    String title;

    public Album1(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Album{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}