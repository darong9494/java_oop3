package My.ch03;
// 코드를 사용하는 측
public class StudentMainTest1 {
    // 메인 함수
    public static void main(String[] args) {
        // Heap 메모리에 올라감
        Student studentKim = new Student();
        // studentKim 이라는 사람을 생성
        studentKim.studentId = 1;
        // studentKim의 학번은 1번이다.
        studentKim.studentName = "김길동";
        studentKim.address = "부산시 진구";
        // studentKim.studentName = "홍길동"; // 이 시점에 값 변경

        studentKim.study(); // 메소드를 호출했다. 행위
        studentKim.breakTime(); // 메소드 호출함

        System.out.println("------------------------");
        Student studentLee = new Student();
        // studentLee 라는 사람을 생성
        studentLee.studentId = 2;
        studentLee.studentName = "마이콜";
        studentLee.address = "부산시 해운대구";

        studentLee.study();
        studentLee.breakTime();

        System.out.println("-----------------");
        // 각 객체의 상태 값 출력해보기
        studentKim.showInfo();
        studentLee.showInfo();
    } // end of main function

    // 함수란
    // 자바에서 함수란 객체와 상관없이 독립적으로 기능을 수행하는 일련의 코드 묶음이다.
    public static double addDouble(double n1, double n2) {
        return n1 + n2;
    }
}
