import java.util.Scanner;

public class AboveAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            nums[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        double avg = (double) sum / n;
        System.out.println("평균 : " + avg);
        System.out.print("평균 이상 : ");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= avg) {
                System.out.print(nums[i] + " ");
            }
        }
        System.out.println();
        sc.close();
    }
}
