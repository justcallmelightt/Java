/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 3번 문제 - void 메서드 정의 (RectangleAreaPractice.java)
 *
 * 문제 조건:
 * 1. 가로(width)와 세로(height) 필드를 가진 Rectangle 클래스를 정의하시오.
 * 2. 넓이를 계산해서 출력하는 printArea() 메서드를 작성하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Rectangle {
    int width;
    int height;

    void printArea() {
        System.out.println("넓이: " + (width * height));
    }
}

public class RectangleAreaPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.width = 5;
        r.height = 10;
        r.printArea();
    }
}
