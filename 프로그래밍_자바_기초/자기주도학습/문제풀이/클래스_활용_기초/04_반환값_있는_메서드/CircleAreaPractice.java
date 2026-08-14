/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 4번 문제 - 반환값 있는 메서드 (CircleAreaPractice.java)
 *
 * 문제 조건:
 * 1. 반지름(radius) 필드를 가진 Circle 클래스를 정의하시오.
 * 2. 넓이를 계산해서 반환하는 getArea() 메서드를 작성하시오. (PI = 3.14)
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Circle {
    double radius;

    double getArea() {
        return 3.14 * radius * radius;
    }
}

public class CircleAreaPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 5;
        System.out.println("원의 넓이: " + c.getArea());
    }
}
