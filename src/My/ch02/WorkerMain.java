package My.ch02;

public class WorkerMain {
    // 메인 스레드
    public static void main(String[] args) {
        // 사용하는 방법
        System.out.println("---main 스레드 시작---");
        System.out.println(Thread.currentThread());
        // Thread.currentThread() >> 현재 이 코드를 한줄씩 읽고 있는 스레드 객체를 찾아와라

        // 작업자 하나 만들어 내기 (만드는 일은 메인 스레드가 한다.)
        Worker worker1 = new Worker("워커1");
        // 위임받은 일을 시작해
        worker1.start();
        // 워커1이 1초간격으로 50번동안 계속 출력하는것을 반복한다.

        System.out.println("---main 스레드 종료---");
    } // end of main
} // end of class
