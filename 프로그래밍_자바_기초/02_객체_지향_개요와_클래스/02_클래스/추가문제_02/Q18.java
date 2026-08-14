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

    String toString() {
        return amount + currency;
    }
}

public class Q18 {
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
