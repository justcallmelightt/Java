import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int n;
        while (true) {
            System.out.print("정수 입력 (0 입력 시 종료) : ");
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            sum += n;
        }
        System.out.println("합계 : " + sum);
        sc.close();
    }
}
