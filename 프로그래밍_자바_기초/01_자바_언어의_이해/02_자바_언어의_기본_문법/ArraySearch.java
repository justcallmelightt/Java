import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력 : ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 정수 : ");
            nums[i] = sc.nextInt();
        }
        System.out.print("찾을 값 : ");
        int target = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                System.out.println("인덱스 " + i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("찾을 수 없습니다.");
        }
        sc.close();
    }
}
