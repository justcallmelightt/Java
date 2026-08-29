/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 11번 문제 - static 카운터 + 배열 출력 (응용) (RobotCounterPractice.java)
 *
 * 문제 조건:
 * 1. 이름(name)과 private static 필드 count를 가진 Robot 클래스를 작성하시오.
 * 2. 생성될 때마다 count 증가, 이름은 "로봇-N" 형식으로 자동 부여된다.
 * 3. Robot 10개를 배열에 생성하고 홀수 번호 로봇만 출력하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 * 3. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 * 4. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Robot {
    private static int count = 0;
    private String name;

    Robot() {
        count++;
        this.name = "로봇-" + count;
    }

    String getName() {
        return name;
    }

    static int getCount() {
        return count;
    }
}

public class RobotCounterPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Robot[] robots = new Robot[10];
        for (int i = 0; i < robots.length; i++) {
            robots[i] = new Robot();
        }
        for (int i = 0; i < robots.length; i++) {
            if ((i + 1) % 2 != 0) {
                System.out.println(robots[i].getName());
            }
        }
        System.out.println("전체 생성 수: " + Robot.getCount());
    }
}
