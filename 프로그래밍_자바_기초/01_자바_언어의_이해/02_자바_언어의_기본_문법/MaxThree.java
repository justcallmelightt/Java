import java.util.Scanner;

public class MaxThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int a = sc.nextInt();
        System.out.print("두 번째 정수 : ");
        int b = sc.nextInt();
        System.out.print("세 번째 정수 : ");
        int c = sc.nextInt();
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        System.out.println("최댓값 : " + max);
        sc.close();
    }
}
