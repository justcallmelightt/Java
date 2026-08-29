import java.util.Scanner;

public class ArrayPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            nums[i] = sc.nextInt();
        }
        boolean isPalindrome = true;
        for (int i = 0; i < n / 2; i++) {
            if (nums[i] != nums[n - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("대칭 배열입니다.");
        } else {
            System.out.println("대칭 배열이 아닙니다.");
        }
        sc.close();
    }
}
