import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MJRArray {
    public static void main(String[] args) {
        /*
        // 1부터 30까지 50개 만들어서 빈도수랑, 최대, 최소값 구하기
        int[] randomNums = new int[50];
        for(int i=0;i<randomNums.length;i++) {
            randomNums[i] = ThreadLocalRandom.current().nextInt(1, 31);
        }

        int[] counts = new int[30];
        int max = randomNums[0];
        int min = randomNums[0];
        for(int i=0;i<randomNums.length;i++) {
            counts[randomNums[i] - 1]++;
            if(randomNums[i] > max) max = randomNums[i];
            if(randomNums[i] < min) min = randomNums[i];
        }

        int maxFreq = counts[0];
        for(int i=0;i<counts.length;i++) {
            if(counts[i] > maxFreq) maxFreq = counts[i];
        }

        System.out.print("가장 빈도수가 높은 수는 ");
        for(int i=0;i<counts.length;i++) {
            if(counts[i] == maxFreq) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.print("으로 " + maxFreq + "번 발생");
        */

        /*
        // 점수대별로 *로 표시하기 문제
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        while(true) {
            System.out.print("점수 입력: ");
            int num = sc.nextInt();
            // 0 미만 100 초과인 경우 끝내기
            if(num < 0 || num > 100) break;
            // 각 점수대별로 count 증가
            if(num >= 90) arr[0]++;
            else if(num >= 80) arr[1]++;
            else if(num >= 70) arr[2]++;
            else if(num >= 60) arr[3]++;
            else arr[4]++;
        }

        String[] prefix = {"90점 이상", "80점 이상", "70점 이상", "60점 이상", "60점 미만"};
        for(int i=0;i<arr.length;i++) {
            System.out.print(prefix[i] + ":");
            for(int j=0;j<arr[i];j++) System.out.print("* ");
            System.out.println();
        }
        */

        /*
        // 다음과 같은 2차원 행렬 만들기
        // 1
        // 2 3
        // 4 5 6
        // 7 8 9 10
        int[][] arr = new int[4][];
        int num = 1;
        for(int i=0;i<arr.length;i++) {
            arr[i] = new int[i + 1];
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j] = num;
                num++;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        */

        /*
        // 배열에 A-Z까지 저장하기
        char[] uppers = new char[26];
        int idx = 0;
        for(char c = 'A'; c <= 'Z' ; c++ ) {
            uppers[idx] = c;
            idx++;
        }
        System.out.println(Arrays.toString(uppers));
        */

    }
}
