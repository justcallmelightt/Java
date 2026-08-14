import java.util.Scanner;

public class Array2DDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((i + 1) + "행 " + (j + 1) + "열 : ");
                arr[i][j] = sc.nextInt();
            }
        }
        int mainDiag = 0;
        int antiDiag = 0;
        for (int i = 0; i < n; i++) {
            mainDiag += arr[i][i];
            antiDiag += arr[i][n - 1 - i];
        }
        System.out.println("주 대각선 합 : " + mainDiag);
        System.out.println("반 대각선 합 : " + antiDiag);
        sc.close();
    }
}
