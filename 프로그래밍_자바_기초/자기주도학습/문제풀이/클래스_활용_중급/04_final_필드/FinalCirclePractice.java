/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 4번 문제 - final 필드 (FinalCirclePractice.java)
 *
 * 문제 조건:
 * 1. final 필드 PI와 radius를 가진 Circle 클래스를 작성하시오.
 * 2. - PI는 선언 시 3.14159로 초기화
 * 3. - radius는 생성자에서 초기화
 * 4. - getArea() : 넓이 반환
 * 5. - getCircumference() : 둘레 반환 (2 * PI * radius)
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. final을 사용해 변경할 수 없는 값과 객체 상태를 설계한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Circle {
    private final double PI = 3.14159;
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return PI * radius * radius;
    }

    double getCircumference() {
        return 2 * PI * radius;
    }
}

public class FinalCirclePractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Circle c = new Circle(5);
        System.out.println("넓이: " + c.getArea());
        System.out.println("둘레: " + c.getCircumference());
    }
}
