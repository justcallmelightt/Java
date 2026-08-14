import java.util.Scanner;

public class Tax {
    public static void main(String[] args) {
        final double TAX_RATE = 0.1;
        Scanner sc = new Scanner(System.in);
        System.out.print("가격 : ");
        int price = sc.nextInt();
        System.out.print("수량 : ");
        int qty = sc.nextInt();
        int total = price * qty;
        System.out.println("총액   : " + total);
        System.out.println("부가세 : " + (total * TAX_RATE));
        sc.close();
    }
}
