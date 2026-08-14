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

public class Q25 {
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
