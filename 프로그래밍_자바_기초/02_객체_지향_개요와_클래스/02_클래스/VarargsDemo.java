// VarargsDemo.java
// 주제: 가변 인자(varargs) - 개수가 유동적인 매개변수

public class VarargsDemo {

    // ================================================================
    // 1. 기본 가변 인자 - int... 로 선언, 내부적으로 배열로 처리됨
    // ================================================================
    static void printNumbers(int... numbers) {
        System.out.print("전달된 숫자들: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
        System.out.println("배열 길이: " + numbers.length); // 배열처럼 .length 사용 가능
    }

    // ================================================================
    // 2. 일반 매개변수와 혼합 - 가변 인자는 반드시 마지막에
    // ================================================================
    static void log(String level, String... messages) {
        System.out.print("[" + level + "] ");
        for (String msg : messages) {
            System.out.print(msg + " ");
        }
        System.out.println();
    }

    // ================================================================
    // 3. 가변 인자 메서드 오버로딩 주의점
    //    - 컴파일러가 어떤 메서드를 선택할지 모호해질 수 있다
    // ================================================================
    static void ambiguous(int... nums) {
        System.out.println("int... 버전");
    }

    // static void ambiguous(int a, int... nums) { }
    // → ambiguous(1) 호출 시 어느 쪽인지 모호 → 컴파일 에러 가능

    // ================================================================
    // 4. 가변 인자 vs 배열 직접 전달
    // ================================================================
    static int sum(int... nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        return total;
    }

    public static void main(String[] args) {

        // 인자 개수 제한 없음
        printNumbers(1, 2, 3);
        printNumbers(10, 20, 30, 40, 50);

        // 인자를 전달하지 않아도 됨 → numbers.length == 0, 반복문 실행 안 됨
        printNumbers();

        System.out.println();

        // 일반 매개변수 + 가변 인자
        log("INFO", "서버 시작");
        log("ERROR", "파일 없음", "경로 오류");
        log("DEBUG"); // 메시지 없이 호출도 가능

        System.out.println();

        // 가변 인자에 배열을 직접 넘겨도 동작
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("sum(1,2,3) = " + sum(1, 2, 3));
        System.out.println("sum(arr)   = " + sum(arr));  // 배열 직접 전달

        System.out.println();

        // ================================================================
        // 5. String.format - 가변 인자를 활용하는 표준 라이브러리 예시
        // ================================================================
        String name = "철수";
        int age = 30;
        String gender = "남자";

        String s1 = String.format("이름: %s, 나이: %d", name, age);
        String s2 = String.format("이름: %s, 나이: %d, 성별: %s", name, age, gender);
        System.out.println(s1);
        System.out.println(s2);

        // printf도 내부적으로 가변 인자 사용
        System.out.printf("이름: %s, 나이: %d%n", name, age);
    }
}
