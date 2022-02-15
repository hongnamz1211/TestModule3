package controller;

import dao.ProductDAO;
import model.Category;
import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private static final ProductDAO productDAO = new ProductDAO();
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "createGet":
                    createGet(request, response);
                    break;
                case "createPost":
                    createPost(request, response);
                    break;
                case "editGet":
                    editGet(request, response);
                    break;
                case "editPost":
                    editPost(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
                case "searchProduct":
                    searchProduct(request, response);
                default:
                    displayAllProduct(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("searchProductName");
        request.setAttribute("tim", search);
        ArrayList<Product> products = (ArrayList<Product>) productDAO.searchProduct(search);
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }


    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id_product = Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id_product);
        displayAllProduct(request, response);
    }

    private void editPost(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id_product = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(id_product, name, price, quantity, color, description);
        productService.editProduct(product, id_category);
        productService.getCategories();
        ArrayList<Product> products = productService.getProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void editGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_product = Integer.parseInt(request.getParameter("id"));
        Product productEdit = productService.getProduct(id_product);
        ArrayList<Category> categories = productService.getCategories();
        int id_category = -1;
        for (Category category : categories) {
            if (category.getName_category().equals(productEdit.getCategory())) {
                id_category = category.getId_category();
            }
        }
        request.setAttribute("id_category", id_category);
        request.setAttribute("productEdit", productEdit);
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit_product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        int id_category = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name, price, quantity, color, description);
        productService.createProduct(product, id_category);
        ArrayList<Product> products = productService.getProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> categories = productService.getCategories();
        request.setAttribute("categories", categories);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create_product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void displayAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.getProducts();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request, response);
    }
}
