/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 22번 문제 - this 생성자 체인 (RectangleConstructorChainPractice.java)
 *
 * 문제 조건:
 * 1. 가로(width), 세로(height), 색상(color) 필드를 가진 Rectangle 클래스를 작성하시오.
 * 2. 조건1. 매개변수 3개짜리 생성자 작성 (width, height, color)
 * 3. 조건2. 매개변수 2개짜리 생성자(width, height)는 this()로 3개짜리를 호출하되 color는 "흰색"
 * 4. 조건3. 기본 생성자는 this()로 2개짜리를 호출하되 width=1, height=1
 * 5. 조건4. getInfo()는 "가로:N 세로:N 색상:N" 형태 반환
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 조건문으로 잘못된 입력과 경계 상황을 검사한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Rectangle {
    int width;
    int height;
    String color;

    Rectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    Rectangle(int width, int height) {
        this(width, height, "흰색");
    }

    Rectangle() {
        this(1, 1);
    }

    String getInfo() {
        return "가로:" + width + " 세로:" + height + " 색상:" + color;
    }
}

public class RectangleConstructorChainPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(5, 3);
        Rectangle r3 = new Rectangle(4, 6, "파란색");
        System.out.println(r1.getInfo());
        System.out.println(r2.getInfo());
        System.out.println(r3.getInfo());
    }
}
