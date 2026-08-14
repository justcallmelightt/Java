public class IncrementDecrementDemo {
    public static void main(String[] args) {

        // 1. 기본 증감 연산자
        int a = 5;
        System.out.println("a   : " + a);    // 5
        System.out.println("a++ : " + a++);  // 5 ← 출력 후 증가
        System.out.println("a   : " + a);    // 6
        System.out.println("++a : " + ++a);  // 7 ← 증가 후 출력
        System.out.println("a   : " + a);    // 7
        System.out.println();

        // 2. 낚시 포인트 - 후위 vs 전위 차이
        int b = 10;
        int c = b++;  // b의 현재값(10)을 c에 대입 후 b 증가
        System.out.println("b : " + b);  // 11
        System.out.println("c : " + c);  // 10 ← 낚시! 11 아님

        int d = 10;
        int e = ++d;  // d 먼저 증가 후 e에 대입
        System.out.println("d : " + d);  // 11
        System.out.println("e : " + e);  // 11
        System.out.println();

        // 3. 낚시 포인트 - 복합 표현식
        int x = 5;
        int y = x++ + ++x; // (5) + (7) = 12, x는 7
        // x++ : 현재값 5 사용 후 x = 6
        // ++x : x를 6 → 7로 증가 후 7 사용
        System.out.println("x : " + x);  // 7
        System.out.println("y : " + y);  // 12
        System.out.println();

        // 4. 고급 포인트 - 반복문에서 후위/전위 차이 없음
        // 반복문 증감식에서는 결과값을 사용하지 않으므로 i++, ++i 결과 동일
        System.out.println("i++ 반복문");
        for (int i = 0; i < 3; i++) {
            System.out.println("i : " + i); // 0, 1, 2
        }

        System.out.println("++i 반복문");
        for (int i = 0; i < 3; ++i) {
            System.out.println("i : " + i); // 0, 1, 2 ← 결과 동일
        }
    }
}
