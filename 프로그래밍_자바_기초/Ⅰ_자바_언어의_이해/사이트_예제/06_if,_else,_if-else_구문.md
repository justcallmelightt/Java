# if, else, if-else 구문

- 원문: http://yubs.online/java/(1%ED%95%99%EA%B8%B0)_%EA%B8%B0%EC%B4%88/01_%EC%9E%90%EB%B0%94-%EC%96%B8%EC%96%B4%EC%9D%98-%EC%9D%B4%ED%95%B4/02_%EC%9E%90%EB%B0%94-%EC%96%B8%EC%96%B4%EC%9D%98-%EA%B8%B0%EB%B3%B8-%EB%AC%B8%EB%B2%95-03)-%EC%A0%9C%EC%96%B4%EB%AC%B8.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
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
```

## 코드 블록 2

```text
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
```

## 코드 블록 3

```text
public class ForLoopDemo {
    public static void main(String[] args) {

        // =========================================================
        // 1. 기본 for문 - 증가/감소
        // =========================================================
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();

        for (int i = 10; i >= 1; i--) {
            System.out.print(i + "\t");
        }
        System.out.println();

        // =========================================================
        // 2. 변화식 응용 - i += 4
        //    반복 변수는 루프 밖에서도 참조할 수 있다 (루프 밖 선언 시)
        // =========================================================
        int i;
        for (i = 1; i <= 10; i += 4) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("반복문을 빠져나온 후의 i 값 : " + i);  // 13

        // =========================================================
        // 3. for문 안에 if문 - 조건에 맞는 값만 처리
        // =========================================================
        for (int j = 1; j <= 10; j++) {
            if (j % 2 == 1) {
                System.out.print(j + "\t");
            }
        }
        System.out.println();

        // =========================================================
        // 4. 누적 합산
        // =========================================================
        int sum = 0;
        for (int j = 1; j <= 10; j++) {
            sum += j;
        }
        System.out.println("1~10까지 정수의 합은 " + sum + "이다.");

        // =========================================================
        // [교과서 실습] 짝수 합 / 홀수 합
        // =========================================================
        int evenSum = 0, oddSum = 0;
        for (int j = 1; j <= 10; j++) {
            if (j % 2 == 0) {
                evenSum += j;
            } else {
                oddSum += j;
            }
        }
        System.out.println("1~10까지의 짝수의 합은 " + evenSum + "이고, 홀수의 합은 " + oddSum + "이다.");

        // =========================================================
        // 5. [주의] for문 헤더의 세 요소는 모두 생략 가능 → 무한 루프
        //    for (;;) { }  // 탈출 조건 없으면 프로그램이 종료되지 않음
        //    반드시 내부에 break 등 탈출 수단이 있어야 한다
        // =========================================================

        // =========================================================
        // 6. [주의] 반복 변수 스코프 - 선언 위치에 따라 달라진다
        // =========================================================

        // 헤더 안에 선언 → 루프 밖에서 참조 불가
        for (int k = 0; k < 3; k++) { }
        // System.out.println(k);  // 컴파일 에러: k는 for 블록 안에서만 유효

        // 헤더 밖에 선언 → 루프 종료 후에도 참조 가능
        int k;
        for (k = 0; k < 3; k++) { }
        System.out.println("루프 종료 후 k = " + k);  // 3

        // =========================================================
        // 7. 중첩 for문 - 기본
        //    바깥 루프: 행, 안쪽 루프: 열
        // =========================================================
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 5; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        // =========================================================
        // 8. 중첩 for문 - 삼각형 패턴 (안쪽 조건을 바깥 변수로 제어)
        // =========================================================
        for (int row = 1; row <= 5; row++) {
            for (int col = 5; col >= row; col--) {
                System.out.print("*");
            }
            System.out.println();
        }

        // =========================================================
        // [교과서 실습] 삼각형 패턴 (증가형)
        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 4
        // 1 2 3 4 5
        // =========================================================
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        // =========================================================
        // 9. [고급] for문 헤더 콤마(,) 패턴
        //    초기식과 변화식에는 콤마로 여러 식을 나열할 수 있다
        //    (조건식은 콤마 불가 - boolean 식 하나만 허용)
        // =========================================================

        // 두 변수를 동시에 초기화하고 동시에 변화 - 앞뒤에서 좁혀오기
        for (int lo = 1, hi = 10; lo <= hi; lo++, hi--) {
            System.out.print("lo=" + lo + " hi=" + hi + "  ");
        }
        System.out.println();
        // 출력: lo=1 hi=10  lo=2 hi=9  lo=3 hi=8  lo=4 hi=7  lo=5 hi=6

        // 조건식에 콤마 불가 - && / || 로 결합해야 한다
        // for (int x = 0; x < 5, x > -1; x++) { }  // 컴파일 에러
        for (int x = 0; x < 5 && x > -1; x++) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
```

## 코드 블록 4

```text
public class WhileLoopDemo {
    public static void main(String[] args) {

        // =========================================================
        // 1. 기본 while문
        // =========================================================
        int i = 1;
        while (i <= 10) {
            System.out.print(i + "\t");
            i++;
        }
        System.out.println();

        // =========================================================
        // 2. 변화식 응용 - i += 4, 루프 후 변수 값 확인
        // =========================================================
        i = 1;
        while (i <= 10) {
            System.out.print(i + "\t");
            i += 4;
        }
        System.out.println();
        System.out.println("반복문을 빠져나온 후의 i 값 : " + i);  // 13

        // =========================================================
        // [교과서 실습] 짝수 출력 / 합산 / 짝수합·홀수합
        // =========================================================
        i = 1;
        while (i <= 10) {
            if (i % 2 == 0) {
                System.out.print(i + "\t");
            }
            i++;
        }
        System.out.println();

        int sum = 0;
        i = 1;
        while (i <= 10) {
            sum += i;
            i++;
        }
        System.out.println("1~10까지 정수의 합은 " + sum + "이다.");

        int evenSum = 0, oddSum = 0;
        i = 1;
        while (i <= 10) {
            if (i % 2 == 0) {
                evenSum += i;
            } else {
                oddSum += i;
            }
            i++;
        }
        System.out.println("1~10까지의 짝수의 합은 " + evenSum + "이고, 홀수의 합은 " + oddSum + "이다.");

        // =========================================================
        // 3. [핵심] while의 전형적인 사용 패턴: 종료 조건을 미리 모를 때
        //    → 입력값이 0이 될 때까지 반복 (sentinel value 패턴)
        // =========================================================
        //  Scanner scan = new Scanner(System.in);
        //  int score = scan.nextInt();
        //  while (score != 0) {
        //      sum += score;
        //      cnt++;
        //      score = scan.nextInt();
        //  }

        // =========================================================
        // 4. [주의] while문에서 변화식을 빠뜨리면 무한 루프
        // =========================================================
        // int k = 1;
        // while (k <= 10) {
        //     System.out.println(k);
        //     // k++ 빠짐 → 무한 루프
        // }

        // =========================================================
        // 5. do-while문 - 조건과 무관하게 최소 1번은 실행된다
        // =========================================================
        i = 11;
        do {
            System.out.print(i + "\t");
            i++;
        } while (i <= 10);
        System.out.println();
        // i=11로 시작해 조건(i<=10)이 처음부터 거짓이지만 11은 출력됨

        // =========================================================
        // 6. do-while - 변화식 응용
        // =========================================================
        i = 1;
        do {
            System.out.print(i + "\t");
            i += 4;
        } while (i <= 10);
        System.out.println();
        System.out.println("반복문을 빠져나온 후의 i 값 : " + i);  // 13

        // =========================================================
        // [교과서 실습] do-while로 짝수 출력 / 짝수합·홀수합
        // =========================================================
        i = 1;
        do {
            if (i % 2 == 0) {
                System.out.print(i + "\t");
            }
            i++;
        } while (i <= 10);
        System.out.println();

        evenSum = 0;
        oddSum = 0;
        i = 1;
        do {
            if (i % 2 == 0) {
                evenSum += i;
            } else {
                oddSum += i;
            }
            i++;
        } while (i <= 10);
        System.out.println("1~10까지의 짝수의 합은 " + evenSum + "이고, 홀수의 합은 " + oddSum + "이다.");

        // =========================================================
        // 7. [핵심] while vs do-while 차이 정리
        //    while    : 조건 먼저 검사 → 조건이 처음부터 거짓이면 0회 실행
        //    do-while : 실행 먼저      → 조건이 처음부터 거짓이어도 1회 실행
        // =========================================================
        int a = 0;

        while (a > 0) {
            System.out.println("while: 실행됨");    // 출력 안 됨
        }

        do {
            System.out.println("do-while: 실행됨"); // 출력됨 (1회)
        } while (a > 0);
    }
}
```

## 코드 블록 5

```text
public class BreakContinueDemo {

    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void printMessage() {
        System.out.println("메시지 출력");
        return;
    }

    public static void main(String[] args) {

        // =========================================================
        // 1. break - 반복문을 즉시 탈출
        //    break 이전에 출력 → 7 미포함
        // =========================================================
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                break;
            }
            System.out.print(i + "\t");
        }
        System.out.println();
        // 출력: 1 2 3 4 5 6

        // break 이후에 출력 → 7 포함
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "\t");
            if (i == 7) {
                break;
            }
        }
        System.out.println();
        // 출력: 1 2 3 4 5 6 7

        // =========================================================
        // 2. [핵심] break는 가장 가까운 반복문 하나만 탈출한다
        //    중첩 루프에서 바깥 루프까지 한 번에 탈출하지 못한다
        // =========================================================
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    break;              // 안쪽 for만 탈출
                }
                System.out.print("i=" + i + " j=" + j + "  ");
            }
            System.out.println();
        }
        // 출력: i=1 j=1 / i=2 j=1 / i=3 j=1  (바깥 루프는 계속 돈다)

        // =========================================================
        // 3. continue - 이후 코드를 건너뛰고 다음 반복으로 이동
        // =========================================================
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                continue;
            }
            System.out.print(i + "\t");
        }
        System.out.println();
        // 출력: 1 2 3 4 5 6 8 9 10

        // =========================================================
        // 4. [핵심] while에서 continue 사용 시 변화식 위치 주의
        //    변화식이 continue 아래에 있으면 건너뛰어 무한 루프 발생
        // =========================================================
        int i = 0;
        while (i < 10) {
            i++;
            if (i == 7) {
                continue;               // i++ 이후이므로 안전
            }
            System.out.print(i + "\t");
        }
        System.out.println();

        // 아래는 무한 루프 예시 (주석 처리)
        // int k = 0;
        // while (k < 10) {
        //     if (k == 7) {
        //         continue;            // k가 7이면 k++를 건너뜀 → 영원히 7
        //     }
        //     k++;
        // }

        // =========================================================
        // 5. return - 메서드 종료 및 값 반환
        // =========================================================
        System.out.println("합계 : " + sum(5, 3));
        printMessage();

        // =========================================================
        // 6. [고급] return vs break
        //    break는 반복문만 탈출하지만, return은 메서드 자체를 종료한다
        // =========================================================
        System.out.println("첫 번째 짝수: " + findFirstEven(1, 10));
    }

    public static int findFirstEven(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (i % 2 == 0) {
                return i;               // 찾는 순간 메서드 종료
            }
        }
        return -1;
    }
}
```
