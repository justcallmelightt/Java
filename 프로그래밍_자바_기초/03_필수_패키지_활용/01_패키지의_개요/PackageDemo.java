// PackageDemo.java
// 주제: 패키지(package)의 개념

package pack01;

public class PackageDemo {
    public static void main(String[] args) {
        // 1. 패키지 선언 확인
        // 이 클래스는 pack01 패키지에 속한다.
        // 컴파일된 .class 파일은 pack01 디렉터리 안에 위치해야 한다.
        System.out.println("현재 클래스: " + PackageDemo.class.getName());
        // 출력: pack01.PackageDemo  ← 패키지명이 포함된 전체 이름(FQCN)

        System.out.println();

        // 2. import 없이 java.lang 패키지는 자동 사용 가능
        String s = "java.lang은 자동 import됨";
        System.out.println(s);

        // 3. 다른 패키지의 클래스는 import 필요
        // java.util.Scanner, java.util.Random 등
        java.util.Random r = new java.util.Random();  // 완전한 이름(FQCN)으로 직접 사용
        System.out.println("import 없이 FQCN으로 접근: " + r.nextInt(10));

        System.out.println();

        // 4. 실수 포인트 - 같은 이름의 클래스가 다른 패키지에 있을 때
        // java.util.Date 와 java.sql.Date 는 이름은 같지만 다른 클래스
        // → 둘 다 import하면 컴파일 오류, 하나는 FQCN으로 써야 함
        java.util.Date now = new java.util.Date();
        System.out.println("java.util.Date: " + now);
    }
}
