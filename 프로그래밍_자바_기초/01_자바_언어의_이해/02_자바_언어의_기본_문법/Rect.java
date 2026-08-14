import java.util.Scanner;

public class Rect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("가로 : ");
        int width = sc.nextInt();
        System.out.print("세로 : ");
        int height = sc.nextInt();
        System.out.println("넓이 : " + (width * height));
        System.out.println("둘레 : " + (2 * (width + height)));
        sc.close();
    }
}
