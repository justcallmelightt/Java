import java.util.Scanner;

public class ScoreGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학생 수 : ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번 학생 점수 : ");
            scores[i] = sc.nextInt();
        }
        for (int i = 0; i < scores.length; i++) {
            String grade;
            if (scores[i] >= 90) {
                grade = "A";
            } else if (scores[i] >= 80) {
                grade = "B";
            } else if (scores[i] >= 70) {
                grade = "C";
            } else if (scores[i] >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            System.out.println((i + 1) + "번 학생 : " + scores[i] + "점 → " + grade);
        }
        sc.close();
    }
}
