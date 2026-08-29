@Test
void 덧셈_한꺼번에() {
    assertAll(
        () -> assertEquals(7.0,  calculator.add(3, 4)),
        () -> assertEquals(0.0,  calculator.add(0, 0)),
        () -> assertEquals(-1.0, calculator.add(-3, 2))
    );
}
