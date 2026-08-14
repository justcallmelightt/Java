// 바이트 범위(-128 ~ 127 범위)의 정수만 넣을 것으로 가정
static String toBinary8(int n) {
    return String.format("%8s", Integer.toBinaryString(n & 0xFF)).replace(' ', '0');
}

System.out.println(toBinary8(5));
// 00000101

System.out.println(toBinary8(-5));
// 11111011

System.out.println(toBinary8(-1));
// 11111111

System.out.println(toBinary8(-128));
// 10000000
