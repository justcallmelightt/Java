/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 2번 문제 - 객체 두 개 생성 (CarObjectsPractice.java)
 *
 * 문제 조건:
 * 1. 색상(color)과 속도(speed) 필드를 가진 Car 클래스를 정의하고,
 * 2. Car 객체를 두 개 생성하여 각각 다른 값을 넣고 출력하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Car {
    String color;
    int speed;
}

public class CarObjectsPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.color = "빨간색";
        c1.speed = 100;

        Car c2 = new Car();
        c2.color = "파란색";
        c2.speed = 150;

        System.out.println(c1.color + " 자동차, 속도: " + c1.speed);
        System.out.println(c2.color + " 자동차, 속도: " + c2.speed);
    }
}
