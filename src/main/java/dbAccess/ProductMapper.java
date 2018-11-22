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

    private final String ALL_PRODUCTS = "SELECT `*` FROM `product` ORDER BY `category`;";
    private final String ADD_PRODUCT = "INSERT INTO `product`(`produkt_name`,`category`,`price`,`length`,`width`,`height`)VALUES(?,?,?,?,?,?);";
    private final String DELETE_PRODUCT = "DELETE FROM `product` WHERE produkt_id=?;";
    private final String ALL_REM_BY_LENGTH = "SELECT `category`,`length` FROM `product` ORDER BY `length`;";

    public List<Product> allProducts() {
        try {
            List<Product> productList = new ArrayList<>();
            Connection c = Connector.connection();
            String query = ALL_PRODUCTS;
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                int produkt_id = res.getInt("produkt_id");
                String produkt_name = res.getString("produkt_name");
                String category = res.getString("category");
                double price = res.getDouble("price");
                double length = res.getDouble("length");
                double width = res.getDouble("width");
                double height = res.getDouble("height");
                Product p = new Product(produkt_id, produkt_name, category, price, length, width, height);
                productList.add(p);
            }
            return productList;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getStackTrace());
        }
        return null;
    }

    

    public void addProducts(String produkt_name, String category, double price, double length, double width, double height) {
        try {
            Connection c = Connector.connection();
            String query = ADD_PRODUCT;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setString(1, produkt_name);
            pstmt.setString(2, category);
            pstmt.setDouble(3, price);
            pstmt.setDouble(4, length);
            pstmt.setDouble(5, width);
            pstmt.setDouble(6, height);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void deleteProduct(int id) {
        try {
            Connection c = Connector.connection();
            String query = DELETE_PRODUCT;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
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
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getStackTrace());
        }
        return null;
    }

}
