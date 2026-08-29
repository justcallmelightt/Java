import java.util.Arrays;
import java.util.Scanner;

public class ArrayStudy3 {
    public static void main(String[] args) {
        int N = 4;
        int[] arr = { 5, 4, 1, 3 };
        System.out.println("정렬 전 : " + Arrays.toString(arr));
        // 선택 정렬 수행
        for(int i=0;i<N;i++) {
            int idx = i;
            int least = arr[i];
            // System.out.println("\ni:" + i + "\nj:");
            for(int j=i;j<N;j++) {
                // System.out.print(j + " ");
                if(arr[j] < least) {
                    least = arr[j];
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = least;
            arr[idx] = temp;
        }
        System.out.println("정렬 후 : " + Arrays.toString(arr));

        /*
        // 22번 문제 (버블 정렬)
//        Scanner sc = new Scanner(System.in);
//        System.out.print("N 입력: ");
//        int N = sc.nextInt();
//        int[] arr = new int[N];
//        for(int i=0;i<N;i++) {
//            System.out.print((i + 1) + "번째 정수: ");
//            arr[i] = sc.nextInt();
//        }
        int N = 5;
        int[] arr = { 5, 4, 1, 3, 2 };
        System.out.println("정렬 전 : " + Arrays.toString(arr));
        // 버블 정렬 수행
        for(int i=N-2;i>=0;i--) {
            System.out.println(i);
            for(int j=0;j<=i;j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("정렬 후 : " + Arrays.toString(arr));
        */

        /*
        // 21번 문제
        Scanner sc = new Scanner(System.in);
        System.out.print("N 입력: ");
        int N = sc.nextInt();
        int[][] nums = new int[N][N];
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums[i].length;j++) {
                System.out.print((i + 1) + "행 " + (j + 1) + " 열 : ");
                int num = sc.nextInt();
                nums[i][j] = num;
            }
        }

        // 전치 행렬 만들기
        int[][] transpose = new int[N][N];
        for(int i=0;i<nums.length;i++) {
            for(int j=0;j<nums[i].length;j++) {
                // i => j, j => i
                transpose[j][i] = nums[i][j];
            }
        }
        System.out.println(Arrays.deepToString(transpose));
        */

    }
}
