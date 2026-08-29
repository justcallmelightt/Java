import java.util.Scanner;

public class MaxTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int a = sc.nextInt();
        System.out.print("두 번째 정수 : ");
        int b = sc.nextInt();
        if (a > b) {
            System.out.println("최댓값 : " + a);
        } else if (b > a) {
            System.out.println("최댓값 : " + b);
        } else {
            System.out.println("같습니다");
        }
        sc.close();
    }
}
