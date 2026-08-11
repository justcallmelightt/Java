# Javadoc 사용법

- 원문: http://yubs.online/java/%EA%B8%B0%ED%83%80-%EC%A3%BC%EC%A0%9C/02_javadoc-%EC%9E%91%EC%84%B1.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
// 한 줄 주석 — 코드 설명용

/* 여러 줄 주석
   코드 블록 설명용 */

/** Javadoc 주석
 *  문서 자동 생성용
 */
```

## 코드 블록 2

```text
/**
 * 학생 정보를 저장하는 클래스.
 * 이름, 학번, 점수를 관리한다.
 *
 * @author 홍길동
 * @version 1.0
 */
public class Student {
    private String name;
    private int studentId;
    private int score;
}
```

## 코드 블록 3

```text
/**
 * 두 정수를 받아 합계를 반환한다.
 *
 * @param a 첫 번째 정수
 * @param b 두 번째 정수
 * @return 두 수의 합
 */
public int add(int a, int b) {
    return a + b;
}
```

## 코드 블록 4

```text
/**
 * 직사각형을 나타내는 클래스.
 *
 * @author 작성자이름
 * @version 1.0
 */
public class Rectangle {

    private double width;
    private double height;

    /**
     * 너비와 높이를 받아 Rectangle 객체를 생성한다.
     *
     * @param width  직사각형의 너비 (양수여야 함)
     * @param height 직사각형의 높이 (양수여야 함)
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 직사각형의 넓이를 반환한다.
     *
     * @return 너비 × 높이
     */
    public double getArea() {
        return width * height;
    }

    /**
     * 직사각형의 둘레를 반환한다.
     *
     * @return (너비 + 높이) × 2
     */
    public double getPerimeter() {
        return (width + height) * 2;
    }

    /**
     * 이 직사각형이 정사각형인지 확인한다.
     *
     * @return 너비와 높이가 같으면 true, 다르면 false
     */
    public boolean isSquare() {
        return width == height;
    }
}
```

## 코드 블록 5

```text
javadoc -d docs -encoding UTF-8 -charset UTF-8 -sourcepath src calculator
```

## 코드 블록 6

```text
/**
 * 메서드.
 *
 * @param a a
 * @param b b
 * @return 반환값
 */
public int add(int a, int b) {
    return a + b;
}
```

## 코드 블록 7

```text
/**
 * 두 정수를 더한 합계를 반환한다.
 *
 * @param a 첫 번째 피연산자
 * @param b 두 번째 피연산자
 * @return a와 b의 합
 */
public int add(int a, int b) {
    return a + b;
}
```
