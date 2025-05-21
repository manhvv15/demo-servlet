package dal;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = DBContext.getConnection();

        if (conn != null) {
            System.out.println("✅ Đã kết nối thành công tới database!");
        } else {
            System.out.println("❌ Kết nối thất bại.");
        }
    }
}
