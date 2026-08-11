# JUnit 단위 테스트

- 원문: http://yubs.online/java/%EA%B8%B0%ED%83%80-%EC%A3%BC%EC%A0%9C/03_%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%BC%80%EC%9D%B4%EC%8A%A4-%EC%9E%91%EC%84%B1.html
- 용도: yubs.online 수업 페이지의 코드 블록을 원문 순서대로 보존한 학습 자료입니다.
- 실행 가능한 예제는 같은 단원의 Java 파일을 우선 참고하세요.

## 코드 블록 1

```text
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.10.0'
}
```

## 코드 블록 2

```text
CalcDemo/
└── src/
    ├── main/
    │   └── java/
    │       └── calculator/
    │           ├── Calculator.java
    │           └── CalculatorApp.java
    └── test/
        └── java/
            └── calculator/
                └── CalculatorTest.java   ← 테스트 코드는 여기
```

## 코드 블록 3

```text
package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();  // 각 테스트 실행 전에 호출됨
    }

    @Test
    void 덧셈() {
        assertEquals(7.0, calculator.add(3, 4));
        assertEquals(0.0, calculator.add(0, 0));
        assertEquals(-1.0, calculator.add(-3, 2));
    }

    @Test
    void 뺄셈() {
        assertEquals(1.0, calculator.subtract(3, 2));
        assertEquals(-5.0, calculator.subtract(0, 5));
    }

    @Test
    void 곱셈() {
        assertEquals(12.0, calculator.multiply(3, 4));
        assertEquals(0.0, calculator.multiply(5, 0));
    }

    @Test
    void 나눗셈() {
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(0.5, calculator.divide(1, 2));
    }

    @Test
    void 나눗셈_0으로_나누면_예외발생() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}
```

## 코드 블록 4

```text
@Test
void 덧셈_실패케이스() {
    assertEquals(10.0, calculator.add(3, 4));  // 실제는 7.0인데 10.0으로 검증
}
```

## 코드 블록 5

```text
expected: <10.0> but was: <7.0>
```

## 코드 블록 6

```text
@BeforeEach
void setUp() {
    calculator = new Calculator();  // 각 테스트 전에 실행
}

@AfterEach
void tearDown() {
    System.out.println("테스트 완료");  // 각 테스트 후에 실행
}
```

## 코드 블록 7

```text
@Test
@DisplayName("양수 + 음수 덧셈 검증")
void 덧셈_음수포함() {
    assertEquals(-1.0, calculator.add(-3, 2));
}
```

## 코드 블록 8

```text
@Test
@Disabled("미구현 기능")
void 아직_안만든_테스트() {
    // ...
}
```

## 코드 블록 9

```text
@Test
void 덧셈_한꺼번에() {
    assertAll(
        () -> assertEquals(7.0,  calculator.add(3, 4)),
        () -> assertEquals(0.0,  calculator.add(0, 0)),
        () -> assertEquals(-1.0, calculator.add(-3, 2))
    );
}
```
