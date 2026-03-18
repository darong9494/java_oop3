package My;

import java.io.*;

public class CharBufferedKeyboardConsole2 {
    public static void main(String[] args) throws IOException {
        /**
         * 스트림 체인 구조
         * [키보드]
         *      System.in(InputStream)
         * InputStreamReader(브릿지)
         * // BufferedRead (버퍼 + readLine() 추가)
         * [프로그램] >> 콘솔
         * BufferedWriter (버퍼 + newLine() 추가)
         *  PrintWriter
         *  System.out(PrintWriter) - 콘솔창에 출력
         */

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        // BufferedWriter bw = new BufferWhiter(new PrintWriter(System.out));
        PrintWriter pw = new PrintWriter(System.out);
        BufferedWriter bw = new BufferedWriter(pw);

        // 콘솔창의 종류 명령은 (Ctrl + D)
        System.out.println("텍스트를 입력하세요 (종료: 빈 줄 입력)");
        String line;
        while ((line = br.readLine()) != null) {
            bw.write("받은값 출력: " + line);
            bw.newLine(); // 운영체제에 맞는 줄바꿈 자동 삽입
            // \n << 리눅스, Mac
            // \r\n << 윈도우
            bw.flush(); // 버퍼의 남은 데이터 즉시 출력
        }
    } // end of main
}
