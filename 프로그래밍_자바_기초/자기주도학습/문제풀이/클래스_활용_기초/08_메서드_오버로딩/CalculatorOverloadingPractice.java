/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 8번 문제 - 메서드 오버로딩 (CalculatorOverloadingPractice.java)
 *
 * 문제 조건:
 * 1. Calculator 클래스에 add() 메서드를 오버로딩하여 작성하시오.
 * 2. - int 두 개를 받아 합을 반환
 * 3. - int 세 개를 받아 합을 반환
 * 4. - double 두 개를 받아 합을 반환
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 매개변수가 다른 동명 메서드 또는 생성자를 구분해 호출한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class CalculatorOverloadingPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(1, 2));
        System.out.println(calc.add(1, 2, 3));
        System.out.println(calc.add(2.5, 3.0));
    }
}
