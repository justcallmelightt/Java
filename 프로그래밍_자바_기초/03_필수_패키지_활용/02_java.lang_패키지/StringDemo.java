// StringDemo.java
// 주제: String 클래스 - 문자열 리터럴 풀(==)과 주요 메소드

public class StringDemo {
    public static void main(String[] args) {
        // ================================================================
        // 1. 문자열 리터럴 vs new String() - 저장 위치가 다르다
        // ================================================================
        // 리터럴("...")로 만든 문자열은 "리터럴 풀"이라는 특별한 공간에 저장되고,
        // 같은 내용이면 새로 안 만들고 기존 걸 재사용한다.
        String a = "Happy";
        String b = "Happy";

        // new String()으로 만들면 항상 새로운 객체를 힙 메모리에 생성한다.
        String c = new String("Happy");

        System.out.println("a == b        : " + (a == b));       // true (같은 리터럴 재사용)
        System.out.println("a == c        : " + (a == c));       // false (c는 새로 만든 객체)
        System.out.println("a.equals(c)   : " + a.equals(c));    // true (내용은 같음)

        System.out.println();

        // ================================================================
        // 2. 자주 쓰는 String 메소드
        // ================================================================
        String s = "  Happy HiSchool  ";

        System.out.println("charAt(6)      : " + s.charAt(6));           // 특정 위치의 문자 하나
        System.out.println("length()       : " + s.length());           // 문자열 길이(공백 포함)
        System.out.println("indexOf(\"Hi\")  : " + s.indexOf("Hi"));      // 위치를 못 찾으면 -1 반환
        System.out.println("contains(\"Hi\") : " + s.contains("Hi"));     // 포함 여부만 true/false로

        System.out.println();

        // ================================================================
        // 3. 원본은 그대로, 새 문자열을 "반환"하는 메소드들
        // ================================================================
        // String은 한 번 만들어지면 내용을 바꿀 수 없다(불변, immutable).
        // 그래서 아래 메소드들은 원본 s를 바꾸는 게 아니라, 결과를 새로운 문자열로 돌려준다.

        String trimmed = s.trim();                             // 양쪽 공백 제거
        String replaced = trimmed.replace("Happy", "Cool");    // Happy -> Cool로 교체
        String sub = trimmed.substring(6);                      // 인덱스 6부터 끝까지 잘라냄
        String lower = trimmed.toLowerCase();                   // 소문자로 변환
        String upper = trimmed.toUpperCase();                   // 대문자로 변환

        System.out.println("trim()          : \"" + trimmed + "\"");
        System.out.println("replace()       : " + replaced);
        System.out.println("substring(6)    : " + sub);
        System.out.println("toLowerCase()   : " + lower);
        System.out.println("toUpperCase()   : " + upper);

        System.out.println();

        // ================================================================
        // 4. 실수하기 쉬운 부분 - 반환값을 안 받으면?
        // ================================================================
        s.trim();  // 이렇게만 쓰면 공백이 제거된 결과가 그냥 버려진다
        System.out.println("반환값 무시한 s : \"" + s + "\"");  // 여전히 공백 있는 원본

        System.out.println();

        // ================================================================
        // 5. concat() - 문자열 연결 (+ 연산자와 결과는 동일)
        // ================================================================
        String hello = "Hello";
        String world = "World";
        String combined = hello.concat(" ").concat(world);  // "Hello" + " " + "World"와 같은 결과

        System.out.println("concat()        : " + combined);

        System.out.println();

        // ================================================================
        // 6. 문자열 자르기 - split()
        // ================================================================
        String csv = "국어,영어,수학";
        String[] subjects = csv.split(",");  // 구분자를 기준으로 배열로 분리

        for (int i = 0; i < subjects.length; i++) {
            System.out.println("subjects[" + i + "] = " + subjects[i]);
        }
    }
}
