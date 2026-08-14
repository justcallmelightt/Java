@BeforeEach
void setUp() {
    calculator = new Calculator();  // 각 테스트 전에 실행
}

@AfterEach
void tearDown() {
    System.out.println("테스트 완료");  // 각 테스트 후에 실행
}
