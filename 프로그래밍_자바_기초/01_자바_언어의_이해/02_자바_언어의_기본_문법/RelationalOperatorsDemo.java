public class RelationalOperatorsDemo {
    public static void main(String[] args) {
        // 1. 기본 관계 연산자
        int a = 10, b = 3;
        System.out.println("a > b  : " + (a > b));  // true
        System.out.println("a < b  : " + (a < b));  // false
        System.out.println("a >= b : " + (a >= b)); // true
        System.out.println("a <= b : " + (a <= b)); // false
        System.out.println("a == b : " + (a == b)); // false
        System.out.println("a != b : " + (a != b)); // true
        System.out.println();

        // 2. 낚시 포인트 - 실수 비교 (부동소수점 오차)
        double x = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 == 0.3 : " + (x == 0.3)); // false ← 낚시!
        System.out.println("0.1 + 0.2 결과   : " + x);          // 0.30000000000000004
        // 실수 비교는 오차 범위(epsilon)로 처리해야 함
        double epsilon = 1e-9;
        System.out.println("오차 범위 비교   : " + (Math.abs(x - 0.3) < epsilon)); // true
        System.out.println();

        // 3. 낚시 포인트 - String 비교 (== vs equals)
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println("s1 == s2       : " + (s1 == s2));      // true  ← 문자열 풀(pool) 재사용
        System.out.println("s1 == s3       : " + (s1 == s3));      // false ← new로 생성하면 다른 객체!
        System.out.println("s1.equals(s3)  : " + (s1.equals(s3))); // true  ← 값 비교는 equals()
        System.out.println();

        // 4. 고급 포인트 - Integer 캐싱 범위 (-128 ~ 127)
        Integer n1 = 100;
        Integer n2 = 100;
        Integer n3 = 200;
        Integer n4 = 200;

        System.out.println("n1 == n2 (100) : " + (n1 == n2));      // true  ← 캐싱 범위 내
        System.out.println("n3 == n4 (200) : " + (n3 == n4));      // false ← 캐싱 범위 초과, 다른 객체!
        System.out.println("n3.equals(n4)  : " + (n3.equals(n4))); // true  ← 값 비교는 equals()
    }
}
