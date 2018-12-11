/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import dbAccess.Connector;
import functionLayer.Carport;
import functionLayer.LogicFacade;
import functionLayer.Shed;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesper
 */
public class CarportMapperTest {
    
    private static Connection testConnection;
    private static final String USER = "joerg";
    private static final String USERPW = "joerg/3085";
    private static final String DBNAME = "carportTest";
    private static final String HOST = "142.93.173.199";
    
    @Before
    public void setUp() {
        try {
            // avoid making a new connection for each test
            if (testConnection == null || testConnection.isClosed()) {
                String url = String.format("jdbc:mysql://%s:3306/%s", HOST, DBNAME);
                Class.forName("com.mysql.jdbc.Driver");
                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test 
                Connector.setConnection(testConnection);
            }
            //Reset database
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("DROP TABLE IF EXISTS carport;");
                stmt.execute("CREATE TABLE carport LIKE carportTest;");
                stmt.execute("INSERT into carport SELECT * from carportTest;");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }
    
    @Test
    public void testAddCarport() {
        //Arrange
        Shed shed = new Shed(1 ,200.00, 200.00);
        Carport carport = new Carport(200.00, 200.00, 15, "FLAT", "Tagpap", 5000.00, 1, 1);
        
        //Act
        List<Carport> before = LogicFacade.getALLOrdresFromCarport();
        LogicFacade.addCarport(carport, shed);
        List<Carport> after = LogicFacade.getALLOrdresFromCarport();
        
        //Assert
        assertTrue(before.size() < after.size());
    }
    
    @Test
    public void testAddShed() {
        //Arrange
        Shed shed = new Shed(200.00, 250.00);
        
        //Act
        double expected = 200.00;
        Shed actual = LogicFacade.addShed(shed);
        
        //Assert
        assertEquals(expected, actual.getShed_length(), 0);
    }
    
    @Test
    public void testGetCarportByStatus(){
        //Arrange
        List<Carport> list = LogicFacade.getOrdresFromCarportByEnum("pending");
        Carport car = list.get(0);
        
        //Act
        String expected = "pending";
        String actual = car.getStatus_of_order();
        
        //Assert
        assertEquals(expected, actual);
    }
    
    
    @Test
    public void testGetAllOrders() {
        //Arrange
        List<Carport> list = LogicFacade.getALLOrdresFromCarport();
        
        //Act
        
        //Assert
        assertTrue(list.size() > 2);
    }
    
    @Test
    public void testUpdateOrderStatus() {
        //Arrange
        List<Carport> list = LogicFacade.getOrdresFromCarportByEnum("pending");
        Carport carportPending = list.get(0);
        
        //Act
        LogicFacade.updateOrderStatus("paid", carportPending.getId());
        Carport carportPaid = LogicFacade.getCarportByID(carportPending.getId());
        
        //Assert
        assertTrue(carportPaid.getStatus_of_order().equals("paid"));
    }
    
    @Test
    public void testGetCarportByID() {
        //Arrange
        Carport carport = LogicFacade.getCarportByID(1);
        
        //Act
        
        
        //Assert
        assertNotNull(carport);
    }
    

    
    
}
