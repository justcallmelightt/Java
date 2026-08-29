import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        final int ANSWER = 42;
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.print("숫자 입력 : ");
            int guess = sc.nextInt();
            count++;
            if (guess < ANSWER) {
                System.out.println("더 큰 수입니다.");
            } else if (guess > ANSWER) {
                System.out.println("더 작은 수입니다.");
            } else {
                System.out.println(count + "번 만에 정답입니다!");
                break;
            }
        }
        sc.close();
    }
}
