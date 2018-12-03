package FunctionLayer;
import dbAccess.ProductMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import functionLayer.calculation.CalcBeam;
import functionLayer.calculation.CalcRoof;
import functionLayer.calculation.CalcStern;
import functionLayer.calculation.CalcPoles;
import functionLayer.Product;
import java.util.List;

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
    
    //Test negative og grænse værdier
   
    ProductMapper pm = new ProductMapper();
    List<Product> list = pm.allProducts();
    
   @Test
   public void calPoleTest() {
       //Arrange
       Product p;
       CalcPoles cs = new CalcPoles();
       //Act
       p = cs.calcAntal(240, 240, list);
       double actual = p.getQty();
       double expected = 4;
       
       //Assert
       assertEquals(expected, actual,0.005);
       
   }
   @Test (expected = ArithmeticException.class)
   public void calPoleTest_Minus() {
       //Arrange
       Product p;
       CalcPoles cs = new CalcPoles();
       //Act
       p = cs.calcAntal(-240,-240, list);
       double actual = p.getQty();
       double expected = 0;
       
       //Assert
       assertEquals(expected, actual,0.005);
       
   }

   @Test
   public void calBeamTest() {
       //Arrange
       Product p;
       CalcBeam cr = new CalcBeam();
       //Act
       p = cr.calcAntal(480, 480, list);
       double actual = p.getQty();
       double expected = 4;
       //Assert
       assertEquals(expected, actual,0.05);
   }
   
   @Test (expected = ArithmeticException.class)
   public void calBeamTest_Minus() {
       //Arrange
       Product p;
       CalcBeam cr = new CalcBeam();
       //Act
       p = cr.calcAntal(-480, -480, list);
       double actual = p.getQty();
       double expected = 4;
       //Assert
       assertEquals(expected, actual,0.05);
   }

   
   @Test
   public void calRoofTest(){
       //Arrange
       Product p;
       CalcRoof ct = new CalcRoof();
       //Act
       p = ct.calcAntal(570, 600, "Tagpap", list);
       double actual = p.getQty();
       double expected = 8;
       //Assert
       assertEquals(expected,actual,0.05);
   }
   
//   @Test (expected = ArithmeticException.class)
//   public void calRoofTest_Minus(){
//       //Arrange
//       Product p;
//       CalcRoof ct = new CalcRoof();
//       //Act
//       p = ct.calcAntal(-570, 600, "Tagpap", list);
//       double actual = p.getQty();
//       double expected = 8;
//       //Assert
//       assertEquals(expected,actual,0.05);
//   }
   
   @Test
   public void calSternTest(){
       //Arrange
       Product p;
       CalcStern cs = new CalcStern();
       //Act
       p = cs.calcAntalOverbrædt(240, 240, list);
       double actual = p.getQty();
       double expected = 2;
       //Assert
       assertEquals(expected,actual,0.005);
   }
   
//   @Test
//   public void calTagAntalTest(){
//       //Arrange
//       Product p;
//       CalcRoof ct = new CalcRoof();
//       //Act
//       p = ct.calcAntal(570, 600, "Tagpap", list);
//       double actual = p.getQty();
//       double expected = 8;
//       //Assert
//       assertEquals(expected,actual,0.05);
//   }
//   
//   @Test
//   public void calSternAntalTest(){
//       //Arrange
//       Product p;
//       CalcStern cs = new CalcStern();
//       //Act
//       p = cs.calcAntalOverbrædt(240, 240, list);
//       double actual = p.getQty();
//       double expected = 2;
//       //Assert
//       assertEquals(expected,actual,0.005);
//   }
//   
   
   
}   