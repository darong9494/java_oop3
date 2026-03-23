package collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapEx {
    public static void main(String[] args) {
        // 학생 이름, 정수
        Map<String, Integer> scores = new HashMap<>();

        // 추가 (put)
        scores.put("철수",90);
        scores.put("영희",85);
        scores.put("민준",92);

        // 조회 (get)
        System.out.println(scores.get("철수")); // 90 - 키값으로 접근하면 value가 나옴
        System.out.println(scores.get("없는값")); // null

        // 포함 여부
        System.out.println(scores.containsKey("영희")); // 영희라는 key값은 있어
        System.out.println(scores.containsValue(85)); // 있는 값
        System.out.println(scores.containsValue(10)); // 없는 값 false

        // 삭제
        scores.remove("민준");

        // 크기
        scores.size();

        // put()은 덮어씌우기도 한다.
        scores.put("철수",0); // 덮어쓰기됨

        System.out.println(">>> " + scores.keySet());
        System.out.println(scores); // Map 계열을 표시

        for(String name : scores.keySet()) {
            // 키값을 먼저 꺼내서 Set계열을 하나씩 반복시킨다.
            System.out.println(name + ": " + scores.get(name) + "점");
        }
    } // end of main
} // end of class
