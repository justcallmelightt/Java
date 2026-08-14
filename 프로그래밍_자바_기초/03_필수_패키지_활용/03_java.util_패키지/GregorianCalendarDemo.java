// GregorianCalendarDemo.java
// 주제: GregorianCalendar - Calendar를 상속받은 구현체, 생성자로 특정 날짜 생성

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarDemo {

    public static void main(String[] args) {

        // ================================================================
        // 1. GregorianCalendar는 new로 직접 생성 가능
        // ================================================================
        // Calendar는 추상 클래스라 new가 안 됐지만,
        // GregorianCalendar는 Calendar를 상속받은 "실제 구현체"라서 new로 만들 수 있다.
        // 생성자에 연, 월, 일, 시, 분, 초를 순서대로 넣으면 그 시점의 객체가 만들어진다.
        // (월은 여기서도 0부터 시작 - 1월은 0)
        GregorianCalendar gcal = new GregorianCalendar(2026, 0, 30, 2, 30, 40);
        // -> 2026년 1월 30일 2시 30분 40초

        // ================================================================
        // 2. get()으로 값 꺼내기 - Calendar와 사용법 동일
        // ================================================================
        int year = gcal.get(Calendar.YEAR);
        int month = gcal.get(Calendar.MONTH) + 1;
        int date = gcal.get(Calendar.DATE);
        int hour = gcal.get(Calendar.HOUR);
        int minute = gcal.get(Calendar.MINUTE);
        int second = gcal.get(Calendar.SECOND);
        int dayOfWeek = gcal.get(Calendar.DAY_OF_WEEK);

        String weekKor = "";
        switch (dayOfWeek) {
            case 1: weekKor = "일"; break;
            case 2: weekKor = "월"; break;
            case 3: weekKor = "화"; break;
            case 4: weekKor = "수"; break;
            case 5: weekKor = "목"; break;
            case 6: weekKor = "금"; break;
            case 7: weekKor = "토"; break;
        }

        System.out.println(year + "년 " + month + "월 " + date + "일(" + weekKor + ") "
                + hour + "시간" + minute + "분" + second + "초");
        // -> 2026년1월30일(금)2시간30분40초

        System.out.println();

        // ================================================================
        // 3. set()으로 이미 만든 객체의 값 바꾸기
        // ================================================================
        // 새로 만들지 않고 기존 객체의 날짜만 통째로 바꿀 수도 있다.
        gcal.set(2026, 7, 2, 15, 0, 0);   // 2026년 8월 2일 15시로 변경

        int newYear = gcal.get(Calendar.YEAR);
        int newMonth = gcal.get(Calendar.MONTH) + 1;
        int newDate = gcal.get(Calendar.DATE);
        int newHour = gcal.get(Calendar.HOUR_OF_DAY);

        System.out.println("변경 후: " + newYear + "년 " + newMonth + "월 " + newDate + "일 " + newHour + "시");

        // 근무 시간(9~18시) 여부만 간단히 판단
        if (newHour >= 9 && newHour < 18) {
            System.out.println("근무 시간입니다.");
        } else {
            System.out.println("근무 시간이 아닙니다.");
        }
    }
}
