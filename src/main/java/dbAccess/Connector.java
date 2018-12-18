/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oerte
 */
public class Connector {
    private static final String URL = "jdbc:mysql://142.93.173.199:3306/carport";
    private static final String USERNAME = "joerg";
    private static final String PASSWORD = "joerg/3085";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws SQLException {
        if (singleton == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
            singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        return singleton;

    }
    

}
