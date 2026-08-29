// ClassAndMethodDemo.java
// 주제: 클래스 정의, 필드, 객체 생성, 메서드

class BankAccount {
    String owner;   // 기본값 null
    int balance;    // 기본값 0

    // void 메서드 - 반환값 없음
    void printInfo() {
        System.out.println(owner + ": " + balance + "원");
    }

    // 반환값 있는 메서드
    String getSummary() {
        return "[" + owner + "] 잔액: " + balance + "원";
    }

    // boolean 반환 - 성공/실패 여부 전달
    boolean withdraw(int amount) {
        if (amount > balance) {
            System.out.println("잔액 부족");
            return false;
        }
        balance -= amount;
        return true;
    }
}

public class ClassAndMethodDemo {
    public static void main(String[] args) {
        // ================================================================
        // 1. 객체 생성과 필드 접근
        // ================================================================
        BankAccount acc1 = new BankAccount();
        acc1.owner = "홍길동";
        acc1.balance = 10000;

        BankAccount acc2 = new BankAccount();
        acc2.owner = "김철수";
        acc2.balance = 50000;

        System.out.println(acc1.getSummary());
        System.out.println(acc2.getSummary());

        System.out.println();

        // ================================================================
        // 2. 참조형 변수 - 같은 객체를 가리키는 함정
        // ================================================================
        BankAccount ref = acc1;  // 복사처럼 보이지만 같은 객체를 가리킴
        ref.balance = 99999;

        // acc1도 바뀐다!
        System.out.println("acc1.balance = " + acc1.balance); // 99999
        System.out.println("ref.balance  = " + ref.balance);  // 99999

        System.out.println();

        // ================================================================
        // 3. 메서드 반환값 활용
        // ================================================================
        BankAccount acc3 = new BankAccount();
        acc3.owner = "이영희";
        acc3.balance = 30000;

        boolean ok = acc3.withdraw(10000);
        System.out.println("출금 성공: " + ok);
        System.out.println("잔액: " + acc3.balance);

        boolean fail = acc3.withdraw(999999); // 잔액 부족
        System.out.println("출금 성공: " + fail);
        System.out.println("잔액: " + acc3.balance); // 변화 없음

        System.out.println();

        // ================================================================
        // 4. null 참조 - NullPointerException 함정
        // ================================================================
        BankAccount empty = new BankAccount();
        // empty.owner는 초기화 안 했으므로 null (클래스 필드 기본값)
        System.out.println("owner = " + empty.owner);          // null 출력 (에러 아님)
        System.out.println("length = " + empty.owner.length()); // NullPointerException!
    }
}
