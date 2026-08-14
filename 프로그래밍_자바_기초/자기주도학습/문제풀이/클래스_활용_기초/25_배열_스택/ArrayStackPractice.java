/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 25번 문제 - 스택 구현 (난이도: 상) (ArrayStackPractice.java)
 *
 * 문제 조건:
 * 1. 배열을 이용한 Stack 클래스를 작성하시오.
 * 2. [ Step 1 - 기본 스택 ]
 * 3. 필드 :
 * 4. - int[] data : 데이터 저장 배열
 * 5. - int top : 현재 스택의 최상위 인덱스 (초기값 -1)
 * 6. 생성자 : 크기를 받아 배열 초기화
 * 7. 메서드 :
 * 8. - isEmpty() : 스택이 비어있으면 true
 * 9. - isFull() : 스택이 가득 찼으면 true
 * 10. - push(int value) : 가득 찼으면 "스택이 가득 찼습니다." 출력 후 종료
 * 11. - pop() : 비어있으면 "스택이 비어있습니다." 출력 후 -1 반환
 * 12. - peek() : 꺼내지 않고 맨 위 값만 반환. 비어있으면 -1 반환
 * 13. - printStack() : 스택 전체 내용을 위에서부터 출력
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 배열과 반복문으로 여러 객체 또는 데이터를 순서대로 처리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Stack {
    int[] data;
    int top;

    Stack(int size) {
        data = new int[size];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == data.length - 1;
    }

    void push(int value) {
        if (isFull()) {
            System.out.println("스택이 가득 찼습니다.");
            return;
        }
        data[++top] = value;
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("스택이 비어있습니다.");
            return -1;
        }
        return data[top--];
    }

    int peek() {
        if (isEmpty()) return -1;
        return data[top];
    }

    void printStack() {
        System.out.println("--- 스택 상태 ---");
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i]);
        }
    }
}

public class ArrayStackPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Stack stack = new Stack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        stack.printStack();
        stack.push(999); // 가득 참
        stack.pop();
        stack.pop();     // 비어있음
    }
}
