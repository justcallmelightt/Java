/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 7번 문제 - 가변 인자 합산 (VarargsCalculatorPractice.java)
 *
 * 문제 조건:
 * 1. 가변 인자를 사용하는 Calculator 클래스를 작성하시오.
 * 2. - sum(int... nums) : 전달된 모든 int의 합 반환
 * 3. - average(int... nums) : 전달된 모든 int의 평균 반환 (double)
 * 4. 단, 인자가 없으면 0.0을 반환한다.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 가변 인자를 사용해 호출 시 전달되는 인자 수를 유연하게 처리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Calculator {
    static int sum(int... nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }

    static double average(int... nums) {
        if (nums.length == 0) {
            return 0.0;
        }
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return (double) total / nums.length;
    }
}

public class VarargsCalculatorPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        System.out.println(Calculator.sum(1, 2, 3));
        System.out.println(Calculator.sum(1, 2, 3, 4, 5));
        System.out.println(Calculator.average());
        System.out.println(Calculator.average(2, 3, 4, 5));
    }
}
