/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import functionLayer.Carport;
import functionLayer.Product;
import functionLayer.Shed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CarportMapper {

    private final String ADD_Carport = "INSERT INTO `carport`(`carport_length`,`carport_width`,`roof`,`roof_material`,`total_price`,`shed_id`,`customer_id`)VALUES(?,?,?,?,?,?,?);";
    private final String ADD_SHED = "INSERT INTO `shed` (shed_length, shed_width) VALUES (?,?)";
    private final String GET_ORDER_BY_STATUS = "SELECT * FROM `carport` WHERE `status_of_order` = ?;";
    
    
    public void addCarport(Carport carport, Shed shed) {
        try {
            Connection c = Connector.connection();
            String query = ADD_Carport;
            PreparedStatement pstmt = c.prepareStatement(query);
            Shed s = addShed(shed);
            
            pstmt.setDouble(1, carport.getCarport_length());
            pstmt.setDouble(2, carport.getCarport_width());
            pstmt.setString(3, carport.getRoof());
            pstmt.setString(4, carport.getRoofMaterial());
            pstmt.setDouble(5, carport.getTotal_price());
            pstmt.setInt(6, s.getShed_id());
            pstmt.setInt(7, carport.getCustomer_id());
            

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage() + " addCarport");
        }
    }

    public Shed addShed(Shed shed) {
        int id = 0;
        try {
            Connection c = Connector.connection();
            String query = ADD_SHED;
            PreparedStatement pstmt = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setDouble(1, shed.getShed_length());
            pstmt.setDouble(2, shed.getShed_width());

            pstmt.executeUpdate();
            ResultSet ids = pstmt.getGeneratedKeys();
            ids.next();
            id = ids.getInt(1);
            shed.setShed_id(id);
            System.out.println(id + "add shed id");
            pstmt.close();
            return shed;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage() + " addShed");
        }
        return null;
    }
    
    public List<Carport> getCarportByStatus(int enumValue) {
            try {
            List<Carport> carportList = new ArrayList<>();
            Connection c = Connector.connection();
            String query = GET_ORDER_BY_STATUS;
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                int carport_id = res.getInt("carport_id");
                String date = res.getString("date");
                String carportLength = res.getString("carport_length");
                double carportWidth = res.getDouble("carport_width");
                double degrees = res.getDouble("degrees");
                String roofType = res.getString("roof");
                String roofMaterial = res.getString("roof_material");
                double totalPrice = res.getDouble("total_price");
                int shedID = res.getInt("shed_id");
                int customerID = res.getInt("customer_id");
                int userId = res.getInt("user_id");
                //Carport carport = new Carport(carport_id, date, carportLength, carportWidth, degrees, roofType, roofMaterial, totalPrice, true, shedID, customerID, userId);
                //Product p = new Product(product_id, product_name, category, price, length, width, height);
                //productList.add(p);
            }
            return carportList;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getStackTrace());
        }
        return null;
    }
    
    
}
