public class TypeCastingDemo {
    public static void main(String[] args) {
        // 1. 자동 형변환 (작은 타입 → 큰 타입)
        int i = 100;
        long l = i;            // int → long
        double d = i;          // int → double
        System.out.println(l); // 100
        System.out.println(d); // 100.0

        // 2. 정수 + 실수 혼합 연산 (int → double 자동 변환)
        int a = 3;
        double b = 1.5;
        double result = a + b;      // a가 3.0으로 자동 변환
        System.out.println(result); // 4.5

        // 3. 강제 형변환 (큰 타입 → 작은 타입, 데이터 손실 가능)
        int big = 300;
        byte small = (byte) big;   // 하위 1바이트만 남음
        System.out.println(small); // 44 (300의 하위 8비트)

        // 4. 실수 → 정수 강제 형변환 (소수점 버림)
        double pi = 3.14159;
        int piInt = (int) pi;
        System.out.println(piInt); // 3 (소수점 이하 버림)

        // 5. int → float 자동 형변환 (정밀도 손실 주의)
        int precise = 123456789;
        float f = precise;  // 자동 형변환이지만 정밀도 손실 발생
        System.out.println(precise); // 123456789
        System.out.println(f);       // 1.23456792E8 (미세하게 다름!)

        // 6. byte + byte 연산 => 결과는 int
        byte b1 = 10;
        byte b2 = 20;
        // byte b3 = b1 + b2;      // 컴파일 에러! 결과가 int
        byte b3 = (byte)(b1 + b2); // 강제 형변환 필요
        System.out.println(b3);    // 30

        // 7. 정수 나눗셈 (소수점 버림 주의)
        int x = 7;
        int y = 2;
        System.out.println(x / y);         // 3 (소수점 버림!)
        System.out.println((double)x / y); // 3.5 (캐스팅 후 나눗셈)

        // 8. char → int 자동 형변환 (유니코드 값)
        char c = 'A';
        int unicode = c;
        System.out.println(unicode); // 65 (A의 유니코드)

        // 9. int → char 강제 형변환
        int code = 66;
        char ch = (char) code;
        System.out.println(ch); // B
    }
}
