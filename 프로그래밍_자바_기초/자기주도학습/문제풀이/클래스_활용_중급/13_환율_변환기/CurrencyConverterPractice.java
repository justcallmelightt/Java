/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 13번 문제 - final + static + 반복문 (응용) (CurrencyConverterPractice.java)
 *
 * 문제 조건:
 * 1. 환율 변환기 클래스 CurrencyConverter를 작성하시오.
 * 2. - public static final double USD_TO_KRW = 1350.0
 * 3. - public static final double EUR_TO_KRW = 1480.0
 * 4. - static double toKRW(double amount, double rate) : amount * rate 반환
 * 5. - static String format(double krw) : String.format으로 "N원" 형식 반환
 * 6. 달러 금액 배열 {1, 5, 10, 50, 100}을 반복문으로 원화로 출력하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 * 3. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 * 4. final을 사용해 변경할 수 없는 값과 객체 상태를 설계한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class CurrencyConverter {
    public static final double USD_TO_KRW = 1350.0;
    public static final double EUR_TO_KRW = 1480.0;

    static double toKRW(double amount, double rate) {
        return amount * rate;
    }

    static String format(double krw) {
        return String.format("%,.0f원", krw);
    }
}

public class CurrencyConverterPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        int[] dollars = {1, 5, 10, 50, 100};
        for (int i = 0; i < dollars.length; i++) {
            double krw = CurrencyConverter.toKRW(dollars[i], CurrencyConverter.USD_TO_KRW);
            System.out.println(dollars[i] + "달러 = " + CurrencyConverter.format(krw));
        }
    }
}
