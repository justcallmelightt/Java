public class AssignmentOperatorsDemo {
    public static void main(String[] args) {

        // 1. 기본 대입 연산자
        int a = 10;
        int b = a;  // a의 값을 b에 복사
        b = 20;     // b를 바꿔도 a는 그대로
        System.out.println("a : " + a);  // 10 ← 영향 없음
        System.out.println("b : " + b);  // 20
        System.out.println();

        // 2. 복합 대입 연산자
        int x = 10;
        System.out.println("x       = " + x);  // 10
        x += 5;
        System.out.println("x += 5  = " + x);  // 15
        x -= 3;
        System.out.println("x -= 3  = " + x);  // 12
        x *= 2;
        System.out.println("x *= 2  = " + x);  // 24
        x /= 4;
        System.out.println("x /= 4  = " + x);  // 6
        x %= 4;
        System.out.println("x %= 4  = " + x);  // 2
        System.out.println();

        // 3. 낚시 포인트 - 복합 대입 연산자의 묵시적 형변환
        // 자바는 byte, short 연산 시 int로 자동 승격(integer promotion)됨
        // 따라서 연산 결과는 int → 다시 byte/short에 대입하려면 명시적 캐스팅 필요
        
        byte by = 10;
        // by = by + 1;      // 컴파일 에러! by + 1 → int 승격, int를 byte에 대입 불가
        by = (byte)(by + 1); // 명시적 캐스팅으로 해결
        by += 1;             // 복합 대입은 묵시적 캐스팅 내장 → (byte)(by + 1)과 동일
        System.out.println("by : " + by); // 12

        short s = 10;
        // s = s + 1;       // 컴파일 에러! s + 1 → int 승격, int를 short에 대입 불가
        s = (short)(s + 1); // 명시적 캐스팅으로 해결
        s += 1;             // 복합 대입은 묵시적 캐스팅 내장 → (short)(s + 1)과 동일
        System.out.println("s  : " + s); // 12
        System.out.println();
    }
}
