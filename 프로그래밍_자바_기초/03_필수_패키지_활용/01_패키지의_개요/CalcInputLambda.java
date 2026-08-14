// CalcInputLambda.java
// 주제: "혼자 해 보기" 풀이 - 정수 두 개를 입력받아 사칙연산을 람다식으로 작성
// 조건: import 문을 사용하지 않는다

package pack01;

// 함수적 인터페이스: 매개변수 2개(int, int)를 받아 int를 반환하는 계산 규칙
interface Operation {
    int calc(int a, int b);
}

public class CalcInputLambda {

    public static void main(String[] args) {

        // ================================================================
        // 1. import 없이 FQCN으로 Scanner 사용 (조건: import 금지)
        // ================================================================
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("첫 번째 정수 입력:");
        int a = sc.nextInt();
        System.out.println("두 번째 정수 입력:");
        int b = sc.nextInt();

        System.out.println();


        // ================================================================
        // 2. 사칙연산 하나하나를 람다식으로 정의
        //    Operation 인터페이스에 정의된 calc(int, int) 를
        //    각기 다른 동작으로 채워 넣는다고 생각하면 된다
        // ================================================================
        Operation add = (x, y) -> x + y;
        Operation sub = (x, y) -> x - y;
        Operation mul = (x, y) -> x * y;

        // 나눗셈은 0으로 나누는 경우를 방어해야 하므로 중괄호 + return 형태로 작성
        Operation div = (x, y) -> {
            if (y == 0) {
                System.out.println("(0으로 나눌 수 없어 0을 반환합니다)");
                return 0;
            }
            return x / y;
        };


        // ================================================================
        // 3. 각 연산 결과 출력 - calc() 호출부만 보면 사칙연산인지 알 수 없다
        //    (add, sub, mul, div는 전부 같은 타입 Operation, 내부 동작만 다름)
        //    → 이게 람다/함수적 인터페이스를 쓰는 핵심 이유:
        //      "무엇을 계산할지"를 변수처럼 다룰 수 있다
        // ================================================================
        System.out.println(a + " + " + b + " = " + add.calc(a, b));
        System.out.println(a + " - " + b + " = " + sub.calc(a, b));
        System.out.println(a + " * " + b + " = " + mul.calc(a, b));
        System.out.println(a + " / " + b + " = " + div.calc(a, b));
    }
}
