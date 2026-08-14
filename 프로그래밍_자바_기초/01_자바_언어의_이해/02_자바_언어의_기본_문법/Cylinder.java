import java.util.Scanner;

public class Cylinder {
    public static void main(String[] args) {
        final double PI = 3.14;
        Scanner sc = new Scanner(System.in);
        System.out.print("반지름 : ");
        int r = sc.nextInt();
        System.out.print("높이   : ");
        int h = sc.nextInt();
        System.out.println("부피   : " + (PI * r * r * h));
        System.out.println("겉넓이 : " + (2 * PI * r * r + 2 * PI * r * h));
        sc.close();
    }
}
