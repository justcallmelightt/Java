/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 14번 문제 - 카운터 클래스 (CounterPractice.java)
 *
 * 문제 조건:
 * 1. Counter 클래스를 작성하시오.
 * 2. - count 필드 (기본값 0)
 * 3. - increment() : count 1 증가
 * 4. - decrement() : count가 0보다 클 때만 1 감소, 0 이하면 "더 이상 감소할 수 없습니다." 출력
 * 5. - reset() : count를 0으로 초기화
 * 6. - getCount() : 현재 count 반환
 * 7. increment()를 5번, decrement()를 2번 호출 후 출력,
 * 8. reset() 호출 후 출력,
 * 9. decrement() 한 번 더 호출하시오.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Counter {
    int count;

    void increment() {
        count++;
    }

    void decrement() {
        if (count <= 0) {
            System.out.println("더 이상 감소할 수 없습니다.");
            return;
        }
        count--;
    }

    void reset() {
        count = 0;
    }

    int getCount() {
        return count;
    }
}

public class CounterPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Counter c = new Counter();
        for (int i = 0; i < 5; i++) c.increment();
        for (int i = 0; i < 2; i++) c.decrement();
        System.out.println("현재 카운트: " + c.getCount());
        c.reset();
        System.out.println("리셋 후: " + c.getCount());
        c.decrement();
    }
}
