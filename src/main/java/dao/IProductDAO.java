package dao;

import model.Category;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductDAO {
    ArrayList<Product> getAllProduct();

    ArrayList<Category> getAllCategory();

    Product getProduct(int id);

    boolean createProduct(Product product, int id_category);

    boolean deleteProduct(int id) throws SQLException;

    boolean updateProduct(Product product, int id_category) throws SQLException;
}
