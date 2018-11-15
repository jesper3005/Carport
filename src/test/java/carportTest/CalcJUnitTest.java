
package carportTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import calculations.CalcLaegter;
import calculations.CalcRem;
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
       assertEquals(4, cs.calAntalStolper(350));
       assertEquals(6, cs.calAntalStolper(460));
   }

   @Test
   public void calRemAntalTest() {
       CalcRem cr = new CalcRem();
       assertEquals(4, cr.calcAntalRem(480));
       assertEquals(5, cr.calcAntalRem(510));
       System.out.println("asd");
   }

   @Test
   public void calPriceForRim(){
       CalcStolper cs = new CalcStolper();
       assertEquals(1600,cs.priceStolper(4, 400),0);
       CalcRem cr = new CalcRem();
       assertEquals(50000, cs.priceStolper(5, 10000), 0);
   }

   @Test
   public void calLaegterAntalTest(){
       CalcLaegter cl = new CalcLaegter();
       assertEquals(2, cl.calAntalLaegterFlatRoof(240));
       assertEquals(3, cl.calAntalLaegterFlatRoof(270));

   }
}   
