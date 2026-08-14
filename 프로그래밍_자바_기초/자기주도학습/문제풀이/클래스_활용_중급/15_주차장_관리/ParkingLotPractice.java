/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 15번 문제 - 클래스 설계 종합 (응용) (ParkingLotPractice.java)
 *
 * 문제 조건:
 * 1. 주차장 관리 프로그램을 작성하시오.
 * 2. ParkingLot 클래스:
 * 3. - private static final int MAX_CAPACITY = 5
 * 4. - private int currentCount = 0
 * 5. - enter() : 입차. 만차면 "만차입니다. (정원: 5대)" 출력
 * 6. - exit() : 출차. 비어있으면 "주차된 차량이 없습니다." 출력
 * 7. - getStatus() : "현재 N대 주차 중 (여유: N대)" 반환
 * 8. - static getMaxCapacity() : MAX_CAPACITY 반환
 * 9. 반복문으로 7번 입차 시도, getStatus 출력,
 * 10. 반복문으로 3번 출차, getStatus 출력,
 * 11. 반복문으로 2번 출차 시도하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 * 3. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 * 4. final을 사용해 변경할 수 없는 값과 객체 상태를 설계한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class ParkingLot {
    private static final int MAX_CAPACITY = 5;
    private int currentCount = 0;

    void enter() {
        if (currentCount >= MAX_CAPACITY) {
            System.out.println("만차입니다. (정원: " + MAX_CAPACITY + "대)");
            return;
        }
        currentCount++;
    }

    void exit() {
        if (currentCount <= 0) {
            System.out.println("주차된 차량이 없습니다.");
            return;
        }
        currentCount--;
    }

    String getStatus() {
        return "현재 " + currentCount + "대 주차 중 (여유: " + (MAX_CAPACITY - currentCount) + "대)";
    }

    static int getMaxCapacity() {
        return MAX_CAPACITY;
    }
}

public class ParkingLotPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();
        for (int i = 0; i < 7; i++) {
            lot.enter();
        }
        System.out.println(lot.getStatus());
        for (int i = 0; i < 3; i++) {
            lot.exit();
        }
        System.out.println(lot.getStatus());
        for (int i = 0; i < 2; i++) {
            lot.exit();
        }
    }
}
