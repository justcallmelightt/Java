/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 6번 문제 - static 카운터 (DogStaticCounterPractice.java)
 *
 * 문제 조건:
 * 1. static 필드 totalCount를 가진 Dog 클래스를 작성하시오.
 * 2. - 객체가 생성될 때마다 totalCount가 1 증가한다.
 * 3. - getName() : 이름 반환
 * 4. - getTotalCount() : static 메서드로 totalCount 반환
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Dog {
    private static int totalCount = 0;
    private String name;

    Dog(String name) {
        this.name = name;
        totalCount++;
    }

    String getName() {
        return name;
    }

    static int getTotalCount() {
        return totalCount;
    }
}

public class DogStaticCounterPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        System.out.println("현재 강아지 수: " + Dog.getTotalCount());
        Dog d1 = new Dog("뽀미");
        Dog d2 = new Dog("코코");
        Dog d3 = new Dog("초코");
        System.out.println("현재 강아지 수: " + Dog.getTotalCount());
        System.out.println(d1.getName() + " / " + d2.getName() + " / " + d3.getName());
    }
}
