/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import functionLayer.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oerte
 */
public class CustomerMapper {

    private final String ALL_INFO_FROM_CUSTOMER_BY_EMAIL = "SELECT `*` FROM `customer` WHERE `email`= ?;";
    private final String ADD_CUSTOMER = "INSERT INTO `customer`(`first_name`,`last_name`,`email`,`street_address`,`town`,`zip_code`,`telephone_number`,`comments`)VALUES(?,?,?,?,?,?,?,?);";

    public Customer allInfoFromCustomer(String email) {
        try {
            Customer customer = null;
            Connection c = Connector.connection();
            String query = ALL_INFO_FROM_CUSTOMER_BY_EMAIL;
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                String first_name = res.getString("first_name");
                String last_name = res.getString("last_name");
                String email_ = res.getString("email");
                String street_address = res.getString("street_address");
                String town = res.getString("town");
                String zip_code = res.getString("zip_code");
                String telephone_number = res.getString("telephone_number");
                String comments = res.getString("comments");
                customer = new Customer(first_name, last_name, email_, street_address, town, zip_code, telephone_number, comments);
            }
            return customer;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage()+" allInfonCustomer");
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        try {
            Connection c = Connector.connection();
            String query = ADD_CUSTOMER;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getAddress());
            pstmt.setString(5, customer.getTown());
            pstmt.setString(6, customer.getZipCode());
            pstmt.setString(7, customer.getPhone());
            pstmt.setString(8, customer.getComments());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage() +" addCustomer");
        }
    }

}