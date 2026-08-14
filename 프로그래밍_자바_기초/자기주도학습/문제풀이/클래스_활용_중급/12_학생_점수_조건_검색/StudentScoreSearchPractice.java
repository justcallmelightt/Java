/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 12번 문제 - 접근 제어자 + 배열 + 조건 (응용) (StudentScoreSearchPractice.java)
 *
 * 문제 조건:
 * 1. private 필드 name, score를 가진 Student 클래스를 작성하시오.
 * 2. 매개변수 생성자, getName(), getScore()를 작성한다.
 * 3. 학생 6명을 배열에 저장하고, 점수가 80점 이상인 학생 수와 이름을 출력하시오.
 * 4. 데이터: ("홍길동",75), ("김철수",90), ("이영희",85), ("박민준",60), ("최수연",95), ("강지훈",80)
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 * 4. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

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

public class StudentScoreSearchPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
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
