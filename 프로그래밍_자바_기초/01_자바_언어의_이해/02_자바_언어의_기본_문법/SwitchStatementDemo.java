public class SwitchStatementDemo {
    public static void main(String[] args) {

        // =========================================================
        // 1. 기본 switch문
        // =========================================================
        int day = 3;

        switch (day) {
            case 1: System.out.println("월요일"); break;
            case 2: System.out.println("화요일"); break;
            case 3: System.out.println("수요일"); break;
            default: System.out.println("기타");
        }

        // =========================================================
        // 2. [핵심] fall-through - break를 생략하면 다음 case로 흘러내린다
        //    의도치 않은 fall-through는 버그의 주요 원인
        // =========================================================
        int n = 2;

        switch (n) {
            case 1: System.out.println("case 1");
            case 2: System.out.println("case 2");   // 여기서 시작
            case 3: System.out.println("case 3");   // break 없으므로 계속 실행
            default: System.out.println("default"); // 여기까지 출력됨
        }
        // 출력: case 2 / case 3 / default

        // =========================================================
        // 3. [활용] fall-through를 의도적으로 사용하는 경우
        //    여러 case에 동일한 처리를 하고 싶을 때
        // =========================================================
        int month = 4;
        int lastDay;

        switch (month) {
            case 1: case 3: case 5: case 7:
            case 8: case 10: case 12:
                lastDay = 31; break;
            case 4: case 6: case 9: case 11:
                lastDay = 30; break;
            case 2:
                lastDay = 28; break;
            default:
                lastDay = -1;
        }
        System.out.println(month + "월의 마지막 날: " + lastDay);

        // =========================================================
        // 4. 조건식 타입: int 계열 외에 char, String도 가능
        //    (float, double, long은 불가)
        // =========================================================
        char grade = 'B';

        switch (grade) {
            case 'A': System.out.println("우수"); break;
            case 'B': System.out.println("보통"); break;
            case 'C': System.out.println("미흡"); break;
            default:  System.out.println("해당 없음");
        }

        String lang = "Java";

        switch (lang) {
            case "Java":   System.out.println("JVM 언어"); break;
            case "Python": System.out.println("인터프리터 언어"); break;
            default:       System.out.println("기타 언어");
        }

        // =========================================================
        // 5. [주의] String switch는 내부적으로 equals()로 비교한다
        //    → null을 넣으면 NullPointerException 발생
        // =========================================================
        String input = null;

        // switch (input) { ... }  // NullPointerException 발생!

        if (input != null) {
            switch (input) {
                case "Java": System.out.println("Java"); break;
                default:     System.out.println("기타");
            }
        }

        // =========================================================
        // 6. [주의] switch 조건식에 실수(float/double), long은 사용 불가
        //    정수형이라도 (int)로 변환해서 사용해야 하는 경우가 있다
        // =========================================================
        double average = 82.7;

        // switch (average) { }  // 컴파일 에러: double 불가

        switch ((int) average / 10) {
            case 10:
            case 9:  System.out.println("A"); break;
            case 8:  System.out.println("B"); break;
            case 7:  System.out.println("C"); break;
            default: System.out.println("F");
        }

        // =========================================================
        // 7. [고급] switch 표현식 (Java 14+, -> 화살표 문법)
        //    break 없이도 fall-through가 발생하지 않는다
        //    결과값을 변수에 바로 대입 가능
        // =========================================================
        int number = 2;

        String result = switch (number) {
            case 1 -> "숫자 1이다.";
            case 2 -> "숫자 2이다.";
            case 3 -> "숫자 3이다.";
            default -> "숫자 1, 2, 3 중 하나가 아니다.";
        };
        System.out.println(result);

        // =========================================================
        // 8. [고급] switch 표현식에서 여러 case를 콤마로 묶기 (Java 14+)
        // =========================================================
        int m = 6;

        int days = switch (m) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11            -> 30;
            case 2                      -> 28;
            default                     -> -1;
        };
        System.out.println(m + "월: " + days + "일");
    }
}
