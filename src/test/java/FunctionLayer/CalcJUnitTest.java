package FunctionLayer;

import functionLayer.LogicFacade;
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
import functionLayer.calculation.CalcNails;
import functionLayer.calculation.CalcOuterLayerOfShed;
import functionLayer.calculation.CalcPointedRoofTriangle;
import functionLayer.calculation.CalcShedSkeletton;
import functionLayer.calculation.CarportFlatProductListe;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

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
    List<Product> list = LogicFacade.getAllProductsFromDatabase();

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
        assertEquals(expected, actual, 0.005);

    }

    @Test(expected = IllegalArgumentException.class)
    public void calPoleTest_Minus() {
        //Arrange
        Product p;
        CalcPoles cs = new CalcPoles();
        //Act
        p = cs.calcAntal(-240, -240, list);
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
        assertEquals(expected, actual, 0.05);
    }

    @Test(expected = NullPointerException.class)
    public void calBeamEmptyList() {
        //Arrange
        CalcBeam cr = new CalcBeam();
        //Act
        Product actuals = cr.calcAntal(480, 480, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calBeamTest_Minus() {
        //Arrange
        Product p;
        CalcBeam cr = new CalcBeam();
        //Act
        p = cr.calcAntal(-480, 0, list);
    }

    @Test
    public void calRoofTest() {
        //Arrange
        Product p;
        CalcRoof ct = new CalcRoof();
        //Act
        p = ct.calcAntal(570, 600, "Tagpap", list);
        double actual = p.getQty();
        double expected = 8;
        //Assert
        assertEquals(expected, actual, 0.05);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calRoofTest_Minus() {
        //Arrange
        Product p;
        CalcRoof ct = new CalcRoof();
        //Act
        p = ct.calcAntal(-570, -600, "Tagpap", list);
    }

    @Test
    public void calSternOverbrædtTest() {
        //Arrange
        Product p;
        CalcStern cs = new CalcStern();
        //Act
        p = cs.calcAntalOverbrædt(240, 240, list);
        double actual = p.getQty();
        double expected = 2;
        //Assert
        assertEquals(expected, actual, 0.005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calSternTestOverbrædt_Minus() {
        //Arrange
        Product p;
        CalcStern cs = new CalcStern();
        //Act
        p = cs.calcAntalOverbrædt(-240, -240, list);
    }

    @Test
    public void calSternMellemTest() {
        //Arrange
        Product p;
        CalcStern cs = new CalcStern();
        //Act
        p = cs.calcAntalMellembrædt(240, 240, list);
        double actual = p.getQty();
        double expected = 2;
        //Assert
        assertEquals(expected, actual, 0.005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calSternTestMellem_Minus() {
        //Arrange
        Product p;
        CalcStern cs = new CalcStern();
        //Act
        p = cs.calcAntalMellembrædt(-240, -240, list);
    }

    @Test
    public void calSternUnderbrædtTest() {
        //Arrange
        Product p;
        CalcStern cs = new CalcStern();
        //Act
        p = cs.calcAntalUnderbrædt(240, 240, list);
        double actual = p.getQty();
        double expected = 2;
        //Assert
        assertEquals(expected, actual, 0.005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calSternTestUnderbrædt_Minus() {
        //Arrange
        Product p;
        CalcStern cs = new CalcStern();
        //Act
        p = cs.calcAntalUnderbrædt(-240, -240, list);
    }

    @Test
    public void calcNailsTest() {
        //Arrange
        Product p;
        CalcNails cn = new CalcNails();
        //Act
        p = cn.calcAntal_25mm_Varmforzinket(20, list);
        double actual = p.getQty();
        double expected = 20;
        //Assert
        assertEquals(expected, actual, 0.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcNailsTest_Minus() {
        //Arrange
        Product p;
        CalcNails cn = new CalcNails();
        //Act
        p = cn.calcAntal_25mm_Varmforzinket(-20, list);
    }

    @Test
    public void calcOuterLayer() {
        //Arrange
        Product p;
        CalcOuterLayerOfShed colos = new CalcOuterLayerOfShed();
        //Act
        p = colos.calAntal(240, 240, list);
        double actual = p.getQty();
        double expected = 90;
        //Assert
        assertEquals(expected, actual, 0.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calcOuterLayer_Minus() {
        //Arrange
        Product p;
        CalcOuterLayerOfShed colos = new CalcOuterLayerOfShed();
        //Act
        p = colos.calAntal(-240, -240, list);
    }

    @Test
    public void calcOuterLayerDOOR() {
        //Arrange
        double calcFrontPlanksAntal = 80 / 10;
        Product handtag;
        Product haengsel;
        Product firstAndSecondPlank;// top and bottom blank to hold the door
        Product thirdPlank; //cross  between the top and bottom plank
        Product frontPlanks;
        Product screws; // en pakke med 50st screws
        CalcOuterLayerOfShed colos = new CalcOuterLayerOfShed();
        //Act
        List<Product> expected = new ArrayList<>();
        for (Product product : list) {
            if (product.getId() == 81) {
                handtag = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), 1, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                expected.add(handtag);
            }
            if (product.getId() == 82) {
                haengsel = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), 1, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                expected.add(haengsel);
            }
            if (product.getId() == 3) {
                firstAndSecondPlank = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), 2, product.getPriceLine(), 80, product.getWidth(), product.getHeight());
                expected.add(firstAndSecondPlank);
                thirdPlank = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), 1, product.getPriceLine(), 200, product.getWidth(), product.getHeight());
                expected.add(thirdPlank);
            }
            if (product.getId() == 60) {
                frontPlanks = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), calcFrontPlanksAntal, product.getPriceLine(), 204, product.getWidth(), product.getHeight());
                expected.add(frontPlanks);
            }
            if (product.getId() == 33) {
                screws = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), product.getQty(), product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                expected.add(screws);
            }

        }
        List<Product> actual = colos.calcAntalDoor(list);
        //Assert
        Assert.assertEquals(expected.size(), actual.size());
    }

    @Test(expected = NullPointerException.class)
    public void calcOuterLayerDOOR_NULL() {
        //Arrange
        CalcOuterLayerOfShed colos = new CalcOuterLayerOfShed();
        //Act
        colos.calcAntalDoor(null);
    }

//    @Test
//    public void calcPointedRoofTriangleKatete() {
//        //Arrange
//        Product p;
//        CalcPointedRoofTriangle cprt = new CalcPointedRoofTriangle();
//        //Act
//        double actual = cprt.CalcKatete(240, 240, 15);
//        double expected = 202.86;
//        //Assert
//        assertEquals(expected, actual, 0.5);
//    }

//    @Test
//    public void calcPointedRoofTriangleAreal() {
//        //Arrange
//        Product p;
//        CalcPointedRoofTriangle cprt = new CalcPointedRoofTriangle();
//        //Act
//        double actual = cprt.CalcArealTriangle(240, 240, 15);
//        double expected = 322.86;
//        //Assert
//        assertEquals(expected, actual, 0.5);
//    }

    @Test
    public void CalcShedSkeletton() {
        //Arrange
        CalcShedSkeletton css = new CalcShedSkeletton();
        Product p;
        //Act
        p = css.calcAntalVerticalFrontAndBack(240, 240, list);
        String actual = p.getCategory();
        String expected = "beklædning";
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void CalcShedSkelettonHorizontal() {
        //Arrange
        CalcShedSkeletton css = new CalcShedSkeletton();
        Product p;
        //Act
        p = css.calcAntalHorizontal(240, 240, list);
        double actual = p.getQty();
        double expected = 18;
        //Assert
        assertEquals(expected, actual, 0.5);
    }

    @Test(expected = NullPointerException.class)
    public void CalcShedSkelettonHorizontalNULL() {
        //Arrange
        CalcShedSkeletton css = new CalcShedSkeletton();
        Product p;
        //Act
        p = css.calcAntalHorizontal(240, 240, null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void CalcShedSkelettonHorizontal_Minus() {
        //Arrange
        CalcShedSkeletton css = new CalcShedSkeletton();
        Product p;
        //Act
        p = css.calcAntalHorizontal(-240, 240, list);
    }

    @Test(expected = NullPointerException.class)
    public void carportCalculatorFlatRoof() {
        //Arrange
        CarportFlatProductListe cf = new CarportFlatProductListe();
        cf.carportCalculaterFlatRoof(240, 240, null);

    }
    
    @Test(expected = IllegalArgumentException.class)
    public void carportCalculatorFlatRoofMinus() {
        //Arrange
        CarportFlatProductListe cf = new CarportFlatProductListe();
        cf.carportCalculaterFlatRoof(-240, 240, "Tagpap");

    }

}
