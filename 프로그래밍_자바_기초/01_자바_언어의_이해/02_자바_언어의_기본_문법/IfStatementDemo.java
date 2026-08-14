public class IfStatementDemo {
    public static void main(String[] args) {

        // =========================================================
        // 1. 단순 if문 - 조건이 참일 때만 실행
        // =========================================================
        int score = 85;

        if (score >= 60) {
            System.out.println("합격");
        }

        // =========================================================
        // 2. if-else문
        // =========================================================
        int age = 17;

        if (age >= 18) {
            System.out.println("성인입니다.");
        } else {
            System.out.println("미성년자입니다.");
        }

        // =========================================================
        // 3. 다중 if문 (else if)
        // =========================================================
        int point = 72;

        if (point >= 90) {
            System.out.println("A");
        } else if (point >= 80) {
            System.out.println("B");
        } else if (point >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }

        // =========================================================
        // 4. [주의] 조건식에 = 대신 == 를 써야 한다
        //    if (x = 5) 는 컴파일 에러 (Java는 int를 boolean으로 쓸 수 없음)
        //    C/C++ 경험자가 자주 실수함
        // =========================================================
        int x = 5;

        // if (x = 5) { }  // 컴파일 에러
        if (x == 5) {
            System.out.println("x는 5");
        }

        // =========================================================
        // 5. [주의] 중괄호 생략 문법과 dangling else 함정
        //    실행문이 한 줄일 때 중괄호를 생략할 수 있지만, 권장하지 않는다
        //
        //    생략 가능한 예:
        //    if (x > 0)
        //        System.out.println("양수");
        //
        //    중괄호를 생략하면 else가 어떤 if에 붙는지 헷갈린다
        //    아래 코드는 else가 n > 0이 아닌 n > 5에 붙어있다
        // =========================================================
        int n = 10;

        if (n > 0)
            if (n > 5)
                System.out.println("n은 5 초과");
            else
                System.out.println("이 else는 n > 5에 붙어있다");  // dangling else

        // 중괄호를 쓰면 의도가 명확해진다
        if (n > 0) {
            if (n > 5) {
                System.out.println("n은 5 초과");
            }
        } else {
            System.out.println("n은 0 이하");
        }

        // =========================================================
        // 6. [주의] boolean 변수는 == true 비교 없이 바로 쓴다
        // =========================================================
        boolean isLoggedIn = true;

        if (isLoggedIn == true) { // 나쁜 스타일
            System.out.println("로그인됨 (비권장 방식)");
        }
        if (isLoggedIn) { // 권장 스타일
            System.out.println("로그인됨 (권장 방식)");
        }
        if (!isLoggedIn) {
            System.out.println("로그인 안 됨");
        }

        // =========================================================
        // 7. [주의] 실수(float/double) 동등 비교는 피해야 한다
        //    부동소수점 오차로 예상과 다른 결과가 나올 수 있다
        // =========================================================
        double d = 0.1 + 0.2;

        if (d == 0.3) {
            System.out.println("같다");         // 출력 안 됨
        } else {
            System.out.println("다르다: " + d); // 0.30000000000000004
        }

        // =========================================================
        // 8. [고급] 단락 평가 (short-circuit)와 NullPointerException 방어
        //    &&는 앞이 false면 뒤를 실행하지 않는다
        //    ||는 앞이 true면 뒤를 실행하지 않는다
        // =========================================================
        String name = null;

        // if (name.equals("홍길동")) { }  // NullPointerException 발생!

        if (name != null && name.equals("홍길동")) {
            System.out.println("홍길동");
        } else {
            System.out.println("이름 없음 또는 불일치");
        }
    }
}
