
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
       CalcRem cr = new CalcRem();
       assertEquals(4, cr.calcAntal(480,480),0);
       assertEquals(5, cr.calcAntal(510,510),0);
   }

   @Test
   public void calPriceForRim(){
       CalcStolper cs = new CalcStolper();
       assertEquals(1600,cs.calcPrice(4, 400),0);
       CalcRem cr = new CalcRem();
       assertEquals(50000, cs.calcPrice(5, 10000), 0);
   }

   @Test
   public void calLaegterAntalTest(){
       CalcLaegter cl = new CalcLaegter();
       assertEquals(8,cl.calcAntal(240, 240),0);

   }
   @Test
   public void calTagAntalTest(){
       CalcRoof cr = new CalcRoof();
       assertEquals(1, cr.calcAntal(240, 240), 0);
       assertEquals(5,cr.calcAntal(570, 600),0);
   }
   
   @Test
   public void calSternAntalTest(){
       CalcStern cs = new CalcStern();
       assertEquals(2, cs.calcAntal(240,240), 0);
   }
   
}   
