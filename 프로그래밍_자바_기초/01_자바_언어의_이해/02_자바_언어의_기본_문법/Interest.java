import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원금 : ");
        int principal = sc.nextInt();
        System.out.print("연이율 : ");
        double rate = sc.nextDouble();
        System.out.print("기간(년) : ");
        int years = sc.nextInt();
        double interest = principal * rate * years;
        System.out.println("이자      : " + interest);
        System.out.println("최종 금액 : " + (principal + interest));
        sc.close();
    }
}
