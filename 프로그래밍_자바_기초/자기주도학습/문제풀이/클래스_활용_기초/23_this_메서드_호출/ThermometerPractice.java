/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 23번 문제 - this로 내부 메서드 호출 (ThermometerPractice.java)
 *
 * 문제 조건:
 * 1. 온도(temperature), 단위(unit, 'C' 또는 'F') 필드를 가진 Thermometer 클래스를 작성하시오.
 * 2. - 매개변수 생성자로 초기화
 * 3. - toCelsius() : 단위가 'F'면 섭씨로 변환해서 반환, 이미 'C'면 그대로 반환
 * 4. (변환 공식: (F - 32) * 5 / 9.0)
 * 5. - toFahrenheit() : 단위가 'C'면 화씨로 변환해서 반환, 이미 'F'면 그대로 반환
 * 6. (변환 공식: C * 9 / 5.0 + 32)
 * 7. - printBoth() : this.toCelsius()와 this.toFahrenheit()를 호출해서 둘 다 출력
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Thermometer {
    double temperature;
    char unit;

    Thermometer(double temperature, char unit) {
        this.temperature = temperature;
        this.unit = unit;
    }

    double toCelsius() {
        if (unit == 'F') {
            return (temperature - 32) * 5 / 9.0;
        }
        return temperature;
    }

    double toFahrenheit() {
        if (unit == 'C') {
            return temperature * 9 / 5.0 + 32;
        }
        return temperature;
    }

    void printBoth() {
        System.out.println("섭씨: " + this.toCelsius() + "°C / 화씨: " + this.toFahrenheit() + "°F");
    }
}

public class ThermometerPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Thermometer t1 = new Thermometer(100, 'C');
        Thermometer t2 = new Thermometer(98.6, 'F');
        t1.printBoth();
        t2.printBoth();
    }
}
