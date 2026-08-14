class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Q12 {
    public static void main(String[] args) {
        Student[] students = {
            new Student("홍길동", 80),
            new Student("김철수", 95),
            new Student("이영희", 70),
            new Student("박민준", 88),
            new Student("최수연", 92)
        };

        int sum = 0;
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].name + " : " + students[i].score + "점");
            sum += students[i].score;
        }
        System.out.println("평균: " + (double) sum / students.length + "점");
    }
}
