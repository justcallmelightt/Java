/**
 * [프로그래밍 자바 실무] - 자기주도학습
 *
 * 주제: 부모 메서드 호출과 메서드 재정의
 *
 * 학습 조건:
 * 1. Vehicle 클래스에 move() 메서드를 정의한다.
 * 2. Bus가 Vehicle을 상속하고 move()를 재정의한다.
 * 3. 재정의한 메서드 안에서 super.move()를 호출한다.
 * 4. 부모 타입 변수로 Bus 객체를 참조하여 실행 결과를 확인한다.
 *
 * 학습 목표:
 * 1. @Override가 재정의 오류를 확인하는 안전장치임을 이해한다.
 * 2. super를 이용해 부모 구현을 재사용한다.
 * 3. 참조 변수 타입과 실제 객체 타입의 차이를 확인한다.
 */
class Vehicle {
    void move() {
        System.out.println("이동 준비를 합니다.");
    }
}

class Bus extends Vehicle {
    @Override
    void move() {
        // 공통 준비 과정은 부모 메서드를 호출해 재사용한다.
        super.move();
        System.out.println("버스가 정류장을 향해 이동합니다.");
    }
}

public class VehicleOverridePractice {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        // 변수의 타입은 Vehicle이지만 실제 Bus 객체의 move()가 실행된다.
        vehicle.move();
    }
}
