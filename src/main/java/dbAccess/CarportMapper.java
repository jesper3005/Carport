/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import functionLayer.Carport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author oerte
 */
public class CarportMapper {
    
        private final String ADD_Carport = "INSERT INTO `carport`(`carport_length`,`carport_width`,`roof_material_id`,`total_price`,`customer_id`)VALUES(?,?,?,?,?);";

    
        
        public void addCarport(Carport carport) {
        try {
            Connection c = Connector.connection();
            String query = ADD_Carport;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setDouble(1, carport.getCarport_length());
            pstmt.setDouble(2, carport.getCarport_width());
            pstmt.setInt(3, carport.getRoof_id());
            pstmt.setDouble(4, carport.getTotal_price());
            pstmt.setInt(5, carport.getCustomer_id());
            

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage() + " addCarport");
        }
    }
}
