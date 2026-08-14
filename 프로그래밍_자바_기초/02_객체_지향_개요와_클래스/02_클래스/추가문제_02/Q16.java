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

public class Q16 {
    public static void main(String[] args) {
        AppConfig c1 = AppConfig.getInstance();
        AppConfig c2 = AppConfig.getInstance();
        c1.setServerUrl("https://api.example.com");
        System.out.println(c2.getServerUrl());
        System.out.println(c1 == c2);
    }
}
