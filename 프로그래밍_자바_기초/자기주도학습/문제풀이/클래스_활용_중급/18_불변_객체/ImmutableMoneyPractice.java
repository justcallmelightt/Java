/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 18번 문제 - 불변 객체 설계 (어려움) (ImmutableMoneyPractice.java)
 *
 * 문제 조건:
 * 1. 한 번 생성하면 상태를 바꿀 수 없는 불변(Immutable) 클래스 Money를 작성하시오.
 * 2. 조건:
 * 3. - final 클래스 (extends 불가)
 * 4. - private final int amount, private final String currency
 * 5. - 매개변수 생성자만 존재 (setter 없음)
 * 6. - getter만 존재
 * 7. - add(Money other) : 두 Money의 합산 결과를 새 Money 객체로 반환
 * 8. (currency가 다르면 "통화 불일치" 출력 후 null 반환)
 * 9. - toString() : "N원" 또는 "N달러" 형태로 반환
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 * 4. final을 사용해 변경할 수 없는 값과 객체 상태를 설계한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

final class Money {
    private final int amount;
    private final String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    int getAmount() { return amount; }
    String getCurrency() { return currency; }

    Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            System.out.println("통화 불일치");
            return null;
        }
        return new Money(this.amount + other.amount, this.currency);
    }

    // Object의 toString()을 재정의하므로 접근 범위를 public으로 유지한다.
    @Override
    public String toString() {
        return amount + currency;
    }
}

public class ImmutableMoneyPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Money m1 = new Money(10000, "원");
        Money m2 = new Money(5000, "원");
        Money m3 = new Money(100, "달러");

        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(m1.add(m2).toString());
        m1.add(m3);
    }
}
