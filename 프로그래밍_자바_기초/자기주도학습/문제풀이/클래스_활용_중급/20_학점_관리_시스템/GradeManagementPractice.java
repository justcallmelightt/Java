/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 20번 문제 - 종합 설계 (어려움) (GradeManagementPractice.java)
 *
 * 문제 조건:
 * 1. 간단한 학점 관리 시스템을 작성하시오.
 * 2. Course 클래스 (과목):
 * 3. - private final String name (과목명)
 * 4. - private final int credit (학점)
 * 5. - private int grade (성적, 0~100)
 * 6. - 생성자: name, credit 받아 초기화 (grade는 0)
 * 7. - setGrade(int grade) : 0~100 범위 벗어나면 무시
 * 8. - getGradePoint() : 성적을 학점으로 변환해 반환
 * 9. 90 이상 4.5 / 80 이상 4.0 / 70 이상 3.5 / 60 이상 3.0 / 60 미만 0.0
 * 10. - getName(), getCredit(), getGrade() getter 작성
 * 11. Student 클래스:
 * 12. - private String name
 * 13. - private Course[] courses = new Course[10]
 * 14. - private int courseCount = 0
 * 15. - private static int totalStudents = 0 (생성 시 증가)
 * 16. - 생성자: name 받아 초기화
 * 17. - addCourse(Course c) : 과목 추가
 * 18. - calculateGPA() : 가중 평균 학점 반환
 * 19. (각 과목의 gradePoint * credit 합계) / (전체 credit 합계)
 * 20. - printReport() : 학생 이름, 각 과목 정보, 최종 GPA 출력
 * 21. - static getTotalStudents()
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 * 4. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

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

public class GradeManagementPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Student s = new Student("홍길동");

        Course c1 = new Course("자바프로그래밍", 3);
        Course c2 = new Course("자료구조", 3);
        Course c3 = new Course("데이터베이스", 2);
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
