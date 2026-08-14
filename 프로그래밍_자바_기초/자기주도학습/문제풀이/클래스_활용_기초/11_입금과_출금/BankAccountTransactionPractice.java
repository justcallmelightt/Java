/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 11번 문제 - 입금/출금 기능 (BankAccountTransactionPractice.java)
 *
 * 문제 조건:
 * 1. 잔액(balance) 필드를 가진 BankAccount 클래스를 작성하시오.
 * 2. - deposit(int amount) : 입금. 금액이 0 이하면 "유효하지 않은 금액입니다." 출력
 * 3. - withdraw(int amount) : 출금. 잔액 부족 시 "잔액이 부족합니다." 출력, 성공 시 true 반환
 * 4. - getBalance() : 잔액 반환
 * 5. 매개변수 생성자로 초기 잔액을 설정한다.
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

class BankAccount {
    int balance;

    BankAccount(int balance) {
        this.balance = balance;
    }

    void deposit(int amount) {
        if (amount <= 0) {
            System.out.println("유효하지 않은 금액입니다.");
            return;
        }
        balance += amount;
    }

    boolean withdraw(int amount) {
        if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
            return false;
        }
        balance -= amount;
        return true;
    }

    int getBalance() {
        return balance;
    }
}

public class BankAccountTransactionPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(10000);
        System.out.println("잔액: " + acc.getBalance());
        acc.deposit(3000);
        System.out.println("입금 후 잔액: " + acc.getBalance());
        System.out.println("출금 성공: " + acc.withdraw(5000));
        System.out.println("출금 후 잔액: " + acc.getBalance());
        acc.withdraw(99999);
    }
}
