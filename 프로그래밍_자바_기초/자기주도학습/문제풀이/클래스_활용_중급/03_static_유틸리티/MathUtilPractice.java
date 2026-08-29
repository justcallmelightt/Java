/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 3번 문제 - static 메서드 작성 (MathUtilPractice.java)
 *
 * 문제 조건:
 * 1. MathUtil 클래스를 작성하시오.
 * 2. 모든 메서드는 static이며 객체 생성 없이 호출 가능하다.
 * 3. - max(int a, int b) : 더 큰 값 반환
 * 4. - min(int a, int b) : 더 작은 값 반환
 * 5. - abs(int n) : 절댓값 반환
 * 6. - isEven(int n) : 짝수면 true 반환
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class MathUtil {
    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }

    static int abs(int n) {
        return n < 0 ? -n : n;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }
}

public class MathUtilPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        System.out.println(MathUtil.max(7, 10));
        System.out.println(MathUtil.min(3, 9));
        System.out.println(MathUtil.abs(-5));
        System.out.println(MathUtil.isEven(4));
        System.out.println(MathUtil.isEven(7));
    }
}
