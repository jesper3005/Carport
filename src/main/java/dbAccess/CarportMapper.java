/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import functionLayer.Carport;
import functionLayer.Shed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oerte
 */
public class CarportMapper {

    private final String ADD_Carport = "INSERT INTO `carport`(`carport_length`,`carport_width`,`roof`,`roof_material`,`total_price`,`shed_id`,`customer_id`)VALUES(?,?,?,?,?,?,?);";
    private final String ADD_SHED = "INSERT INTO `shed` (shed_length, shed_width) VALUES (?,?)";

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
}
