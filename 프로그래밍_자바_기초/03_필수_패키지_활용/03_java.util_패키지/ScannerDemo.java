// ScannerDemo.java
// 주제: Scanner 클래스 - 콘솔에서 다양한 타입의 값을 입력받기

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {

        // ================================================================
        // 1. Scanner 객체 생성
        // ================================================================
        // System.in은 "화면(키보드)에서 입력을 받겠다"는 뜻의 표준 입력 스트림이다.
        // Scanner는 그 입력을 byte 단위가 아니라 원하는 타입(int, String 등)으로
        // 바로 읽을 수 있게 변환해주는 도구다.
        Scanner sc = new Scanner(System.in);

        // ================================================================
        // 2. 문자열 입력 - next() vs nextLine()
        // ================================================================
        // next()     : 공백(띄어쓰기) 전까지만 읽는다 (토큰 하나)
        // nextLine() : 개행(Enter) 전까지 전부 읽는다 (공백 포함 한 줄 전체)
        System.out.print("이름(한 단어): ");
        String name = sc.next();          // 예: "Happy" 입력

        System.out.print("한 줄 소개(공백 포함): ");
        sc.nextLine();                    // ⚠ next()가 남긴 줄바꿈(Enter)까지만 읽고 버리는 용도
        String intro = sc.nextLine();     // 예: "저는 자바를 배우는 중입니다" 입력

        System.out.println();

        // ================================================================
        // 3. 숫자/불리언 입력
        // ================================================================
        System.out.print("나이(int): ");
        int age = sc.nextInt();

        System.out.print("키(double, cm): ");
        double height = sc.nextDouble();

        System.out.print("재학중 여부(true/false): ");
        boolean isStudent = sc.nextBoolean();

        System.out.println();

        // ================================================================
        // 4. 입력받은 값 출력
        // ================================================================
        System.out.println("=== 입력 결과 ===");
        System.out.println("이름: " + name);
        System.out.println("소개: " + intro);
        System.out.println("나이: " + age);
        System.out.println("키: " + height);
        System.out.println("재학중: " + isStudent);
    }
}
