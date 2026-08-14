import java.util.Scanner;

public class CountSign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            nums[i] = sc.nextInt();
        }
        int pos = 0, neg = 0, zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                pos++;
            } else if (nums[i] < 0) {
                neg++;
            } else {
                zero++;
            }
        }
        System.out.println("양수 : " + pos + "개");
        System.out.println("음수 : " + neg + "개");
        System.out.println("0   : " + zero + "개");
        sc.close();
    }
}
