/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 5번 문제 - 게터/세터 작성 (BankAccountAccessorPractice.java)
 *
 * 문제 조건:
 * 1. 잔액(balance) 필드를 가진 BankAccount 클래스를 정의하시오.
 * 2. getBalance()와 setBalance() 메서드를 작성하되,
 * 3. setBalance()는 음수가 입력되면 "잘못된 금액입니다."를 출력하고 대입하지 않는다.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class BankAccount {
    int balance;

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        if (balance < 0) {
            System.out.println("잘못된 금액입니다.");
            return;
        }
        this.balance = balance;
    }
}

public class BankAccountAccessorPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.setBalance(10000);
        System.out.println("잔액: " + acc.getBalance());
        acc.setBalance(-500);
        System.out.println("잔액: " + acc.getBalance());
    }
}
