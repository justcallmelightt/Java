# Scanner 활용 간단 복습

- 원문: http://yubs.online/java/(1%ED%95%99%EA%B8%B0)_%EA%B8%B0%EC%B4%88/01_%EC%9E%90%EB%B0%94-%EC%96%B8%EC%96%B4%EC%9D%98-%EC%9D%B4%ED%95%B4-(%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4)/98_%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-1-(scanner).html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
// import 필요
import java.util.Scanner;
```

## 코드 블록 2

```text
// Scanner 객체 생성
Scanner sc = new Scanner(System.in);

// 기본 사용 예시
System.out.print("정수 입력 : ");
int num = sc.nextInt();
System.out.println("입력값 : " + num);

System.out.print("실수 입력 : ");
double d = sc.nextDouble();
System.out.println("입력값 : " + d);

System.out.print("문자열 입력 : ");
String str = sc.nextLine();
System.out.println("입력값 : " + str);

// 주의 - nextInt(), nextLong(), nextDouble() 후 nextLine() 사용 시 버퍼 문제
// 숫자 입력 메서드는 \n을 버퍼에 남기므로, 이후 nextLine() 사용 전 반드시 아래 패턴 필요
int age = sc.nextInt();
// 버퍼에 남은 \n 제거 (필수 패턴)
sc.nextLine();
// 정상 입력
String name = sc.nextLine();

// 사용 후 닫기 (일단 안해도 됨)
sc.close();
```

## 코드 블록 3

```text
이름을 입력받아 "안녕하세요, [이름]님!"을 출력하는 프로그램을 작성하시오.
```

## 코드 블록 4

```text
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.println("안녕하세요, " + name + "님!");
        sc.close();
    }
}
```

## 코드 블록 5

```text
두 정수를 입력받아 합, 차, 곱, 나머지를 출력하는 프로그램을 작성하시오.
```

## 코드 블록 6

```text
import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 : ");
        int a = sc.nextInt();
        System.out.print("두 번째 정수 : ");
        int b = sc.nextInt();
        System.out.println("합     : " + (a + b));
        System.out.println("차     : " + (a - b));
        System.out.println("곱     : " + (a * b));
        System.out.println("나머지 : " + (a % b));
        sc.close();
    }
}
```

## 코드 블록 7

```text
섭씨온도를 입력받아 화씨온도로 변환하여 출력하는 프로그램을 작성하시오.

조건1. 화씨 = 섭씨 * 9 / 5 + 32
```

## 코드 블록 8

```text
import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("섭씨 온도 : ");
        double celsius = sc.nextDouble();
        double fahrenheit = celsius * 9 / 5 + 32;
        System.out.println("화씨 온도 : " + fahrenheit);
        sc.close();
    }
}
```

## 코드 블록 9

```text
시간당 시급과 근무 시간을 입력받아 급여를 출력하는 프로그램을 작성하시오.

조건1. 최저시급은 상수로 정의한다. (9,860원)
조건2. 최저시급 기준의 급여와 실제 급여의 차이를 함께 출력한다. (ex: (시간당 시급 * 근무시간) - (최저시급 * 근무시간)을 구하라는 것)
```

## 코드 블록 10

```text
import java.util.Scanner;

public class Wage {
    public static void main(String[] args) {
        final int MIN_WAGE = 9860;
        Scanner sc = new Scanner(System.in);
        System.out.print("시급 : ");
        int wage = sc.nextInt();
        System.out.print("근무 시간 : ");
        int hours = sc.nextInt();
        int minPay = MIN_WAGE * hours;
        int actualPay = wage * hours;
        System.out.println("최저시급 기준 급여 : " + minPay);
        System.out.println("실제 급여          : " + actualPay);
        System.out.println("차이               : " + (actualPay - minPay) + "원");
        sc.close();
    }
}
```

## 코드 블록 11

```text
물건 가격과 수량을 입력받아 총액과 부가세를 출력하는 프로그램을 작성하시오.

조건1. 부가세율은 상수로 정의한다. (10%)
```

## 코드 블록 12

```text
import java.util.Scanner;

