import java.util.Scanner;

public class ScoreProcess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학생 수 : ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번 학생 점수 : ");
            scores[i] = sc.nextInt();
        }
        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        System.out.println("합계   : " + sum);
        System.out.println("평균   : " + (double) sum / n);
        System.out.println("최고점 : " + max);
        System.out.println("최저점 : " + min);
        sc.close();
    }
}
