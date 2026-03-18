package io.ch14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream {
    public static void main(String[] args) {
        // 파일을 바이트 단위로 읽어 들이는 스트림
        FileInputStream in = null;
        int readData;
        try {
            // 다른 코드가 더 있다면 수행이 안될수도 있음. null 스트림 닫는 작업할때
            in = new FileInputStream("a.txt");
            //  첫번째 바이트 읽기
            readData = in.read();
            System.out.println("readData: " + readData);
            System.out.println("readData: " + (char)readData);

            //  두번째 바이트 읽기
            readData = in.read();
            System.out.println("readData: " + readData);
            System.out.println("readData: " + (char)readData);

            //  세번째 바이트 읽기
            readData = in.read();
            System.out.println("readData: " + readData);
            System.out.println("readData: " + (char)readData);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // 주의 여기서 in.close() 를 하지않으면
        // 즉, 스트림을 닫지 않으면 파일이 계속 열린 상태로 메모리 누수가 생긴다.
    }
}
