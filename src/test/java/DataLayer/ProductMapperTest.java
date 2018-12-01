/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import functionLayer.Product;
import dbAccess.Connector;
import dbAccess.ProductMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jesper
 */
public class ProductMapperTest {
<<<<<<< HEAD
//    

=======
    
>>>>>>> 3b2443ebfb380514d933e36ef26d2ce45f9babf0
    private static Connection testConnection;
    private static final String USER = "joerg";
    private static final String USERPW = "joerg/3085";
    private static final String DBNAME = "carportTest";
    private static final String HOST = "142.93.173.199";
<<<<<<< HEAD

=======
    
>>>>>>> 3b2443ebfb380514d933e36ef26d2ce45f9babf0
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
<<<<<<< HEAD
            }
            //Reset database
            try (Statement stmt = testConnection.createStatement()) {
=======
            }            
            //Reset database
            try(Statement stmt = testConnection.createStatement()) {
>>>>>>> 3b2443ebfb380514d933e36ef26d2ce45f9babf0
                stmt.execute("DROP TABLE IF EXISTS product;");
                stmt.execute("CREATE TABLE product LIKE productTest;");
                stmt.execute("INSERT into product SELECT * from productTest;");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

<<<<<<< HEAD
=======

>>>>>>> 3b2443ebfb380514d933e36ef26d2ce45f9babf0
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
<<<<<<< HEAD
=======
    
>>>>>>> 3b2443ebfb380514d933e36ef26d2ce45f9babf0
    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }
<<<<<<< HEAD

=======
    
>>>>>>> 3b2443ebfb380514d933e36ef26d2ce45f9babf0
    @Test
    public void testGetAllProducts() {
        //Arrange
        ProductMapper pm = new ProductMapper();
<<<<<<< HEAD

        List<Product> product = pm.allProducts();

        //Assert
        assertTrue(product.size() > 2);
    }

//    @Test
//    public void testUpdatePrice() {
//        //Arrange
//        ProductMapper pm = new ProductMapper();
//        //Act
//        double actual = 200.00;
//        pm.updatePrice(1, actual);
//
//        Product expected = pm.getProductByID(1);
//
//        //Assert
//        assertEquals(expected.getPrice(), actual, 0.5);
//    }

    @Test
    public void testAddProduct() {
        //Arrange
        ProductMapper pm = new ProductMapper();
        Product p = new Product("testProduct", "testCategory", 200.0, 200.0, 200.0, 200.0);

        //Act
        String expected = "testProduct";
        Product actual = pm.addProducts(p);

        //Assert
        assertEquals(expected, actual.getProductName());
    }

<<<<<<< HEAD
    @Test
    public void testDeleteProduct() {
        //Arrange
        ProductMapper pm = new ProductMapper();
        List<Product> product1 = pm.allProducts();

        //Act
        pm.deleteProduct(1);
        List<Product> product2 = pm.allProducts();

        //Assert
        assertTrue(product1.size() > product2.size());
    }
=======
        
        
        List<Product> product = pm.allProducts();
        
        //Assert
        assertTrue(product.size() > 2);
    }
   
//    @Test
//    public void testUpdatePrice() {
//        //Arrange
//        ProductMapper pm = new ProductMapper();
//        //Act
//        double actual = 200.00;
//        pm.updatePrice(1, actual);
//        
//        Product expected = pm.getProductByID(1);
//        
//        //Assert
//        System.out.println(expected.getPrice());
//        assertEquals(expected.getPrice(), actual, 0);
//    }
//    
//    @Test
//    public void testAddProduct() {
//        //Arrange
//        ProductMapper pm = new ProductMapper();
//        Product p = new Product("testProduct", "testCategory", 200.0, 200.0, 200.0, 200.0);
//        
//        //Act
//        String expected = "testProduct";
//        Product actual = pm.addProducts(p);
//        
//        //Assert
//        assertEquals(expected, actual.getProductName());
//    }
//    
=======
>>>>>>> 7ee5a4fa24f54b3d662a86ccc7b1cdf813452ba3
//    @Test
//    public void testDeleteProduct() {
//        //Arrange
//        ProductMapper pm = new ProductMapper();
//        List<Product> product1 = pm.allProducts();
<<<<<<< HEAD
//        
//        //Act
//        pm.deleteProduct(1);
//        List<Product> product2 = pm.allProducts();
//        
//        //Assert
//        assertTrue(product1.size() > product2.size());        
//}
>>>>>>> 3b2443ebfb380514d933e36ef26d2ce45f9babf0
=======
//
//        //Act
//        pm.deleteProduct(1);
//        List<Product> product2 = pm.allProducts();
//
//        //Assert
//        assertTrue(product1.size() > product2.size());
//    }
>>>>>>> 7ee5a4fa24f54b3d662a86ccc7b1cdf813452ba3

}
