import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionExample {
    public static void main(String[] args) {
        String url = "jdbc:example://localhost:0000/sample";

        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("connected = " + connection.isValid(1));
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 설정을 확인하세요.");
        }
    }
}
