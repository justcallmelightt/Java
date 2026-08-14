class Student {
    private String name;
    private int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    String getName() { return name; }
    int getScore() { return score; }
}

public class Q12 {
    public static void main(String[] args) {
        Student[] students = {
            new Student("홍길동", 75),
            new Student("김철수", 90),
            new Student("이영희", 85),
            new Student("박민준", 60),
            new Student("최수연", 95),
            new Student("강지훈", 80)
        };

        int cnt = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getScore() >= 80) cnt++;
        }
        System.out.println("80점 이상 학생: " + cnt + "명");
        for (int i = 0; i < students.length; i++) {
            if (students[i].getScore() >= 80) {
                System.out.println(students[i].getName() + " (" + students[i].getScore() + "점)");
            }
        }
    }
}
