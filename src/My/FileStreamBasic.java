package My;


import java.io.FileWriter;

public class FileStreamBasic {
    // 파일에 텍스트를 쓰는 메소드 (문자 기반 스트림 사용)
    public static void main(String[] args) {


        } // end of main

    // 파일에 텍스트를 쓰는 메소드 (문자 기반 스트림 사용)
    public static void writeToFile(String fileName) {
        /**
         * FileWriter는 문자 기반 출력 스트림이다.
         * FileReader 이것도 문자기반으로 읽겠다..
         * 안녕에 '안'은  한글 한글자당 3바이트이고
         * inputStream inputStream은 1바이트니까 깨짐현상 일어남
         * 그래서 inputStreamReader를 써서 깨짐현상을 방지해야함
         * FileReader >> 바이트를 문자로 변환시켜야됨 >> 보조스트림이 기능향상 (Buffered)
         *
         *
         */
    }

    }

