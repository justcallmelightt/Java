// LambdaExpressionDemo.java
// 주제: 람다식(Lambda Expression) 문법과 축약 단계

package pack01;

// 매개변수 1개, 반환값 없음
interface Greeting {
    void sayHello(String name);
}

// 매개변수 2개, 반환값 있음
interface Calculator {
    int calc(int a, int b);
}

public class LambdaExpressionDemo {
    public static void main(String[] args) {
        // ================================================================
        // 1. 익명 클래스 → 람다식 (축약 과정, 교재 RamdaEx3 방식)
        // ================================================================
        // 원래 방식: 익명 클래스로 구현
        Calculator calc1 = new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        };
        System.out.println("익명 클래스: " + calc1.calc(3, 4));

        // 람다식으로 축약 (본문에 문장이 여러 개일 수 있어 중괄호+return 유지)
        Calculator calc2 = (a, b) -> {
            return a + b;
        };
        System.out.println("람다 (중괄호+return): " + calc2.calc(3, 4));

        // 실행문이 한 줄뿐이면 중괄호와 return 생략 가능
        Calculator calc3 = (a, b) -> a + b;
        System.out.println("람다 (완전 축약): " + calc3.calc(3, 4));

        System.out.println();

        // ================================================================
        // 2. 매개변수 타입 생략 (런타임 시 대입값으로 자동 추론)
        // ================================================================
        Calculator calc4 = (int a, int b) -> a - b;  // 타입 명시 (가능)
        Calculator calc5 = (a, b) -> a - b;           // 타입 생략 (일반적)
        System.out.println(calc4.calc(10, 3) + " / " + calc5.calc(10, 3));

        // 실수 포인트: 타입을 생략하면 "둘 다" 생략해야 함
        // Calculator wrong = (int a, b) -> a - b;  // 컴파일 오류! 타입 표기 통일 필요

        System.out.println();

        // ================================================================
        // 3. 매개변수가 1개일 때 괄호 생략 가능
        // ================================================================
        Greeting g1 = (name) -> System.out.println("안녕, " + name);
        Greeting g2 = name -> System.out.println("안녕, " + name);  // 괄호 생략
        g1.sayHello("철수");
        g2.sayHello("영희");

        // 실수 포인트: 매개변수가 없으면 괄호 생략 불가 → 반드시 ()
        Runnable r = () -> System.out.println("매개변수 없음, 괄호 필수");
        r.run();

        System.out.println();

        // ================================================================
        // 4. 함수적 인터페이스(Functional Interface) 규칙
        // ================================================================
        // 람다식이 대입될 타입은 추상 메서드가 "정확히 1개"인 인터페이스여야 한다.
        // @FunctionalInterface 어노테이션은 추상 메서드가 2개 이상이면
        // 컴파일 시점에 미리 오류를 잡아준다. (필수는 아니지만 안전장치로 붙임)

        System.out.println("Greeting, Calculator 모두 추상 메서드 1개 → 함수적 인터페이스");

        System.out.println();

        // ================================================================
        // 5. 실수하기 쉬운 부분 - 람다가 참조하는 외부 변수
        // ================================================================
        int count = 10;
        Runnable printCount = () -> System.out.println("count = " + count);
        printCount.run();

        // count++;  // 이 줄을 살리면 컴파일 오류!
        // 람다식이 참조하는 지역변수는 사실상 final(effectively final)이어야 한다.
        // → 람다 정의 이후 값이 바뀌면 안 됨 (재할당 불가)
    }
}
