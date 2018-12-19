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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CarportMapper {

    private final String ADD_Carport = "INSERT INTO `carport`(`carport_length`,`carport_width`,`degrees`,`roof`,`roof_material`,`total_price`,`shed_id`,`customer_id`)VALUES(?,?,?,?,?,?,?,?);";
    private final String ADD_SHED = "INSERT INTO `shed` (shed_length, shed_width) VALUES (?,?)";
    private final String GET_ORDER_BY_STATUS = "SELECT * FROM `carport` WHERE `status_of_order` = ?;";
    private final String GET_ALL_ORDERS = "SELECT * FROM `carport`;";
    private final String GET_SHED_BY_ID = "SELECT * FROM `shed` WHERE `shed_id` = ?;";
    private final String UPDATE_ORDER_STATUS = "UPDATE `carport` SET `status_of_order` = ? WHERE `carport_id` = ?;";
    private final String GET_CARPORT_BY_ID = "SELECT * FROM `carport` WHERE `carport_id` = ?;";

    public void addCarport(Carport carport, Shed shed) {
        try {
            Connection c = Connector.connection();
            String query = ADD_Carport;
            PreparedStatement pstmt = c.prepareStatement(query);
            Shed s = addShed(shed);

            pstmt.setDouble(1, carport.getCarport_length());
            pstmt.setDouble(2, carport.getCarport_width());
            pstmt.setDouble(3, carport.getDegrees());
            pstmt.setString(4, carport.getRoof());
            pstmt.setString(5, carport.getRoofMaterial());
            pstmt.setDouble(6, carport.getTotal_price());
            pstmt.setInt(7, s.getShed_id());
            pstmt.setInt(8, carport.getCustomer_id());
            System.out.println(carport.toString());

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CarportMapper.class.getName());
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
            pstmt.close();
            return shed;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CarportMapper.class.getName());
        }
        return null;
    }

    public Shed getShedById(int shed_id) {
        try {
            Connection c = Connector.connection();
            String query = GET_SHED_BY_ID;
            PreparedStatement pstmt = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, shed_id);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                double shedLength = res.getDouble("shed_length");
                double shedWidth = res.getDouble("shed_width");
                Shed shed = new Shed(shedLength, shedWidth);
                return shed;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CarportMapper.class.getName());
        }
        return null;
    }

    public List<Carport> getCarportByStatus(String enumValue) {
        try {
            List<Carport> carportList = new ArrayList<>();
            Connection c = Connector.connection();
            String query = GET_ORDER_BY_STATUS;
            PreparedStatement pstmt = c.prepareStatement(query);
            pstmt.setString(1, enumValue);
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                int carport_id = res.getInt("carport_id");
                Date date = res.getDate("date");
                double carportLength = res.getDouble("carport_length");
                double carportWidth = res.getDouble("carport_width");
                double degrees = res.getDouble("degrees");
                String roofType = res.getString("roof");
                String roofMaterial = res.getString("roof_material");
                double totalPrice = res.getDouble("total_price");
                String orderStatus = res.getString("status_of_order");
                int shedID = res.getInt("shed_id");
                Shed shed = getShedById(shedID);
                int customerID = res.getInt("customer_id");
                int userID = res.getInt("user_id");
                Carport carport = new Carport(carport_id, date, carportLength, carportWidth, degrees, roofType, roofMaterial, totalPrice, orderStatus, shedID, customerID, shed);
                carportList.add(carport);
            }
            return carportList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CarportMapper.class.getName());
        }
        return null;
    }

    public List<Carport> getAllCarportOrders() {
        try {
            List<Carport> carportList = new ArrayList<>();
            Connection c = Connector.connection();
            String query = GET_ALL_ORDERS;
            PreparedStatement pstmt = c.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();
            while (res.next()) {
                int carport_id = res.getInt("carport_id");
                Date date = res.getDate("date");
                double carportLength = res.getDouble("carport_length");
                double carportWidth = res.getDouble("carport_width");
                double degrees = res.getDouble("degrees");
                String roofType = res.getString("roof");
                String roofMaterial = res.getString("roof_material");
                double totalPrice = res.getDouble("total_price");
                String orderStatus = res.getString("status_of_order");
                int shedID = res.getInt("shed_id");
                Shed shed = getShedById(shedID);
                int customerID = res.getInt("customer_id");
                int userID = res.getInt("user_id");
                Carport carport = new Carport(carport_id, date, carportLength, carportWidth, degrees, roofType, roofMaterial, totalPrice, orderStatus, shedID, customerID, shed);
                carportList.add(carport);
            }
            return carportList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CarportMapper.class.getName());
        }
        return null;
    }

    public void updateOrderStatus(String status, int id) {
        try {
            Connection c = Connector.connection();
            String query = UPDATE_ORDER_STATUS;
            PreparedStatement pstmt = c.prepareStatement(query);

            pstmt.setString(1, status);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CarportMapper.class.getName());
        }

    }

    public Carport getCarportById(int id) {
        try {
            Connection c = Connector.connection();
            String query = GET_CARPORT_BY_ID;
            PreparedStatement pstmt = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                int carport_id = res.getInt("carport_id");
                Date date = res.getDate("date");
                double carportLength = res.getDouble("carport_length");
                double carportWidth = res.getDouble("carport_width");
                double degrees = res.getDouble("degrees");
                String roofType = res.getString("roof");
                String roofMaterial = res.getString("roof_material");
                double totalPrice = res.getDouble("total_price");
                String orderStatus = res.getString("status_of_order");
                int shedID = res.getInt("shed_id");
                Shed shed = getShedById(shedID);
                int customerID = res.getInt("customer_id");
                int userID = res.getInt("user_id");
                Carport carport = new Carport(carport_id, date, carportLength, carportWidth, degrees, roofType, roofMaterial, totalPrice, orderStatus, shedID, customerID, shed);
                return carport;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " " + CarportMapper.class.getName());
        }
        return null;
    }

}
