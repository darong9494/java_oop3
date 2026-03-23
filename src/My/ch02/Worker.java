package My.ch02;

/**
 * 기본 문법 복습
 * 1. 상속을 사용해서 스레드를 만들 수 있다. (작업자 만들기)
 */
public class Worker extends Thread{

    private String name;

    public Worker(String name) {
        this.name = name;
    }

    // 약속되어 있는 부분 run()안에 해야할 일을 정의한다.
    // start() 입력하면 run()안에 있는게 실행됨


    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            // int i = 0; >> i라는 숫자를 0부터 시작해서 / i가 50보다 작은 동안에
            // 즉 49까지 한번 실행할때 마다 1씩 증가시키면서 반복해라는 말.
            System.out.print("worker " + name + " : " + i + "\n");
            // 이름이 name인 일꾼이 0부터 49까지 숫자를 하나씩 세며 총 50번을 화면에 출력하라는말.
            try {
                Thread.sleep(1000);
                // 현재 실행중인 스레드를 딱 1초동안 일시 정지 시켜라
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
