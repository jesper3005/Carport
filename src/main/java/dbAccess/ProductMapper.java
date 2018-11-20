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

/**
 *
 * @author oerte
 */
public class ProductMapper {

    private final String ALL_PRODUKTS = "SELECT `*` FROM `product` ORDER BY `length`;";

    public ArrayList<Product> products() {
        try {
            ArrayList<Product> productList = new ArrayList<>();
            Connection c = Connector.connection();
            String query = ALL_PRODUKTS;
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                int produkt_id = res.getInt("produkt_id");
                String produkt_name = res.getString("produkt_name");
                String category = res.getString("category");
                double price = res.getDouble("price");
                int length = res.getInt("length");
                int width = res.getInt("width");
                int height = res.getInt("height");
                Product p = new Product(produkt_id, produkt_name, category, price, length, width, height);
                productList.add(p);
            }
            return productList;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getStackTrace());
        }
        return null;
    }

}
