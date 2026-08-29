// StaticFieldAndMethodDemo.java
// 주제: static 필드, static 메서드, 인스턴스 메서드 비교

class Counter {
    // static 필드: 모든 인스턴스가 공유, 클래스 로딩 시 한 번만 초기화
    public static int totalCount = 0;

    // 인스턴스 필드: 객체마다 독립적으로 존재
    private String label;
    private int localCount = 0;

    public Counter(String label) {
        this.label = label;
        totalCount++;   // 객체 생성될 때마다 공유 카운터 증가
        localCount++;
    }

    // ================================================================
    // static 메서드: 클래스 이름으로 호출, 인스턴스 필드 접근 불가
    // ================================================================
    public static int getTotalCount() {
        // System.out.println(label);  // 컴파일 에러: 인스턴스 필드 접근 불가
        // System.out.println(localCount);  // 컴파일 에러: 인스턴스 필드 접근 불가
        return totalCount;
    }

    // static 메서드에서 static 필드는 접근 가능
    public static void resetTotal() {
        totalCount = 0;
    }

    // ================================================================
    // 인스턴스 메서드: 인스턴스 필드 + static 필드 모두 접근 가능
    // ================================================================
    public String getStatus() {
        return "[" + label + "] localCount=" + localCount + ", totalCount=" + totalCount;
    }
}

public class StaticFieldAndMethodDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. 객체 생성 전에도 static 필드/메서드 접근 가능
        // ================================================================
        System.out.println("생성 전 totalCount = " + Counter.totalCount);    // 0
        System.out.println("생성 전 getTotalCount() = " + Counter.getTotalCount()); // 0

        System.out.println();

        // ================================================================
        // 2. 객체 생성 후 - 모든 인스턴스가 같은 static 필드를 공유
        // ================================================================
        Counter c1 = new Counter("A");
        Counter c2 = new Counter("B");
        Counter c3 = new Counter("C");

        // 클래스 이름으로 접근 (권장)
        System.out.println("클래스로 접근: " + Counter.totalCount);  // 3

        // 인스턴스로도 접근은 되지만 경고 발생 → 비권장
        System.out.println("인스턴스로 접근: " + c1.totalCount);     // 3 (같은 값)

        System.out.println();

        // ================================================================
        // 3. 한 인스턴스가 바꾸면 모두에게 반영된다 (함정)
        // ================================================================
        System.out.println(c1.getStatus()); // totalCount=3
        System.out.println(c2.getStatus()); // totalCount=3

        Counter.totalCount = 999;  // static 필드 직접 수정
        System.out.println("수정 후 c1: " + c1.getStatus()); // totalCount=999
        System.out.println("수정 후 c2: " + c2.getStatus()); // totalCount=999

        System.out.println();

        // ================================================================
        // 4. static 메서드 vs 인스턴스 메서드 호출 방식
        // ================================================================
        Counter.resetTotal();                       // static 메서드: 클래스로 호출
        System.out.println(Counter.getTotalCount()); // 0

        Counter c4 = new Counter("D");
        System.out.println(c4.getStatus());         // 인스턴스 메서드: 객체로 호출

        System.out.println();

        // ================================================================
        // 5. 자주 쓰는 클래스 메서드 예시 (Math, Integer, String)
        // ================================================================
        System.out.println(Math.abs(-10));           // 10
        System.out.println(Math.max(7, 13));         // 13
        System.out.println(Integer.parseInt("123")); // 123
        System.out.println(String.valueOf(456));     // "456"

        // Math.random() — 0.0 이상 1.0 미만의 랜덤 double
        double rand = Math.random();
        System.out.println("random = " + rand);

        // 정수 범위 랜덤 (0~9)
        int randInt = (int)(Math.random() * 10);
        System.out.println("0~9 랜덤 = " + randInt);
    }
}
