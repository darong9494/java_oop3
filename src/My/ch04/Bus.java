package My.ch04;

public class Bus {
    int busId;
    String busType;
    String company;

    // 생성자 만들기
    public Bus() {}

    // 생성자 - 파라메터 1개를 받는 생성자
    public Bus(int id) {
        busId = id;
    }

    // 생성자 - 파라메터 2개를 받는 생성자
    public Bus(int id, String type) {
        busId = id;
        busType = type;
    }

    // 생성자 하나이상이면 생성자 오버로딩이라고 부를 수 있다.
    public Bus(int id, String type, String name) {
        busId = id;
        busType = type;
        company = name;
    }
} // end of class
