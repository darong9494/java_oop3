package My.ch03;

// 클래스를 설계하는 측 코드
// ** 객체의 속성은 멤버 변수로 객체의 기능은 메소드로 구현한다.
public class Student {
    // 멤버 변수
    int studentId;
    String studentName;
    String address;

    // 메소드 정의
    public void study() {
        System.out.println(studentName + "학생이 공부를 한다.");
    }

    public void breakTime() {
        System.out.println(studentName + "학생이 휴식을 취한다.");
    }

    public void showInfo() {
        // showInfo에 밑에 내용을 보여주겠다.
        System.out.println("---상태창---");
        System.out.println("학생의 이름: " + studentName);
        System.out.println("학생의 학번: " + studentId);
        System.out.println("학생의 주소: " + address);
    }
    // 메소드
    // 객체의 기능을 구현하기 위해 클래스 내부에 구현되는 함수
    // 멤버 함수라고도함
    // 메소드를 구현함으로써 객체의 기능이 구현된다.
    // tip - 메소드는 보통 멤버 변수를 활용해서 기능이 구현된다.

    // 1. 시험을 친다. (반환값 없음 간단히 콘솔에 출력)
    public void taketest() {
        System.out.println(studentName + "시험을 친다.");
    }

    // 2. 청소를 한다.
    public void cleanUp() {
        System.out.println(studentName + "청소를 한다.");
    }
    // 3. 학생의 자신의 이름을 반환한다.
    public String getStudentName() {
        // getStudentName >> 메소드 이름. get + 변수명 >> 학생 이름을 가져오겠다.라는 뜻
        return studentName;
        // 어디서든 호출할 수 있으며 실행하면 저장되어 있는 학생의 이름을 문자열로 돌려주는 return 기능이다.
    }
    // 4. 학생의 자신의 주소를 반환한다.
    public String getAddress() {
        return address;
    }
    // 5. 학생 자신의 번호를 반환하는 메소드를 만들어라
    public int getStudentId() {
        // 학번 숫자니까 int
        return studentId; // 정수로 돌려주는 return 기능이다.
    }
}
