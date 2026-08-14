// WrapperDemo.java
// 주제: Wrapper 클래스 - 8개 기본형에 대응하는 객체 타입, 박싱/언박싱

public class WrapperDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. Wrapper 클래스란 - 기본형을 객체로 포장
        // ================================================================
        // 메소드가 객체 타입을 요구하는 상황(예: ArrayList)에서는
        // int, double 같은 기본형을 그대로 못 쓰고 객체로 감싸야 한다.
        // 8개 기본형 -> 대응하는 Wrapper 클래스
        //   byte->Byte, short->Short, int->Integer, long->Long,
        //   float->Float, double->Double, char->Character, boolean->Boolean

        // ================================================================
        // 2. 박싱(Boxing) - 기본형 값으로 Wrapper 객체 만들기
        // ================================================================
        Integer i1 = Integer.valueOf(123);        // 기본형 123 -> Integer 객체
        Double d1 = Double.valueOf(12.34);        // 기본형 12.34 -> Double 객체
        Boolean b1 = Boolean.valueOf(true);       // 기본형 true -> Boolean 객체

        // 문자열로도 Wrapper 객체를 만들 수 있다 (문자열 -> 객체)
        Integer i2 = Integer.valueOf("123");      // 문자열 "123" -> Integer 객체
        Double d2 = Double.valueOf("12.34");      // 문자열 "12.34" -> Double 객체

        System.out.println("valueOf(123)   : " + i1);
        System.out.println("valueOf(\"123\") : " + i2);

        System.out.println();

        // ================================================================
        // 3. 언박싱(Unboxing) - Wrapper 객체에서 기본형 값 꺼내기
        // ================================================================
        int num1 = i1.intValue();       // Integer 객체 -> int 기본값
        double num2 = d1.doubleValue(); // Double 객체 -> double 기본값
        boolean flag = b1.booleanValue(); // Boolean 객체 -> boolean 기본값

        System.out.println("intValue()    : " + num1);
        System.out.println("doubleValue() : " + num2);
        System.out.println("booleanValue(): " + flag);

        System.out.println();

        // ================================================================
        // 4. 문자열 <-> 기본형 변환 (parseXxx는 정적 메소드, 결과가 기본형)
        // ================================================================
        // parseInt() 등은 valueOf()와 헷갈리기 쉬운데 차이가 있다.
        //   Integer.valueOf("123")  -> Integer 객체를 반환
        //   Integer.parseInt("123") -> int 기본형을 바로 반환 (객체 아님)
        int parsed = Integer.parseInt("123");
        boolean parsedFlag = Boolean.parseBoolean("true");
        double parsedDouble = Double.parseDouble("12.34");

        System.out.println("parseInt(\"123\")      : " + parsed);
        System.out.println("parseBoolean(\"true\") : " + parsedFlag);
        System.out.println("parseDouble(\"12.34\") : " + parsedDouble);

        System.out.println();

        // ================================================================
        // 5. 기본형 -> 문자열 / 진법 변환
        // ================================================================
        String str1 = Integer.toString(123);        // "123" (10진법 문자열)
        String hex = Integer.toHexString(123);       // "7b"  (16진법 문자열)
        String octal = Integer.toOctalString(123);   // "173" (8진법 문자열)
        String binary = Integer.toBinaryString(123); // "1111011" (2진법 문자열)

        System.out.println("toString(123)       : " + str1);
        System.out.println("toHexString(123)    : " + hex);
        System.out.println("toOctalString(123)  : " + octal);
        System.out.println("toBinaryString(123) : " + binary);

        System.out.println();

        // ================================================================
        // 6. equals() - Wrapper 객체 비교도 내용 비교가 필요하다
        // ================================================================
        // String 단원에서 다룬 것과 같은 원리: 객체이기 때문에 ==는 주소 비교,
        // 값 비교는 equals()를 써야 안전하다.
        // 참고: new Integer(100)처럼 생성자로 직접 만드는 방식은
        // Java 9부터 deprecated(사용 권장 안 함) 상태다.
        // 실무에서는 Integer.valueOf(100)이나 그냥 오토박싱(Integer a = 100;)을 사용한다.
        // 여기서는 ==와 equals()의 차이를 명확히 보여주기 위해 예외적으로 사용했다.
        Integer a = new Integer(100);
        Integer b = new Integer(100);

        System.out.println("a == b        : " + (a == b));       // false일 수 있음(주소 비교)
        System.out.println("a.equals(b)   : " + a.equals(b));    // true (값 비교)
    }
}
