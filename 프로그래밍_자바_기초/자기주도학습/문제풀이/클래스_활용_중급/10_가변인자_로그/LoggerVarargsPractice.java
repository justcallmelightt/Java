/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 10번 문제 - 가변 인자 + String.format (LoggerVarargsPractice.java)
 *
 * 문제 조건:
 * 1. 로그 출력 메서드를 가진 Logger 클래스를 작성하시오.
 * 2. - static void log(String level, String format, Object... args)
 * 3. String.format으로 format과 args를 합친 뒤
 * 4. "[레벨] 메시지" 형태로 출력한다.
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 * 3. 가변 인자를 사용해 호출 시 전달되는 인자 수를 유연하게 처리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class Logger {
    static void log(String level, String format, Object... args) {
        String message = String.format(format, args);
        System.out.println("[" + level + "] " + message);
    }
}

public class LoggerVarargsPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        Logger.log("INFO", "서버가 %d 포트에서 시작되었습니다.", 8080);
        Logger.log("WARN", "메모리 사용량이 %d%% 입니다.", 85);
        Logger.log("ERROR", "파일 %s 을(를) 찾을 수 없습니다.", "data.txt");
    }
}
