package My.myEx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class TodoList2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== To-Do 리스트 ===");
        System.out.println("1. 할 일 추가");
        System.out.println("2. 전체 목록 보기");
        System.out.println("3. 완료 처리");
        System.out.println("4. 미완료 목록만 보기");
        System.out.println("5. 완료 취소"); // [v] 자바 --> [ ] 자바
        System.out.print("선택 : ");
        String choice = sc.nextLine();
        if (choice.equals("1")) {
            addTask(sc);
        } else if(choice.equals("2")) {

        } else if (choice.equals("3")) {

        } else if (choice.equals("4")) {

        } else if(choice.equals("5")) {

        }
        sc.close();
    } // end of main

    private static void addTask(Scanner sc) {
        System.out.print("추가할 할 일을 입력하세요: ");
        String task = sc.nextLine();

        // "[ ] 할 일 내용" 형식으로 지정
        // [ ] 미완료 상태
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("todo.txt", true))) {
            bw.write("[ ]" + task);
            bw.newLine();
            System.out.println("추가됐습니다 : " + task);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
} // end of class

