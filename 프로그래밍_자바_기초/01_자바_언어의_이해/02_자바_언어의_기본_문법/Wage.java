import java.util.Scanner;

public class Wage {
    public static void main(String[] args) {
        final int MIN_WAGE = 9860;
        Scanner sc = new Scanner(System.in);
        System.out.print("시급 : ");
        int wage = sc.nextInt();
        System.out.print("근무 시간 : ");
        int hours = sc.nextInt();
        int minPay = MIN_WAGE * hours;
        int actualPay = wage * hours;
        System.out.println("최저시급 기준 급여 : " + minPay);
        System.out.println("실제 급여          : " + actualPay);
        System.out.println("차이               : " + (actualPay - minPay) + "원");
        sc.close();
    }
}
