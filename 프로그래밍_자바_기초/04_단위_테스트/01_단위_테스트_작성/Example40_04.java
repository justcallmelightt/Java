@Test
@DisplayName("양수 + 음수 덧셈 검증")
void 덧셈_음수포함() {
    assertEquals(-1.0, calculator.add(-3, 2));
}
