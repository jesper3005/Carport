
package carportTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import calculations.CalcLaegter;
import calculations.CalcRem;
import calculations.CalcTag;
import calculations.CalcStern;
import calculations.CalcStolper;
import functionLayer.LogicFacade;

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
       CalcStolper cs = new CalcStolper();
       assertEquals(4, cs.calcAntal(350,350),0);
       assertEquals(6, cs.calcAntal(460,460),0);
   }

   @Test
   public void calRemAntalTest() {
       //Arrange
       CalcRem cr = new CalcRem();
       
       //Act
       double expected, actual;
       expected = 4;
       actual = cr.calcAntal(480, 480);
       
       //Assert
       assertEquals(expected, actual,0);
   }

   
   @Test
   public void calTagAntalTest(){
       //Arrange
       CalcTag cr = new CalcTag();
       
       //Act
       double expected, actual;
       expected = 1;
       actual = cr.calcAntal(240, 240);
       
       //Assert
       assertEquals(expected, actual, 0);
       
   }
   
   @Test
   public void calSternAntalTest(){
       //Arrange
       CalcStern cs = new CalcStern();
       
       //Act
       double expected, actual;
       expected = 2;
       actual = cs.calcAntal(240, 240);
       
       //Assert
       assertEquals(expected, actual, 0);
   }
   
   
   
}   
