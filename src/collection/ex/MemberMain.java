package collection.ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 메인해서 실행해보기
public class MemberMain {
    private static List<Member> members = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("---회원 관리 시스템---");
            System.out.println("전체 회원: " + members.size() + "명");
            System.out.println("1. 가입 2. 조회 3. 전체목록 4. 수정 5. 삭제 0. 종료 \n선택: ");
            String menu = sc.next();

            switch (menu) {
                case "1": create(); break;
                case "2": read(); break;
                case "3": readAll(); break;
                case "4": update(); break;
                case "5": delete(); break;
                case "0": return;
                default:
                    System.out.println("잘못된 선택이다.");
            }
        }
    } // end of main

    // 1. 회원가입
    private static void create() {
        System.out.println("이름: "); String name = sc.next();
        System.out.println("이메일: "); String email = sc.next();

        // 이메일 중복체크
        for(Member m : members) {
            if(m.getEmail().equals(email)) {
                System.out.println("이미 사용중인 이메일이다: " + email);
                return;
            }
        }

        System.out.println("나이: "); int age = sc.nextInt();
        Member newMember = new Member(nextId++, name, email, age);
        members.add(newMember);
        System.out.println("회원가입 완료: " + name + "ID: " + (nextId -1));
    }

    // 2,  회원조회
    private static void read() {
        System.out.println("조회할 ID: "); int id = sc.nextInt();
        for (Member m : members) {
            if(m.getId() == id) {
                System.out.println("조회 결과: " + m);
                return;
            }
            System.out.println("ID 찾을수 없다.");
        }
    }

    // 3. 전체 목록
    private static void readAll() {
        System.out.println("---전체 회원 목록---");
        if(members.isEmpty()) System.out.println("등록된 회원이 없다.");
        else members.forEach(System.out::println);
    }

    // 4. 회원 수정
    private static void update() {
        System.out.println("수정할 ID: "); int id = sc.nextInt();
        for(Member m : members) {
            if (m.getId() == id) {
                System.out.println("새 이름: "); m.setName(sc.next());
                System.out.println("새 나이: "); m.setAge(sc.nextInt());
                System.out.println("수정됨:" + m);
                return;
            }
        }
        System.out.println("해당 ID 찾을 수 없다.");
    }

    // 5. 회원 삭제
    private static void delete() {
        System.out.println("삭제할 ID: "); int id = sc.nextInt();

    }
} // end of class
