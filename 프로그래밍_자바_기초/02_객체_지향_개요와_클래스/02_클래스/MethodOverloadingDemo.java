// MethodOverloadingDemo.java
class Printer {
    // ================================================================
    // 1. 기본 오버로딩 — 매개변수 타입이 다른 경우
    // ================================================================
    void print(int value) {
        System.out.println("int: " + value);
    }

    void print(double value) {
        System.out.println("double: " + value);
    }

    void print(String value) {
        System.out.println("String: " + value);
    }

    // ================================================================
    // 2. 매개변수 개수가 다른 경우
    // ================================================================
    void print(String label, int value) {
        System.out.println(label + ": " + value);
    }

    void print(String label, int value, String unit) {
        System.out.println(label + ": " + value + unit);
    }

    // ================================================================
    // 3. 반환 타입만 다른 건 오버로딩이 아니다 → 컴파일 에러
    // ================================================================
    // int getValue()    { return 1; }
    // double getValue() { return 1.0; } // 컴파일 에러: 반환 타입은 오버로딩 기준이 아님
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();

        // 컴파일러가 인수 타입을 보고 적절한 메서드를 자동 선택
        printer.print(10);           // int 버전 호출
        printer.print(3.14);         // double 버전 호출
        printer.print("Hello");      // String 버전 호출
        printer.print("나이", 25);   // 2개 버전 호출
        printer.print("온도", 37, "°C"); // 3개 버전 호출

        System.out.println();

        // ================================================================
        // 4. 자동 형변환과 오버로딩 — 예상과 다른 메서드가 호출될 수 있다
        // ================================================================
        printer.print('A');
        // char → int 자동 형변환 → int 버전 호출
        // 출력: int: 65  (문자 'A'의 ASCII 코드값)

        // long, float 버전이 없으면 더 큰 타입으로 자동 형변환
        // printer.print(100L); // long → double 버전으로 형변환되어 호출됨
    }
}
