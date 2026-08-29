/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 1번 문제 - private 필드와 getter/setter (PersonEncapsulationPractice.java)
 *
 * 문제 조건:
 * 1. 나이(age) 필드를 private으로 가진 Person 클래스를 작성하시오.
 * 2. - getAge() : 나이 반환
 * 3. - setAge() : 0 미만이거나 150 초과면 "유효하지 않은 나이입니다." 출력 후 무시
 * 4. 매개변수 생성자로 초기화한다.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Person {
    private int age;

    Person(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("유효하지 않은 나이입니다.");
            return;
        }
        this.age = age;
    }
}

public class PersonEncapsulationPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Person p = new Person(25);
        System.out.println("나이: " + p.getAge());
        p.setAge(-1);
        System.out.println("나이: " + p.getAge());
        p.setAge(200);
        System.out.println("나이: " + p.getAge());
    }
}
