// AutoBoxingDemo.java
// 주제: 자동 박싱/언박싱 - 자바 컴파일러가 대신 변환해주는 경우

import java.util.ArrayList;

public class AutoBoxingDemo {

    public static void main(String[] args) {

        // ================================================================
        // 1. 오토박싱 / 오토언박싱 - valueOf(), intValue() 없이도 자동 변환
        // ================================================================
        // 자바 1.5 이상에서는 기본형과 Wrapper 객체 사이를 대입할 때
        // 컴파일러가 valueOf()/intValue() 호출을 알아서 넣어준다.
        Integer number = 50;   // 사실은 Integer.valueOf(50)과 같음 (오토박싱)
        int result = number;   // 사실은 number.intValue()와 같음 (오토언박싱)

        System.out.println("오토박싱된 number : " + number);
        System.out.println("오토언박싱된 result: " + result);
        System.out.println();

        // ================================================================
        // 2. 오토박싱이 실제로 쓰이는 대표적인 경우 - ArrayList
        // ================================================================
        // ArrayList<int> 처럼 기본형은 제네릭에 직접 못 쓴다.
        // ArrayList<Integer>로 선언해야 하는데, 값을 넣고 뺄 때는
        // 오토박싱/오토언박싱 덕분에 int처럼 자연스럽게 쓸 수 있다.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);   // 내부적으로 int 10 -> Integer로 오토박싱되어 저장
        list.add(20);

        int sum = 0;
        for (Integer num : list) {  // 꺼낼 때도 Integer 그대로 사용 가능
            sum += num;              // 여기서 오토언박싱되어 int 덧셈이 이루어짐
        }
        System.out.println("리스트 합계: " + sum);
        System.out.println();

        // ================================================================
        // 3. 실수하기 쉬운 부분 - 박싱/언박싱은 "공짜"가 아니다
        // ================================================================
        // 객체를 만들고 꺼내는 과정이 추가되기 때문에, 기본형만으로 계산하는 것보다
        // Wrapper 객체로 계산하면 더 느리다. 아래 비교로 확인해보자.

        long t1 = System.currentTimeMillis();
        Long sumObj = 0L;                          // 객체 타입으로 합계 계산
        for (long i = 0; i < 10000000; i++) {
            sumObj += i;   // 매번 오토박싱/오토언박싱이 반복됨
        }
        System.out.println("객체 타입 연산 시간: " + (System.currentTimeMillis() - t1) + " ms");

        long t2 = System.currentTimeMillis();
        long sumPrimitive = 0L;                     // 기본형 그대로 합계 계산
        for (long j = 0; j < 10000000; j++) {
            sumPrimitive += j;   // 박싱/언박싱 과정 없음
        }
        System.out.println("기본형 연산 시간   : " + (System.currentTimeMillis() - t2) + " ms");

        // 결론: 반복 연산이 많은 곳에서는 Wrapper 클래스보다 기본형을 쓰는 게 유리하다.
    }
}
