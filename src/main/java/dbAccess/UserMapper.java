/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import functionLayer.Customer;
import functionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jesper
 */
public class UserMapper {
    
    private final String GET_USER = "SELECT * FROM `user` WHERE email = ? AND password = ?;";
    
    
    public User getUser(String email, String password) {
        try {
            Connection con = Connector.connection();
            String SQL = GET_USER;
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                int id = rs.getInt( "user_id" );
                String password1 = rs.getString("password");
                String email1 = rs.getString("email");
                String role = rs.getString("role");
                int customerID = rs.getInt("customer_id");
                User u = new User(id, password1, email1, role, customerID);
                return u;
            } 
        } catch ( ClassNotFoundException | SQLException ex ) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
