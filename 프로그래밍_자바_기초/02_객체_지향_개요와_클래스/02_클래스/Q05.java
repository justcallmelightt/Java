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

public class Q05 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.setBalance(10000);
        System.out.println("잔액: " + acc.getBalance());
        acc.setBalance(-500);
        System.out.println("잔액: " + acc.getBalance());
    }
}
