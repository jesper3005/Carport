/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import functionLayer.Produkt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author oerte
 */
public class ProduktMapper {

    private final String ALL_PRODUKTS = "SELECT `*` FROM `product` ORDER BY `category`;";

    public ArrayList<Produkt> produkts() {
        try {
            ArrayList<Produkt> produktList = new ArrayList<>();
            Connection c = Connector.connection();
            String query = ALL_PRODUKTS;
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
                Produkt p = new Produkt(produkt_id, produkt_name, category, price, length, width, height);
                produktList.add(p);
            }
            return produktList;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getStackTrace());
        }
        return null;
    }

}
