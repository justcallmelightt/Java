/**
 * [프로그래밍 자바 기초] - 자기주도학습
 *
 * 문제명: 16번 문제 - 싱글턴 패턴 (어려움) (SingletonConfigPractice.java)
 *
 * 문제 조건:
 * 1. 싱글턴(Singleton) 패턴을 구현하시오.
 * 2. AppConfig 클래스는 프로그램 전체에서 인스턴스가 단 하나만 존재해야 한다.
 * 3. 조건:
 * 4. - private static AppConfig instance = null
 * 5. - private 생성자 (외부에서 new 불가)
 * 6. - static AppConfig getInstance() :
 * 7. instance가 null이면 새로 생성, 아니면 기존 것을 반환
 * 8. - private String serverUrl 필드
 * 9. - getServerUrl() / setServerUrl() 작성
 * 10. 아래 main을 실행했을 때 출력 결과를 예측하고 코드를 완성하시오.
 * 11. AppConfig c1 = AppConfig.getInstance();
 * 12. AppConfig c2 = AppConfig.getInstance();
 * 13. c1.setServerUrl("https://api.example.com");
 * 14. System.out.println(c2.getServerUrl());
 * 15. System.out.println(c1 == c2);
 *
 * 학습 목표:
 * 1. 클래스의 필드와 메서드를 역할에 맞게 나누고 객체를 생성해 사용한다.
 * 2. 생성자와 this를 이용해 객체의 초기 상태를 올바르게 설정한다.
 * 3. 인스턴스 멤버와 클래스(static) 멤버의 차이를 이해한다.
 * 4. 접근 제어와 getter/setter로 객체의 상태를 안전하게 관리한다.
 *
 * 풀이 흐름:
 * 1. 필요한 상태를 필드로 선언하고 생성자 또는 메서드로 값을 설정한다.
 * 2. 문제에 제시된 정상 조건과 예외 조건을 메서드 안에서 처리한다.
 * 3. main()에서 예제 객체를 생성하고 결과를 출력해 동작을 확인한다.
 */

class AppConfig {
    private static AppConfig instance = null;
    private String serverUrl;

    private AppConfig() {}

    static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    String getServerUrl() { return serverUrl; }
    void setServerUrl(String serverUrl) { this.serverUrl = serverUrl; }
}

public class SingletonConfigPractice {
    // 예제 입력과 호출 순서를 따라가며 각 조건의 처리 결과를 확인한다.
    public static void main(String[] args) {
        AppConfig c1 = AppConfig.getInstance();
        AppConfig c2 = AppConfig.getInstance();
        c1.setServerUrl("https://api.example.com");
        System.out.println(c2.getServerUrl());
        System.out.println(c1 == c2);
    }
}
