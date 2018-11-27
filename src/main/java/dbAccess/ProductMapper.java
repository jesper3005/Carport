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
    private final String ADD_PRODUCT = "INSERT INTO `product`(`product_name`,`category`,`price`,`length`,`width`,`height`)VALUES(?,?,?,?,?,?);";
    private final String DELETE_PRODUCT = "DELETE FROM `product` WHERE product_id=?;";
    private final String Update_Price = "UPDATE `product` SET `price`=? WHERE product_id=?;";
    private final String ALL_REM_BY_LENGTH = "SELECT `category`,`length` FROM `product` ORDER BY `length`;";
    private final String SEARCH_IN_Product_TABLE = "SELECT * FROM product WHERE CONCAT(product_name, '', category, '',length,'',width,'',height,'') LIKE ?;";
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
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getStackTrace());
        }
        return null;
    }

    public void addProducts(String product_name, String category, double price, double length, double width, double height) {
        try {
            Connection c = Connector.connection();
            String query = ADD_PRODUCT;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setString(1, product_name);
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

    public void updatePrice(int produkt_id, double price) {
        try {
            Connection c = Connector.connection();
            String query = Update_Price;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setDouble(1, price);
            pstmt.setInt(2, produkt_id);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Product> searchInProductTable(String value) {
        System.out.println(SEARCH_IN_Product_TABLE);
        List<Product> list = new ArrayList<>();
        try {
            Product p = null;
            Connection c = Connector.connection();
            String query = SEARCH_IN_Product_TABLE;
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

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

}
// public static List<Product> updateProduct(List<Integer> produkt_id) {
//        String Update_PRODUCT = "SELECT `*` FROM `product` WHERE produkt_id=?;";
//        List<Product> list = new ArrayList<>();
//        try {
//            Product p = null;
//            Connection c = Connector.connection();
//            String query = Update_PRODUCT;
//            PreparedStatement pstmt = c.prepareStatement(query);
//            
//            for (int i = 0; i < produkt_id.size(); i++) {
//            pstmt.setInt(1, produkt_id.get(i));
//            ResultSet res = pstmt.executeQuery();
//
//            while (res.next()) {
//                String produkt_name = res.getString("produkt_name");
//                String category = res.getString("category");
//                double price = res.getDouble("price");
//                double length = res.getDouble("length");
//                double width = res.getDouble("width");
//                double height = res.getDouble("height");
//                p = new Product(produkt_id.get(i), produkt_name, category, price, length, width, height);
//                list.add(p);
//            }
//            }
//            return list;
//
//        } catch (SQLException | ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return null;
//
//    }

