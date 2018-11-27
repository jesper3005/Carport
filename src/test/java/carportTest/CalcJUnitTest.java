
package carportTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import calculations.CalcLaegter;
import calculations.CalcRem;
import calculations.CalcRoof;
import calculations.CalcStern;
import calculations.CalcStolper;
import functionLayer.LogicFacade;
import functionLayer.Product;

/**
 *
 * @author Jesper
 */
public class CalcJUnitTest {
    
    public CalcJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
   
   @Test
   public void calStolperAntalTest() {
       //Arrange
       Product p;
       CalcStolper cs = new CalcStolper();
       //Act
       p = cs.calcAntal(240, 240);
       double actual = p.getQty();
       double expected = 4;
       
       //Assert
       assertEquals(expected, actual,0.005);
       
   }

   @Test
   public void calRemAntalTest() {
       //Arrange
       Product p;
       CalcRem cr = new CalcRem();
       //Act
       p = cr.calcAntal(480, 480);
       double actual = p.getQty();
       double expected = 4;
       //Assert
       assertEquals(expected, actual,0.05);
   }

   
   @Test
   public void calTagAntalTest(){
       //Arrange
       Product p;
       CalcRoof ct = new CalcRoof();
       //Act
       p = ct.calcAntal(570, 600, "Tagpap");
       double actual = p.getQty();
       double expected = 8;
       //Assert
       assertEquals(expected,actual,0.05);
   }
   
   @Test
   public void calSternAntalTest(){
       //Arrange
       Product p;
       CalcStern cs = new CalcStern();
       //Act
       p = cs.calcAntalOverbrædt(240, 240);
       double actual = p.getQty();
       double expected = 2;
       //Assert
       assertEquals(expected,actual,0.005);
   }
   
   
   
}   
