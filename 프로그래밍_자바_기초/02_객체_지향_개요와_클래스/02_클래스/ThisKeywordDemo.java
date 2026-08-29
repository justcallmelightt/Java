// ThisKeywordDemo.java
class Counter {
    int count;
    int step;
    String label;

    Counter(int count, int step, String label) {
        this.count = count;   // this.count → 필드
        this.step  = step;    // step       → 매개변수
        this.label = label;
    }

    // 기본 생성자 → this()로 매개변수 생성자 재사용
    Counter() {
        this(0, 1, "기본");   // 반드시 생성자 첫 줄에만 쓸 수 있다
    }

    // ================================================================
    // 1. this 없이 쓰면 어떻게 되나 — 필드가 변경되지 않는 함정
    // ================================================================
    void badSetter(int count) {
        count = count;  // 매개변수에 매개변수를 대입 → 필드 그대로
    }

    void goodSetter(int count) {
        this.count = count; // 필드 변경됨
    }

    // ================================================================
    // 2. 메서드 내에서 같은 클래스의 다른 메서드를 this로 호출
    // ================================================================
    void increment() {
        this.count += this.step;
    }

    void incrementTwice() {
        this.increment(); // 같은 객체의 메서드 호출
        this.increment();
    }

    String getStatus() {
        return "[" + this.label + "] count = " + this.count;
    }
}

public class ThisKeywordDemo {
    public static void main(String[] args) {
        // ================================================================
        // 3. this()로 생성자 체인 확인
        // ================================================================
        Counter c1 = new Counter();          // 기본 생성자 → this(0, 1, "기본") 호출
        Counter c2 = new Counter(10, 5, "A");

        System.out.println(c1.getStatus()); // [기본] count = 0
        System.out.println(c2.getStatus()); // [A] count = 10

        System.out.println();

        // ================================================================
        // 4. badSetter 함정 확인
        // ================================================================
        c1.badSetter(999);
        System.out.println("badSetter 후: " + c1.count);  // 0 (변화 없음!)

        c1.goodSetter(999);
        System.out.println("goodSetter 후: " + c1.count); // 999

        System.out.println();

        // ================================================================
        // 5. incrementTwice → increment 두 번 호출 확인
        // ================================================================
        c2.incrementTwice();
        System.out.println(c2.getStatus()); // [A] count = 20 (10 + 5 + 5)

        System.out.println();

        // ================================================================
        // 6. this()는 생성자 첫 줄이 아니면 컴파일 에러
        // ================================================================
        // Counter(int count, int step, String label) {
        //     System.out.println("초기화 중"); // 이 줄이 먼저 오면
        //     this(0, 1, "기본");              // 컴파일 에러!
        // }
    }
}
