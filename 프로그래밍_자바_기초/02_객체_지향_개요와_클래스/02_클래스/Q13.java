class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Q13 {
    public static void main(String[] args) {
        Student[] students = {
            new Student("홍길동", 80),
            new Student("김철수", 95),
            new Student("이영희", 70),
            new Student("박민준", 88),
            new Student("최수연", 92)
        };

        Student top = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].score > top.score) {
                top = students[i];
            }
        }
        System.out.println("최고 점수: " + top.name + " (" + top.score + "점)");
    }
}
