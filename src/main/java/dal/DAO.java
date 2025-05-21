package dal;

import java.sql.Connection;

public class DAO extends DBContext {
    protected Connection connection = DBContext.getConnection();
    public static ProductDAO productDAO = new ProductDAO();
}
