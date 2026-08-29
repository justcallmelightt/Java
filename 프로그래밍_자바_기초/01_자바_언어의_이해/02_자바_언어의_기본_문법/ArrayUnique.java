import java.util.Scanner;

public class ArrayUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            nums[i] = sc.nextInt();
        }
        int[] result = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < count; j++) {
                if (nums[i] == result[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                result[count++] = nums[i];
            }
        }
        System.out.print("결과 : ");
        for (int i = 0; i < count; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
