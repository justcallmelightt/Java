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
