package My.ch02;

/**
 * 스레드를 사용하는 문법
 * 2번째 - Runnable 인터페이스를 구현해서 스레드를 만들 수 있다.
 */
public class Worker2 implements Runnable{
    // run() >> 위임 시키고자 하는 일 명시하는 곳
    // 실행은 Thread().start()로 호출해야 여기 부분이 일을 한다.

    @Override
    public void run() {
        int i;
        for (i = 0; i < 200; i++) {
            // i가 0부터 시작해서 199번까지 하나씩 출력하면서 1씩 증가시킴
            System.out.print(i + "\t");
            // \t >> 일정한 간격 띄우기
        }
    }
}
