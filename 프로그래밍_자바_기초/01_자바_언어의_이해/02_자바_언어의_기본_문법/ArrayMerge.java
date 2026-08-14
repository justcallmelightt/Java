import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 배열 크기(N) : ");
        int n = sc.nextInt();
        int[] arrA = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            arrA[i] = sc.nextInt();
        }
        System.out.print("두 번째 배열 크기(M) : ");
        int m = sc.nextInt();
        int[] arrB = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            arrB[i] = sc.nextInt();
        }
        int[] merged = new int[n + m];
        for (int i = 0; i < n; i++) {
            merged[i] = arrA[i];
        }
        for (int i = 0; i < m; i++) {
            merged[n + i] = arrB[i];
        }
        System.out.print("병합된 배열 : ");
        for (int i = 0; i < merged.length; i++) {
            System.out.print(merged[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
