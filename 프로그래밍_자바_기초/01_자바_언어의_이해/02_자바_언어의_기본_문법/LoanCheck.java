import java.util.Scanner;

public class LoanCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("나이       : ");
        int age = sc.nextInt();
        System.out.print("연소득(만원) : ");
        int income = sc.nextInt();
        System.out.print("신용점수   : ");
        int credit = sc.nextInt();
        if (age < 20 || credit < 600) {
            System.out.println("대출 불가");
        } else if (credit >= 800 && income >= 5000) {
            System.out.println("대출 가능 | 한도 : 1억원");
        } else if (credit >= 800) {
            System.out.println("대출 가능 | 한도 : 5,000만원");
        } else {
            System.out.println("대출 가능 | 한도 : 2,000만원");
        }
        sc.close();
    }
}
