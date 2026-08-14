import java.util.Scanner;

public class DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("주문 금액 : ");
        int price = sc.nextInt();
        int fee;
        if (price < 15000) {
            fee = 3000;
        } else if (price < 30000) {
            fee = 1000;
        } else {
            fee = 0;
        }
        System.out.println("배달비       : " + fee + "원");
        System.out.println("최종 금액    : " + (price + fee) + "원");
        sc.close();
    }
}
