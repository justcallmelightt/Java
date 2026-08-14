class Student {
    String name;
    int age;
}

public class Q01 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "홍길동";
        s.age = 20;
        System.out.println("이름: " + s.name + ", 나이: " + s.age);
    }
}
