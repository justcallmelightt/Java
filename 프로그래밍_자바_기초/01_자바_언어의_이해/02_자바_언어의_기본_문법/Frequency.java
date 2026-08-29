import java.util.Scanner;

public class Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 (0~9) : ");
            nums[i] = sc.nextInt();
        }
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println(i + " : " + count[i] + "번");
            }
        }
        System.out.print("최빈값 : ");
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        sc.close();
    }
}
