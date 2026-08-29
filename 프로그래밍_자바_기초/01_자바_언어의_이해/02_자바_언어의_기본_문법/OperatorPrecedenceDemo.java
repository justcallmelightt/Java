public class OperatorPrecedenceDemo {
    public static void main(String[] args) {

        // 1. 산술 연산자 우선순위 (* > +)
        int a = 2 + 3 * 4;
        int b = (2 + 3) * 4;
        System.out.println("2 + 3 * 4   = " + a); // 14 ← * 먼저
        System.out.println("(2 + 3) * 4 = " + b); // 20 ← 괄호 먼저
        System.out.println();

        // 2. 낚시 포인트 - 문자열 연결 + 산술 혼용
        System.out.println("결과 : " + 2 + 3);   // "결과 : 23" ← 낚시!
        System.out.println("결과 : " + (2 + 3)); // "결과 : 5"  ← 괄호로 해결
        System.out.println();

        // 3. 낚시 포인트 - 논리 연산자 우선순위 (&& > ||)
        boolean result1 = true || false && false;   // true || (false && false) → true
        boolean result2 = (true || false) && false; // true && false → false
        System.out.println("true || false && false   = " + result1); // true
        System.out.println("(true || false) && false = " + result2); // false ← 괄호로 달라짐!
        System.out.println();

        // 4. 실무 포인트 - 헷갈리면 무조건 괄호
        int x = 10, y = 3, z = 2;
        int bad  = x + y * z - x / y;         // 얼마인지 바로 보이나요?
        int good = x + (y * z) - (x / y);     // 괄호로 의도를 명확히
        System.out.println("bad  : " + bad);  // 13
        System.out.println("good : " + good); // 13 ← 결과는 같지만 가독성이 다름
        System.out.println();

        // 5. 오른쪽 → 왼쪽 결합 (대입 연산자)
        // 대입 연산자는 대입 후 그 값을 반환 → 오른쪽부터 순차적으로 처리
        int p, q, r;
        p = q = r = 5;  // r=5(5반환) → q=5(5반환) → p=5
        System.out.println("p : " + p); // 5
        System.out.println("q : " + q); // 5
        System.out.println("r : " + r); // 5
        System.out.println();

        // 6. 오른쪽 → 왼쪽 결합 (삼항 연산자)
        // 중첩 삼항은 오른쪽부터 묶임 → 가독성이 나쁘므로 실무에서 지양
        int score = 75;
        String grade = score >= 90 ? "A" : score >= 70 ? "B" : "C";
        // 실제 처리 순서: score >= 90 ? "A" : (score >= 70 ? "B" : "C")
        System.out.println("grade : " + grade);  // B
    }
}
