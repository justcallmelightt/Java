public class BitwiseOperatorsDemo {
    public static void main(String[] args) {

        // 1. 기본 비트 연산자
        int a = 0b1010;  // 10
        int b = 0b1100;  // 12
        System.out.println("a      = " + Integer.toBinaryString(a));  // 1010
        System.out.println("b      = " + Integer.toBinaryString(b));  // 1100
        System.out.println();
        System.out.println("a & b  = " + Integer.toBinaryString(a & b) + " (" + (a & b) + ")");  // 1000 (8)
        System.out.println("a | b  = " + Integer.toBinaryString(a | b) + " (" + (a | b) + ")");  // 1110 (14)
        System.out.println("a ^ b  = " + Integer.toBinaryString(a ^ b) + " (" + (a ^ b) + ")");  // 0110 (6)
        System.out.println("~a     = " + (~a));                                                   // -11

        System.out.println();

        // 2. 비트 시프트 연산자
        int x = 8;  // 0b00001000
        System.out.println("x      = " + Integer.toBinaryString(x) + " (" + x + ")");
        System.out.println("x << 1 = " + Integer.toBinaryString(x << 1) + " (" + (x << 1) + ")");  // 16 (* 2)
        System.out.println("x >> 1 = " + Integer.toBinaryString(x >> 1) + " (" + (x >> 1) + ")");  // 4  (/ 4)
        System.out.println("x << 2 = " + Integer.toBinaryString(x << 2) + " (" + (x << 2) + ")");  // 32 (* 4)
        System.out.println("x >> 2 = " + Integer.toBinaryString(x >> 2) + " (" + (x >> 2) + ")");  // 2  (/ 4)

        System.out.println();

        // 3. 고급 포인트 - 실무 활용 (IPv4 파싱)
        int ip = 0xC0A80001;  // 192.168.0.1
        int octet1 = (ip >> 24) & 0xFF;
        int octet2 = (ip >> 16) & 0xFF;
        int octet3 = (ip >> 8)  & 0xFF;
        int octet4 =  ip        & 0xFF;
        System.out.println("IP 주소 : " + octet1 + "." + octet2 + "." + octet3 + "." + octet4);  // 192.168.0.1

        System.out.println();

        // 4. 고급 포인트 - 플래그 처리 (권한 관리)
        final int READ    = 0b001;  // 1
        final int WRITE   = 0b010;  // 2
        final int EXECUTE = 0b100;  // 4

        int permission = READ | WRITE;  // READ + WRITE 권한 부여
        System.out.println("READ 권한    : " + ((permission & READ)    != 0));  // true
        System.out.println("WRITE 권한   : " + ((permission & WRITE)   != 0));  // true
        System.out.println("EXECUTE 권한 : " + ((permission & EXECUTE) != 0));  // false

        // 권한 추가 / 제거
        permission |= EXECUTE;   // EXECUTE 추가
        System.out.println("EXECUTE 추가 후 : " + ((permission & EXECUTE) != 0));  // true
        permission &= ~WRITE;    // WRITE 제거
        System.out.println("WRITE 제거 후   : " + ((permission & WRITE)   != 0));  // false
    }
}
