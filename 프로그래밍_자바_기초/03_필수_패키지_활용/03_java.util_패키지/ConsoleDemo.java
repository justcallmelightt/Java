// ConsoleDemo.java
// 주제: Console 클래스 - readLine()/readPassword(), 입력 내용을 화면에 감추기
//
// ⚠ 주의: 이 예제는 인텔리J의 Run 버튼(내장 콘솔)으로 실행하면 동작하지 않는다.
// System.console()은 IDE 내장 콘솔에서는 null을 반환하기 때문에,
// console.readLine()을 호출하는 순간 NullPointerException이 발생한다.
// 반드시 프로젝트를 빌드한 뒤, 직접 명령 프롬프트(cmd)를 열어서
// class 파일이 있는 폴더로 이동해 "java 클래스이름" 형태로 실행해야 한다.

import java.io.Console;

public class ConsoleDemo {

    public static void main(String[] args) {

        // ================================================================
        // 1. Console 객체 생성
        // ================================================================
        // Scanner와 달리 new로 만드는 게 아니라, System의 static 메소드인
        // console()을 호출해서 얻어온다.
        Console console = System.console();

        // IDE에서 실행했는지 확인하는 안전장치
        // (console이 null이면 이후 코드에서 전부 NullPointerException이 나므로
        //  여기서 먼저 안내하고 프로그램을 종료시킨다)
        if (console == null) {
            System.out.println("Console을 사용할 수 없습니다. cmd(명령 프롬프트)에서 직접 실행해주세요.");
            return;
        }

        // ================================================================
        // 2. 아이디 입력 - readLine()
        // ================================================================
        System.out.print("아이디: ");
        String id = console.readLine();

        // ================================================================
        // 3. 비밀번호 입력 - readPassword()
        // ================================================================
        // 입력한 문자가 화면에 그대로 보이지 않는다(비밀번호 입력창처럼).
        // 반환 타입이 String이 아니라 char[](문자 배열)인 이유:
        // String은 메모리에 오래 남아있을 수 있어서 보안상 좋지 않은데,
        // char[]는 다 쓰고 나서 직접 값을 지울 수 있어 더 안전하기 때문이다.
        System.out.print("패스워드: ");
        char[] charPass = console.readPassword();
        String pwd = new String(charPass);   // 화면 출력을 위해서만 String으로 변환

        System.out.println("--------------------");
        System.out.println("아이디: " + id);
        System.out.println("패스워드: " + pwd);
    }
}
