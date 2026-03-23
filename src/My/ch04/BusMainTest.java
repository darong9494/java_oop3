package My.ch04;

public class BusMainTest {
    // 메인함수
    public static void main(String[] args) {
        // 참조 타입(주소값 담고있음)
        // 객체를 생성시킬 때 호출하는 자. (모양 맞춰야 한다. / 파라메터 순서도 지킬것)

        Bus b1 = new Bus(133);
        System.out.println(b1); // b1은 Bus의 주소값이다.
        System.out.println(b1.busId); // b1주소값안에 busId를 호출하겠다. 결과값 133나옴

        System.out.println("----------------");
        Bus b2 = new Bus(100,"시내"); // 파라메터 순서대로
        System.out.println(b2); // b2 주소값나옴
        System.out.println(b2.busId + ", " + b2.busType); // b2 쩜.안에 busId를 불러와

        System.out.println("--------------");
        Bus b3 = new Bus(300,"시외", "한일");
        System.out.println(b3); // 주소값 불러옴
        System.out.println(b3.busId + ", " + b3.busType + ", " + b3.company);

        System.out.println("---------------");

        // 생성자의 좋은점

        Bus b4 = new Bus();
        b4.busId = 400;
        b4.busType = "시외";
        b4.company = "부일";
        // 일일이 하나씩 입력해야되서
        // 바로 System.out.println(b4.busId + ", " + b4.busType + ", " + b4.company);
        // 이렇게 써주면 편하다.
    } // end of main
} // end of class
