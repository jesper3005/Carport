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
import java.sql.Statement;

/**
 *
 * @author oerte
 */
public class CustomerMapper {

    private final String GET_CUSTOMER_BY_EMAIL = "SELECT `*` FROM `customer` WHERE `email`= ?;";
    private final String ADD_CUSTOMER = "INSERT INTO `customer`(`first_name`,`last_name`,`email`,`street_address`,`town`,`zip_code`,`telephone_number`,`comments`)VALUES(?,?,?,?,?,?,?,?);";
    private final String ADD_CUSTOMER_AND_USER = "INSERT INTO `customer`(`first_name`,`last_name`,`email`,`street_address`,`town`,`zip_code`,`telephone_number`)VALUES(?,?,?,?,?,?,?);";
    private final String GET_CUSTOMER_BY_ID = "SELECT `*` FROM `customer` WHERE `customer_id`= ?;";

    public Customer getCustomerByEmail(String email) {
        try {
            Customer customer;
            Connection c = Connector.connection();
            String query = GET_CUSTOMER_BY_EMAIL;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setString(1, email);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                int customer_id = res.getInt("customer_id");
                String first_name = res.getString("first_name");
                String last_name = res.getString("last_name");
                String email_ = res.getString("email");
                String street_address = res.getString("street_address");
                String town = res.getString("town");
                String zipCode = res.getString("zip_code");
                String tel = res.getString("telephone_number");
                String comments = res.getString("comments");
                customer = new Customer(customer_id, first_name, last_name, email_, street_address, town, zipCode, tel, comments);
                return customer;

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CustomerMapper.class.getName());
        }
        return null;
    }

    public Customer addCustomer(Customer customer) {
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
            return customer;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CustomerMapper.class.getName());
        }
        return null;
    }

    public int addCustomerAndUser(Customer customer) {
        int id = 0;
        try {
            Connection c = Connector.connection();
            String query = ADD_CUSTOMER_AND_USER;
            PreparedStatement pstmt = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, customer.getFirstName());
            pstmt.setString(2, customer.getLastName());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getAddress());
            pstmt.setString(5, customer.getTown());
            pstmt.setString(6, customer.getZipCode());
            pstmt.setString(7, customer.getPhone());

            pstmt.executeUpdate();
            ResultSet ids = pstmt.getGeneratedKeys();
            ids.next();
            id = ids.getInt(1);
            pstmt.close();
            return id;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CustomerMapper.class.getName());
        }
        return 0;
    }

    public Customer getCustomerByID(int id) {
        try {
            Customer customer;
            Connection c = Connector.connection();
            String query = GET_CUSTOMER_BY_ID;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                int customer_id = res.getInt("customer_id");
                String first_name = res.getString("first_name");
                String last_name = res.getString("last_name");
                String email_ = res.getString("email");
                String street_address = res.getString("street_address");
                String town = res.getString("town");
                String zipCode = res.getString("zip_code");
                String tel = res.getString("telephone_number");
                String comments = res.getString("comments");
                customer = new Customer(customer_id, first_name, last_name, email_, street_address, town, zipCode, tel, comments);
                return customer;

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CustomerMapper.class.getName());
        }
        return null;
    }

}
