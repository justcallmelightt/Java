import java.util.Scanner;

public class ArrayCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[] original = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            original[i] = sc.nextInt();
        }
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            copy[i] = original[i];
        }
        original[0] = 999;
        System.out.print("원본   : ");
        for (int i = 0; i < original.length; i++) {
            System.out.print(original[i] + " ");
        }
        System.out.println();
        System.out.print("복사본 : ");
        for (int i = 0; i < copy.length; i++) {
            System.out.print(copy[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