public class Tax {
    public static void main(String[] args) {
        final double TAX_RATE = 0.1;
        Scanner sc = new Scanner(System.in);
        System.out.print("가격 : ");
        int price = sc.nextInt();
        System.out.print("수량 : ");
        int qty = sc.nextInt();
        int total = price * qty;
        System.out.println("총액   : " + total);
        System.out.println("부가세 : " + (total * TAX_RATE));
        sc.close();
    }
}
```

## 코드 블록 13

```text
세 과목(국어, 영어, 수학) 점수를 입력받아 합계와 평균을 출력하는 프로그램을 작성하시오.

조건1. 평균은 소수점을 포함하여 출력한다.
```

## 코드 블록 14

```text
import java.util.Scanner;

public class Avg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("국어 : ");
        int kor = sc.nextInt();
        System.out.print("영어 : ");
        int eng = sc.nextInt();
        System.out.print("수학 : ");
        int math = sc.nextInt();
        int total = kor + eng + math;
        double avg = (double) total / 3;
        System.out.println("합계 : " + total);
        System.out.println("평균 : " + avg);
        sc.close();
    }
}
```

## 코드 블록 15

```text
직사각형의 가로와 세로를 입력받아 넓이와 둘레를 출력하는 프로그램을 작성하시오.

조건1. 넓이 = 가로 * 세로
조건2. 둘레 = 2 * (가로 + 세로)
```

## 코드 블록 16

```text
import java.util.Scanner;

public class Rect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("가로 : ");
        int width = sc.nextInt();
        System.out.print("세로 : ");
        int height = sc.nextInt();
        System.out.println("넓이 : " + (width * height));
        System.out.println("둘레 : " + (2 * (width + height)));
        sc.close();
    }
}
```

## 코드 블록 17

```text
원기둥의 반지름과 높이를 입력받아 부피와 겉넓이를 출력하는 프로그램을 작성하시오.

조건1. 파이값은 상수로 정의한다.
조건2. 부피 = π * r² * h
조건3. 겉넓이 = 2 * π * r² + 2 * π * r * h
```

## 코드 블록 18

```text
import java.util.Scanner;

public class Cylinder {
    public static void main(String[] args) {
        final double PI = 3.14;
        Scanner sc = new Scanner(System.in);
        System.out.print("반지름 : ");
        int r = sc.nextInt();
        System.out.print("높이   : ");
        int h = sc.nextInt();
        System.out.println("부피   : " + (PI * r * r * h));
        System.out.println("겉넓이 : " + (2 * PI * r * r + 2 * PI * r * h));
        sc.close();
    }
}
```

## 코드 블록 19

```text
원금과 연이율, 기간(년)을 입력받아 단리 이자와 최종 금액을 출력하는 프로그램을 작성하시오.

조건1. 연이율은 실수로 입력한다. (예 : 0.05 = 5%)
조건2. 이자 = 원금 * 연이율 * 기간
조건3. 최종 금액 = 원금 + 이자
```

## 코드 블록 20

```text
import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원금 : ");
        int principal = sc.nextInt();
        System.out.print("연이율 : ");
        double rate = sc.nextDouble();
        System.out.print("기간(년) : ");
        int years = sc.nextInt();
        double interest = principal * rate * years;
        System.out.println("이자      : " + interest);
        System.out.println("최종 금액 : " + (principal + interest));
        sc.close();
    }
}
```

## 코드 블록 21

```text
총 초(seconds)를 입력받아 시, 분, 초로 변환하여 출력하는 프로그램을 작성하시오.

조건1. 나눗셈과 나머지 연산자만 사용한다.

입력 예시 : 3795
출력 예시 : 1시간 3분 15초
```

## 코드 블록 22

```text
import java.util.Scanner;

public class TimeConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("초 입력 : ");
        int seconds = sc.nextInt();
        int hours   = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs    = seconds % 60;
        System.out.println(hours + "시간 " + minutes + "분 " + secs + "초");
        sc.close();
    }
}
```
