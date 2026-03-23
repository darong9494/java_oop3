package My.ch02;

public class WorkerMain2 {
    public static void main(String[] args) {
        System.out.println("main thread start");
        Worker2 worker2 = new Worker2(); // 메인 스레드가 서브 스레드 생성
        // worker2.start();
        // worker2.run(); // run() 메소드는 그냥 메소드를 호출할 뿐 스레드를 동작시킨건 아니다.
        // 익명 클래스
        new Thread(worker2).start(); // 서브 작업자가 일을 시작함
        System.out.println("main thread end");
    }
}
