import java.util.Scanner;

public class Game369 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int ones = i % 10;
            if (ones == 3 || ones == 6 || ones == 9) {
                System.out.print("X ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        sc.close();
    }
}
