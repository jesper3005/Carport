/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import functionLayer.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class ProductMapper {

    private final String ALL_PRODUCTS = "SELECT `*` FROM `product` ORDER BY `category`,`length` ASC;";
    private final String ADD_PRODUCT = "INSERT INTO `product`(`product_name`,`category`,`price`,`length`,`width`,`height`)VALUES(?,?,?,?,?,?);";
    private final String DELETE_PRODUCT = "DELETE FROM `product` WHERE product_id=?;";
    private final String Update_Price = "UPDATE `product` SET `price`=? WHERE product_id=?;";
    private final String ALL_REM_BY_LENGTH = "SELECT `category`,`length` FROM `product` ORDER BY `length`;";
    private final String SEARCH_IN_PRODUCT_TABLE = "SELECT * FROM product WHERE CONCAT(product_name, '', category, '',length,'',width,'',height,'') LIKE ?;";
    private final String GET_PRODUCT_BY_ID = "SELECT * FROM `product` WHERE `product_id` = ?;";

    // private final String Update_PRODUCT = "SELECT `*` FROM `product` WHERE produkt_id=?;";
    public List<Product> allProducts() {
        try {
            List<Product> productList = new ArrayList<>();
            Connection c = Connector.connection();
            String query = ALL_PRODUCTS;
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                int product_id = res.getInt("product_id");
                String product_name = res.getString("product_name");
                String category = res.getString("category");
                double price = res.getDouble("price");
                double length = res.getDouble("length");
                double width = res.getDouble("width");
                double height = res.getDouble("height");
                Product p = new Product(product_id, product_name, category, price, length, width, height);
                productList.add(p);
            }
            return productList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + ProductMapper.class.getName());
        }
        return null;
    }

    public Product addProducts(Product product) {
        try {
            Connection c = Connector.connection();
            String query = ADD_PRODUCT;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setString(1, product.getProductName());
            pstmt.setString(2, product.getCategory());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setDouble(4, product.getLength());
            pstmt.setDouble(5, product.getWidth());
            pstmt.setDouble(6, product.getHeight());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + ProductMapper.class.getName());
        }
        return product;
    }

    public void deleteProduct(int id) {
        try {
            Connection c = Connector.connection();
            String query = DELETE_PRODUCT;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + ProductMapper.class.getName());
        }

    }

    public List<Product> orderByLengthRem() {
        try {
            List<Product> productList = new ArrayList<>();
            Connection c = Connector.connection();
            String query = ALL_REM_BY_LENGTH;
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                String category = res.getString("category");
                double length = res.getDouble("length");
                Product p = new Product(category, length);
                productList.add(p);
            }
            return productList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + ProductMapper.class.getName());
        }
        return null;
    }

    public void updatePrice(int produkt_id, double price) {
        try {
            Connection c = Connector.connection();
            String query = Update_Price;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setDouble(1, price);
            pstmt.setInt(2, produkt_id);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + ProductMapper.class.getName());
        }
    }

    public List<Product> searchInProductTable(String value) {
        value = "%" + value + "%";
        try {
            Product p;
            List<Product> list = new ArrayList<>();
            Connection c = Connector.connection();
            String query = SEARCH_IN_PRODUCT_TABLE;
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1, value);

            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                int product_id = res.getInt("product_id");
                String product_name = res.getString("product_name");
                String category = res.getString("category");
                double price = res.getDouble("price");
                double length = res.getDouble("length");
                double width = res.getDouble("width");
                double height = res.getDouble("height");

                p = new Product(product_id, product_name, category, price, length, width, height);
                list.add(p);
            }

            return list;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + ProductMapper.class.getName());
        }
        return null;
    }

    public Product getProductByID(int id) {

        try {
            Connection c = Connector.connection();
            String query = GET_PRODUCT_BY_ID;
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                int productID = res.getInt("product_id");
                String productName = res.getString("product_name");
                String category = res.getString("category");
                double price = res.getDouble("price");
                double length = res.getDouble("length");
                double width = res.getDouble("width");
                double height = res.getDouble("height");

                Product product = new Product(productID, productName, category, price, width, price, length, width, height);
                return product;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + ProductMapper.class.getName());
        }
        return null;

    }

}
