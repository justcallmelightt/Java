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

public class Q13 {
    public static void main(String[] args) {
        int[] dollars = {1, 5, 10, 50, 100};
        for (int i = 0; i < dollars.length; i++) {
            double krw = CurrencyConverter.toKRW(dollars[i], CurrencyConverter.USD_TO_KRW);
            System.out.println(dollars[i] + "달러 = " + CurrencyConverter.format(krw));
        }
    }
}
