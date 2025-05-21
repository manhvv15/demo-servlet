package controller;

import dal.ProductDAO;
import model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "create":
                req.getRequestDispatcher("/product/create.jsp").forward(req, resp);
                break;
            case "edit":
                int editId = Integer.parseInt(req.getParameter("id"));
                Product editProduct = productDAO.findProductById(editId);
                req.setAttribute("product", editProduct);
                req.getRequestDispatcher("/product/edit.jsp").forward(req, resp);
                break;
            case "delete":
                int deleteId = Integer.parseInt(req.getParameter("id"));
                productDAO.delete(deleteId);
                resp.sendRedirect("products"); // redirect to avoid resubmit
                break;
            default:
                List<Product> products = productDAO.getAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "create":
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                productDAO.insert(new Product(0, name, price));
                resp.sendRedirect("products");
                break;

            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                String updatedName = req.getParameter("name");
                double updatedPrice = Double.parseDouble(req.getParameter("price"));
                productDAO.update(new Product(id, updatedName, updatedPrice));
                resp.sendRedirect("products");
                break;

            default:
                resp.sendRedirect("products");
        }
    }
}
