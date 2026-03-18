package io.ch13;

public class MySystemln3 {
    public static void main(String[] args) {
        // println : 출력하고 줄바꿈
        System.out.println("안녕");
        System.out.println("자바");

// print : 줄바꿈 없이 이어서 출력
        System.out.print("안녕");
        System.out.print("자바");

// printf : 형식을 지정해서 출력 (%s = 문자열, %d = 정수)
        System.out.printf("이름: %s, 나이: %d살%n", "홍길동", 20);
    }
}
