/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 15번 문제 - 성적 등급 반환 (GradePractice.java)
 *
 * 문제 조건:
 * 1. 점수(score) 필드를 가진 Grade 클래스를 작성하시오.
 * 2. getGrade() 메서드는 점수에 따라 등급 문자열을 반환한다.
 * 3. - 90 이상 : "A"
 * 4. - 80 이상 : "B"
 * 5. - 70 이상 : "C"
 * 6. - 60 이상 : "D"
 * 7. - 60 미만  : "F"
 * 8. 점수 배열 {95, 83, 71, 60, 45}를 반복문으로 테스트하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 * 3. 반복문으로 누적, 검색 또는 상태 변화를 구현한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

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

public class GradePractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        int[] scores = {95, 83, 71, 60, 45};
        for (int i = 0; i < scores.length; i++) {
            Grade g = new Grade(scores[i]);
            System.out.println(scores[i] + "점 → " + g.getGrade());
        }
    }
}
