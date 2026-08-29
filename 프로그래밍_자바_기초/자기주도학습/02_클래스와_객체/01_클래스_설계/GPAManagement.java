class Course {
    private final String name;
    private final int credit;
    private int grade;

    Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }

    void setGrade(int grade) {
        if (grade < 0 || grade > 100) return;
        this.grade = grade;
    }

    double getGradePoint() {
        if (grade >= 90) return 4.5;
        else if (grade >= 80) return 4.0;
        else if (grade >= 70) return 3.5;
        else if (grade >= 60) return 3.0;
        else return 0.0;
    }

    String getName() { return name; }
    int getCredit() { return credit; }
    int getGrade() { return grade; }
}

class Student {
    private String name;
    private Course[] courses = new Course[10];
    private int courseCount = 0;
    private static int totalStudents = 0;

    Student(String name) {
        this.name = name;
        totalStudents++;
    }

    void addCourse(Course c) {
        if (courseCount < 10) {
            courses[courseCount++] = c;
        }
    }

    double calculateGPA() {
        double totalWeighted = 0;
        int totalCredit = 0;
        for (int i = 0; i < courseCount; i++) {
            totalWeighted += courses[i].getGradePoint() * courses[i].getCredit();
            totalCredit += courses[i].getCredit();
        }
        if (totalCredit == 0) return 0.0;
        return totalWeighted / totalCredit;
    }

    void printReport() {
        System.out.println("=== " + name + " 성적표 ===");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].getName() + " (" + courses[i].getCredit() + "학점) : "
                + courses[i].getGrade() + "점 → " + courses[i].getGradePoint());
        }
        System.out.printf("GPA: %.2f%n", calculateGPA());
    }

    static int getTotalStudents() { return totalStudents; }
}

public class GPAManagement {
    public static void main(String[] args) {
        Student s = new Student("홍길동");

        Course c1 = new Course("프로그래밍자바", 3);
        Course c2 = new Course("자료구조", 3);
        Course c3 = new Course("데이터베이스프로그래밍", 2);
        c1.setGrade(95);
        c2.setGrade(82);
        c3.setGrade(67);

        s.addCourse(c1);
        s.addCourse(c2);
        s.addCourse(c3);
        s.printReport();
        System.out.println("전체 학생 수: " + Student.getTotalStudents() + "명");
    }
}
