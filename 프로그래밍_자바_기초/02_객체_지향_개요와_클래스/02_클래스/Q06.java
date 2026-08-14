class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Q06 {
    public static void main(String[] args) {
        Student s = new Student("홍길동", 95);
        System.out.println(s.name + " : " + s.score + "점");
    }
}
