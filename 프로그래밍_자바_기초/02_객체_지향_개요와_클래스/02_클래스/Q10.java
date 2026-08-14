class Logger {
    static void log(String level, String format, Object... args) {
        String message = String.format(format, args);
        System.out.println("[" + level + "] " + message);
    }
}

public class Q10 {
    public static void main(String[] args) {
        Logger.log("INFO", "서버가 %d 포트에서 시작되었습니다.", 8080);
        Logger.log("WARN", "메모리 사용량이 %d%% 입니다.", 85);
        Logger.log("ERROR", "파일 %s 을(를) 찾을 수 없습니다.", "data.txt");
    }
}
