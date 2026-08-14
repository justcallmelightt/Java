/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 12번 문제 - 학생 배열 (StudentArrayAveragePractice.java)
 *
 * 문제 조건:
 * 1. 이름(name)과 점수(score)를 가진 Student 클래스를 작성하시오.
 * 2. 매개변수 생성자로 학생 5명을 배열에 저장하고,
 * 3. 반복문으로 전체 출력 및 평균 점수를 출력하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 * 4. 반복문으로 누적, 검색 또는 상태 변화를 구현한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class StudentArrayAveragePractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
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
