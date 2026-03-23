package My.myEx;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ScoreRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===시험 정수 기록기===");
        System.out.println("1. 점수 보기");
        System.out.println("2. 점수 저장");
        System.out.print("선택 : ");
        String choice = sc.nextLine();


        if(choice.equals("1")) {
            readScore();
        } else if (choice.equals("2")) {
            readScore();
        }

        sc.close(); // 메모리 누수 방지
    }

    private static void readScore() {
        try(FileInputStream in = new FileInputStream("scores.txt")) {
            // 파일에서 더이상 읽을 데이터가 없으면 -1을 반환
            int readData; // 한 바이트씩 데이터를 읽을 메모리 공간 선언

            while((readData = in.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
