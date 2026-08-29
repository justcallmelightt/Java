// CalendarDemo.java
// 주제: Calendar 클래스 - 날짜/시간 필드 조회와 비교

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {

        // ================================================================
        // 1. Calendar 객체 생성 - new가 아니라 getInstance()로 만든다
        // ================================================================
        // Calendar는 추상 클래스라서 new Calendar()로 직접 객체를 못 만든다.
        // 대신 getInstance()라는 static 메소드를 호출하면
        // 현재 날짜/시간 정보가 담긴 객체를 대신 만들어서 돌려준다.
        // (왜 직접 못 만드는지는 지금 몰라도 되고, "이렇게 쓴다"만 알면 된다)
        Calendar cal = Calendar.getInstance();

        System.out.println();

        // ================================================================
        // 2. get() 메소드로 각 필드 값 꺼내기
        // ================================================================
        // Calendar.YEAR, Calendar.MONTH 같은 것들은 "어떤 필드를 꺼낼지"를
        // 지정하는 상수다. get(필드상수)로 원하는 값만 뽑아온다.
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;      // MONTH는 0부터 시작(1월=0)이라 항상 +1
        int date = cal.get(Calendar.DATE);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1(일요일) ~ 7(토요일)
        int hour24 = cal.get(Calendar.HOUR_OF_DAY);     // 24시간제
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        System.out.println("오늘 날짜: " + year + "년 " + month + "월 " + date + "일");
        System.out.println("현재 시각: " + hour24 + "시 " + minute + "분 " + second + "초");

        System.out.println();

        // ================================================================
        // 3. dayOfWeek 값으로 요일 문자열 만들기
        // ================================================================
        // Calendar.SUNDAY, Calendar.MONDAY 같은 상수는 각각 1, 2, ... 7과 같은 값이라
        // dayOfWeek 값과 바로 switch로 비교할 수 있다.
        String weekKor = "";
        switch (dayOfWeek) {
            case Calendar.SUNDAY:    weekKor = "일요일"; break;
            case Calendar.MONDAY:    weekKor = "월요일"; break;
            case Calendar.TUESDAY:   weekKor = "화요일"; break;
            case Calendar.WEDNESDAY: weekKor = "수요일"; break;
            case Calendar.THURSDAY:  weekKor = "목요일"; break;
            case Calendar.FRIDAY:    weekKor = "금요일"; break;
            case Calendar.SATURDAY:  weekKor = "토요일"; break;
        }
        System.out.println("오늘은 " + weekKor);

        System.out.println();

        // ================================================================
        // 4. 이번 달의 마지막 날 확인
        // ================================================================
        // 달마다 마지막 날짜가 다른데(28~31일), 직접 계산할 필요 없이
        // getActualMaximum()에 DATE 필드를 넘기면 알아서 계산해준다.
        int lastDate = cal.getActualMaximum(Calendar.DATE);
        System.out.println("이번 달의 마지막 날: " + lastDate + "일");

        System.out.println();

        // ================================================================
        // 5. 날짜 비교 - after(), before(), equals()
        // ================================================================
        // set()으로 임의의 날짜를 만들어서 오늘과 비교해본다.
        // set(연, 월, 일)에서도 월은 0부터 시작하므로 12월은 11로 써야 한다.
        Calendar target = Calendar.getInstance();
        target.set(2026, 11, 25);   // 2026년 12월 25일

        System.out.println("target이 오늘보다 이후인가 : " + target.after(cal));
        System.out.println("target이 오늘보다 이전인가 : " + target.before(cal));
        System.out.println("target이 오늘과 같은 날짜인가: " + target.equals(cal));
    }
}
