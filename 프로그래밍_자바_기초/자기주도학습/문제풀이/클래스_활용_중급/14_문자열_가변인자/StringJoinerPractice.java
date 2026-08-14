/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 14번 문제 - 가변 인자 + 반복문 (응용) (StringJoinerPractice.java)
 *
 * 문제 조건:
 * 1. 가변 인자를 활용하는 StringJoiner 클래스를 작성하시오.
 * 2. - static String join(String separator, String... words)
 * 3. words를 separator로 이어붙인 문자열 반환
 * 4. (words가 없으면 빈 문자열 반환)
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 * 3. 가변 인자를 사용해 호출 시 전달되는 인자 수를 유연하게 처리한다.
 * 4. 반복문으로 누적, 검색 또는 상태 변화를 구현한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class StringJoiner {
    static String join(String separator, String... words) {
        if (words.length == 0) {
            return "";
        }
        String result = words[0];
        for (int i = 1; i < words.length; i++) {
            result += separator + words[i];
        }
        return result;
    }
}

public class StringJoinerPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        System.out.println(StringJoiner.join("-", "Java", "Python", "C++"));
        System.out.println(StringJoiner.join(", ", "홍길동", "김철수", "이영희"));
        System.out.println(StringJoiner.join("|", "one", "two", "three", "four"));
    }
}
