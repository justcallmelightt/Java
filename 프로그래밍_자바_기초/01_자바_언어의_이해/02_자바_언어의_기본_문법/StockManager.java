import java.util.Scanner;

public class StockManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("상품 수 : ");
        int n = sc.nextInt();
        int[] stock = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번 상품 재고 : ");
            stock[i] = sc.nextInt();
        }
        int total = 0;
        for (int i = 0; i < stock.length; i++) {
            total += stock[i];
            if (stock[i] == 0) {
                System.out.println((i + 1) + "번 상품 : 품절");
            } else if (stock[i] <= 5) {
                System.out.println((i + 1) + "번 상품 : 재고 부족 (" + stock[i] + "개)");
            } else {
                System.out.println((i + 1) + "번 상품 : " + stock[i] + "개");
            }
        }
        System.out.println("전체 재고 : " + total + "개");
        sc.close();
    }
}
