package collection.set;

import java.util.*;

public class LottoGame {
    public static void main(String[] args) {
        Set<Integer> lotto = new HashSet<>();
        Random random = new Random();

        // 6개가 될때까지 계속 추가
        while(lotto.size() < 6) {
            int number = random.nextInt(45) + 1; // 1~45
            lotto.add(number);
        }
        System.out.println("이번 주 로또 번호: " + lotto);
        System.out.println("총 " + lotto.size() + "개");

        // 로또 번호를 오름차순으로 정렬하세요.
        // ArrayList 생성자 안에 set 계열을 넣으면 자동으로 ArrayList 객체를 생성해 준다.
        List<Integer> lotto2 = new ArrayList<>(lotto);
        Collections.sort(lotto2);
        System.out.println("정렬된 번호: " + lotto2);
    } // end of main
} // end of class
