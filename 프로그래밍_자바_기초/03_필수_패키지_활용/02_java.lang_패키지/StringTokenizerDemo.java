// StringTokenizerDemo.java
// 주제: StringTokenizer - 구분자(delimiter) 기준으로 문자열 쪼개기

import java.util.StringTokenizer;

public class StringTokenizerDemo {

    public static void main(String[] args) {

        // ================================================================
        // 1. 기본 사용 - 공백/줄바꿈 등을 기준으로 자동 분리
        // ================================================================
        // 구분자를 지정하지 않으면 공백, 탭, 줄바꿈 등을 기준으로 나눈다.
        StringTokenizer basic = new StringTokenizer("Happy Meister IT");

        while (basic.hasMoreTokens()) {         // 다음 토큰이 남아있는지 확인
            System.out.print(basic.nextToken() + " ");  // 토큰을 꺼내면서 다음 위치로 이동
        }
        System.out.println();

        System.out.println();

        // ================================================================
        // 2. 구분자를 직접 지정하기
        // ================================================================
        StringTokenizer withDelim = new StringTokenizer("Happy&Meister&IT&AI", "&");

        int count = withDelim.countTokens();    // 토큰 개수 미리 확인 가능
        System.out.println("토큰 개수: " + count);

        while (withDelim.hasMoreTokens()) {
            System.out.println(withDelim.nextToken());
        }

        System.out.println();

        // ================================================================
        // 3. 실전 예시 - 학생 정보 파싱
        // ================================================================
        // "학번&이름&국어점수&영어점수" 형태의 문자열을 실제 데이터처럼 분리해서 활용
        StringTokenizer student = new StringTokenizer("3108&나소정&88&97", "&");

        String hakbun = student.nextToken();
        String name = student.nextToken();
        int kor = Integer.parseInt(student.nextToken());  // 문자열 -> 정수 변환 필요
        int eng = Integer.parseInt(student.nextToken());

        System.out.println("학번:" + hakbun + " 이름:" + name);
        System.out.println("국어:" + kor + " 영어:" + eng);
        System.out.println("총점:" + (kor + eng) + " 평균:" + (kor + eng) / 2);
    }
}
