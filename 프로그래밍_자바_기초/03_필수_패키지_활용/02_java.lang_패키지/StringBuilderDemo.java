// StringBuilderDemo.java
// 주제: StringBuilder - String과 달리 내용을 직접 바꿀 수 있는 문자열

public class StringBuilderDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. String과의 차이 - StringBuilder는 내용을 직접 바꾼다
        // ================================================================
        // String은 불변(immutable)이라 메소드 호출 결과를 새 변수에 담아야 했다.
        // StringBuilder는 가변(mutable)이라 메소드 호출 자체가 원본을 바꾼다.
        StringBuilder sb = new StringBuilder("Happy");

        sb.append(" IT");       // sb 뒤에 " IT" 추가 (반환값을 다시 담을 필요 없음)
        sb.append(" Meister");  // 이어서 " Meister" 추가

        System.out.println("append 결과: " + sb);  // Happy IT Meister
        System.out.println();

        // ================================================================
        // 2. 문자열 삽입 / 부분 교체
        // ================================================================
        sb.insert(5, " Young");             // 인덱스 5 위치에 " Young" 끼워넣기
        System.out.println("insert 결과: " + sb);

        sb.replace(0, 5, "Cool");           // 인덱스 0~4 구간을 "Cool"로 교체
        System.out.println("replace 결과: " + sb);
        System.out.println();

        // ================================================================
        // 3. 문자열 삭제
        // ================================================================
        sb.deleteCharAt(4);                 // 인덱스 4번 문자 하나만 삭제
        System.out.println("deleteCharAt 결과: " + sb);

        sb.delete(4, sb.length());          // 인덱스 4부터 끝까지 삭제
        System.out.println("delete 결과: " + sb);
        System.out.println();

        // ================================================================
        // 4. 뒤집기 / 특정 위치 문자 바꾸기
        // ================================================================
        sb = new StringBuilder("Meister");  // 새로 시작

        System.out.println("reverse 전: " + sb);
        sb.reverse();
        System.out.println("reverse 후: " + sb);

        sb.setCharAt(0, 'R');               // 인덱스 0 문자를 'R'로 변경
        System.out.println("setCharAt 후: " + sb);
        System.out.println();

        // ================================================================
        // 5. 실수하기 쉬운 부분 - String으로 변환
        // ================================================================
        // sb는 StringBuilder 타입이라, String이 필요한 곳(예: 다른 메소드의 매개변수)에는
        // toString()으로 명시적으로 바꿔줘야 하는 경우가 있다.
        String result = sb.toString();
        System.out.println("toString() 결과 타입 확인용: " + result);
    }
}
