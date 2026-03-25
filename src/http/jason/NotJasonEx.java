package http.jason;

public class NotJasonEx {
    public static void main(String[] args) {
        // HTTP 통신으로 json 형식 데이터를 받았다고 가정
        // json 형식은 자바에서 문자열로 취급함
        String json = "{\"name\": \"철수\", \"age\": 25}";

        // 위 json 형식에 문자열을 우리 프로그램 내에서 사용을 하려면 파싱처리를 해야된다.

        // 1단계 : 불필요한 기호 제거(replace 사용)
        // 중괄호와 큰 따옴표 아무것도 없는 상태로 만듦 ("")
        String step1 = json.replace("{","").replace("}","");
        System.out.println(step1);

        // 2단계 : 항목별 자르기 (split 사용)
        String[] parts = step1.split(",");
        System.out.println("size : " + parts.length);
        System.out.println(parts[0]);
        System.out.println(parts[1]);

        // 3단계 : 데이터 추출 및 할당
        // 첫번째 조각에서 "name":"철수" 기준에서 철수라는 값을 추출 (:) 기준

        //String[] nameParts = parts[0].split(":"); // : 기준으로 0번째는 name, 1번째는 철수
        //String nameValue = nameParts[1]; // nameParts의 1번째는 철수다.
        // 줄여서 쓰는 코드다.
        String nameValue = (parts[0].split(":"))[1];
        // 늘여서 쓴거. nameValue는 "0번째 name:철수" 가 :기준으로 다시 name이 0이되고 1이 철수가 되니까 뒤에 1을써준것.

        System.out.println(nameValue);

        // 두번째 조각에서 "age":25에서 25를 추출
        String ageString = parts[1].split(":")[1];
        System.out.println(ageString);
        int ageValue = Integer.parseInt(ageString.trim());
        System.out.println(ageValue);

        // 4단계 : 자바프로그램에서 이해하는 데이터 타입으로 객체를 변환
        // 객체 생성
        User user = new User(nameValue, ageValue);
        System.out.println(user.toString());
    }
} // end of class

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
