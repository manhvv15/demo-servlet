package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    protected static Connection connection;
    private final static String user = "root";
    private final static String pass = "123";
    private final static String url = "jdbc:mysql://localhost:3306/demo_servlet?useSSL=false&serverTimezone=UTC";

    protected static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("✅ Kết nối thành công từ DBContext!");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("❌ Lỗi kết nối DBContext: " + e.getMessage());
            }
        }
        return connection;
    }

    public DBContext() {
        connection = getConnection();
    }
}
