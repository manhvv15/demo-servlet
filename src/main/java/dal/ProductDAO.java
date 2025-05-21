package dal;

import model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DAO {


    public Product findProductById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.out.println("findProductById: " + e.getMessage());
        }
        return null;
    }

    public void insert(Product product) {
        String sql = "INSERT INTO product (name, price) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ProductDAO-insert: " + e.getMessage());
        }
    }

    public void update(Product product) {
        String sql = "UPDATE product SET name = ?, price = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ProductDAO-update: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ProductDAO-delete: " + e.getMessage());
        }
    }

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            System.out.println("getAll: " + e.getMessage());
        }
        return list;
    }

}
