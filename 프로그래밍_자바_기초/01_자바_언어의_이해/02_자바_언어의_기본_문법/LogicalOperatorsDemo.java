public class LogicalOperatorsDemo {
    public static void main(String[] args) {
        // 1. 기본 논리 연산자
        boolean a = true, b = false;
        System.out.println("a && b : " + (a && b)); // false
        System.out.println("a || b : " + (a || b)); // true
        System.out.println("!a     : " + (!a));     // false
        System.out.println("!b     : " + (!b));     // true
        System.out.println();

        // 2. 단락 평가 (Short-Circuit Evaluation)
        int x = 0;
        // && : 앞이 false면 뒤는 실행 자체를 안 함
        if (false && (++x > 0)) { }
        System.out.println("&& 단락 후 x : " + x); // 0 ← ++x 실행 안 됨

        // || : 앞이 true면 뒤는 실행 자체를 안 함
        if (true || (++x > 0)) { }
        System.out.println("|| 단락 후 x : " + x); // 0 ← ++x 실행 안 됨
        System.out.println();

        // 3. 낚시 포인트 - NullPointerException 방어 패턴
        String str = null;
        // str.isEmpty()를 먼저 쓰면 NullPointerException 발생!
        // if (str.isEmpty() || str.equals("hello")) { }  // 위험!

        // null 체크를 앞에 두면 단락 평가로 안전하게 처리
        if (str != null && str.equals("hello")) {
            System.out.println("hello!");
        } else {
            System.out.println("str이 null이거나 hello가 아님");  // 여기 출력, NPE 없음
        }

        // 4. 단락 평가와 조건 순서의 중요성
        // 상황 : 성별이 "남"인 학생 (전체의 50%), 수학 90점 이상인 학생 (전체의 10%)이라고 발생 확률을 가정
        String gender = "여";
        int mathScore = 85;

        // 조건 : 두 가지를 모두 만족해야 하는 AND 연산자를 썼다면? (&&)
        // 효율적 - 왜?
        if (mathScore >= 90 && gender.equals("남")) {
            System.out.println("해당 학생");
        }
        // 비효율적 - 왜?
        if (gender.equals("남") && mathScore >= 90) {
            System.out.println("해당 학생");
        }
        System.out.println();

        // 조건 : 둘 중 하나만 만족해도 되는 OR를 썼다면? (||)
        // 효율적 - 왜?
        if (gender.equals("남") || mathScore >= 90) {
            System.out.println("해당 학생");
        }
        // 비효율적 - 왜?
        if (mathScore >= 90 || gender.equals("남")) {
            System.out.println("해당 학생");
        }
    }
}
