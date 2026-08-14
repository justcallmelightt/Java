import java.util.Scanner;

public class PassOrFail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학생 수 : ");
        int n = sc.nextInt();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번 학생 (국어 영어 수학) : ");
            for (int j = 0; j < 3; j++) {
                scores[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += scores[i][j];
            }
            double avg = (double) sum / 3;
            String result = avg >= 60 ? "합격" : "불합격";
            System.out.printf((i + 1) + "번 학생 : 평균 %.1f점 → %s%n", avg, result);
        }
        sc.close();
    }
}
