package io.ch18;

import java.io.*;
import java.nio.Buffer;

public class FileCopyBuffered {
    public static void main(String[] args) {
        // 파일 경로 지정
        String sourceFilePath = "employees.zip";
        String destinationFilePath = "employees_copy.zip";

        // 소요 시간 측정 시작
        // 현재 시각을 나코초(10억분의 1초) 단위로 변환 1970년부터~
        long startTime = System.currentTimeMillis(); // 1000분에 1초

        // 파일 복사 기능 - 빠른 버전 (버퍼 활용)
        try (
                FileInputStream fis = new FileInputStream(sourceFilePath);
                FileOutputStream fos = new FileOutputStream(destinationFilePath);
                BufferedInputStream bfis = new BufferedInputStream(fis);
                BufferedOutputStream bfos = new BufferedOutputStream(fos)
        ){
            // 버퍼에 크기를 직접 지정해주자.
            // 1바이트가 1000개 있으면 1KB다. -1024바이트
            byte[] bytes = new byte[1024]; // 1KB 씩 읽을 버퍼 배열

            int data;
            while ((data =bfis.read(bytes)) != -1) {
                bfos.write(bytes,0,data); // 읽은 만큼 쓴다
            }
            System.out.println("파일 복사 완료");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.nanoTime(); // 끝난 시각
        // 소요 시간 계산
        long duration = endTime - startTime;
        double seconds = duration / 1_000_000_000.0; // 나노초에서 초 변환
        System.out.println("나노 초 값: " + duration);
        System.out.println("초 값: " + seconds);
    } // end of main
} // end of class
