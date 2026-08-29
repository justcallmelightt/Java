import java.util.Scanner;

public class Array2DColSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("행(N) : ");
        int n = sc.nextInt();
        System.out.print("열(M) : ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((i + 1) + "행 " + (j + 1) + "열 : ");
                arr[i][j] = sc.nextInt();
            }
        }
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr[i][j];
            }
            System.out.println((j + 1) + "열 합계 : " + sum);
        }
        sc.close();
    }
}
