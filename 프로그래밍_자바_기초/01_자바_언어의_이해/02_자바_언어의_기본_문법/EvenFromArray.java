import java.util.Scanner;

public class EvenFromArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            nums[i] = sc.nextInt();
        }
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                System.out.print(nums[i] + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("짝수 없음");
        } else {
            System.out.println();
        }
        sc.close();
    }
}
