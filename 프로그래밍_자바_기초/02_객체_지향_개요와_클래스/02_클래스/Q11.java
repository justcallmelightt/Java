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

public class Q11 {
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
