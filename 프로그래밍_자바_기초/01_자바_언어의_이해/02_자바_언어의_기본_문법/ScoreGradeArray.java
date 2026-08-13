class Grade {
    int score;

    Grade(int score) {
        this.score = score;
    }

    String getGrade() {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }
}
public class ScoreGradeArray {
    public static void main(String[] args) {
        int[] scores = {95, 83, 71, 60, 45};
        for (int i = 0; i < scores.length; i++) {
            Grade g = new Grade(scores[i]);
            System.out.println(scores[i] + "점 → " + g.getGrade());
        }
    }
}
