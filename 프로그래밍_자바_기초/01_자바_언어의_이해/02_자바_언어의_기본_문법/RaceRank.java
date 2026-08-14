import java.util.Scanner;

public class RaceRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("선수 수 : ");
        int n = sc.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번 선수 기록(초) : ");
            times[i] = sc.nextInt();
        }
        int minIdx = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[i] < times[minIdx]) {
                minIdx = i;
            }
        }
        System.out.println("1등 : " + (minIdx + 1) + "번 선수 (" + times[minIdx] + "초)");
        sc.close();
    }
}
