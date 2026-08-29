/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 9번 문제 - private + static 조합 (IdGeneratorPractice.java)
 *
 * 문제 조건:
 * 1. 아래 조건으로 IdGenerator 클래스를 작성하시오.
 * 2. - private static int nextId = 1
 * 3. - static 메서드 generate() : nextId를 반환하고 1 증가시킨다.
 * 4. - 객체를 생성할 수 없도록 생성자를 private으로 막는다.
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

class IdGenerator {
    private static int nextId = 1;

    private IdGenerator() {}

    static int generate() {
        return nextId++;
    }
}

public class IdGeneratorPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        System.out.println(IdGenerator.generate());
        System.out.println(IdGenerator.generate());
        System.out.println(IdGenerator.generate());
        // IdGenerator ig = new IdGenerator();  // 컴파일 에러
    }
}
