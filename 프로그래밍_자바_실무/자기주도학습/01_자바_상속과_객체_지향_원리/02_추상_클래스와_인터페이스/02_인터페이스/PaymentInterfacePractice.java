/**
 * [프로그래밍 자바 실무] - 자기주도학습
 *
 * 주제: 인터페이스를 이용한 결제 방식 교체
 *
 * 학습 조건:
 * 1. Payment 인터페이스에 pay(int amount)를 선언한다.
 * 2. CardPayment와 PointPayment가 서로 다른 결제 규칙을 구현한다.
 * 3. checkout()은 구체 클래스가 아닌 Payment 타입을 매개변수로 받는다.
 * 4. 같은 checkout()에 서로 다른 결제 객체를 전달해 실행한다.
 *
 * 학습 목표:
 * 1. 인터페이스가 구현 클래스의 공통 사용 규칙을 만드는 방법을 이해한다.
 * 2. 구현 객체를 교체해도 호출 코드를 유지하는 다형성을 연습한다.
 * 3. 구체 클래스에 대한 의존을 줄이는 설계 방식을 경험한다.
 */
interface Payment {
    void pay(int amount);
}

class CardPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.printf("카드로 %,d원을 결제했습니다.%n", amount);
    }
}

class PointPayment implements Payment {
    private int point;

    PointPayment(int point) {
        this.point = point;
    }

    @Override
    public void pay(int amount) {
        if (amount > point) {
            System.out.println("포인트가 부족합니다.");
            return;
        }

        point -= amount;
        System.out.printf("포인트로 %,d원을 결제했습니다. 남은 포인트: %,d%n", amount, point);
    }
}

public class PaymentInterfacePractice {
    static void checkout(Payment payment, int amount) {
        // 구체적인 결제 방식은 전달된 객체가 결정한다.
        payment.pay(amount);
    }

    public static void main(String[] args) {
        checkout(new CardPayment(), 15_000);
        checkout(new PointPayment(20_000), 12_000);
        checkout(new PointPayment(5_000), 12_000);
    }
}
