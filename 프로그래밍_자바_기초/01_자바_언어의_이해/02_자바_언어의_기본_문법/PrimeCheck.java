import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int n = sc.nextInt();
        boolean isPrime = n >= 2;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println(n + "은(는) 소수입니다.");
        } else {
            System.out.println(n + "은(는) 소수가 아닙니다.");
        }
        sc.close();
    }
}
