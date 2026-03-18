package io.ch17_1.array;

import java.util.ArrayList;

public class ArrayListEx2 {
    public static void main(String[] args) {
        // 정수, 실수 , 불리언, 사용자 정의 객체를 담을 수 있는 ArrayList 각각 만들어서 사용

        // 정수 Integer >> 정수의 상위 class
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        // 조회하는 기능
        System.out.println(list.get(0));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        // 편의기능
        System.out.println("현재 ArrayList의 길이: " + list.size());
        list.contains(1);
        System.out.println(list.contains(2));
        System.out.println(list.isEmpty()); // 리스트가 비어있는지 확인하는거.

        // 실수 Double >> 실수의 상위 class
        ArrayList<Double> list1 = new ArrayList<>();

        list1.add(0.1);
        list1.add(0.2);
        list1.add(0.3);

        // 조회하는 기능
        System.out.println(list1.get(0)); // 0번째 배열을 찾아서 입력해라
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        // 편의기능
        System.out.println("현재 ArrayList의 길이: " + list.size());
        list.contains(0.3);
        System.out.println(list.contains(0.2));
        System.out.println(list.isEmpty()); // 리스트가 비었는지 확인한다.

        // 불리언
        ArrayList<Boolean> list2 = new ArrayList<>();








    }


}
