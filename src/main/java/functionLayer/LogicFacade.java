/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import dbAccess.CarportMapper;
import dbAccess.CustomerMapper;
import functionLayer.calculation.CarportFlatProductListe;
import dbAccess.ProductMapper;
import dbAccess.UserMapper;
import exceptions.FogException;
import functionLayer.calculation.CarportPointedRoofListe;
import java.text.DecimalFormat;
import java.util.List;

/**
 *
 * @author oerte
 */
public class LogicFacade {

    // ------------ LOGICFACADE METHODS FOR DATABASE -----------------
    public static User login(String email, String password) throws FogException {
        UserMapper um = new UserMapper();
        return um.getUser(email, password);
    }

    public static User createUser(String email, String password, int customerID) {
        User user = new User(email, password, "customer", customerID);
        UserMapper um = new UserMapper();
        um.createUser(user);
        return user;
    }

    public static Customer getCustomerByEmail(String email) {
        CustomerMapper cm = new CustomerMapper();
        Customer customer = cm.getCustomerByEmail(email);
        return customer;

    }
    
    public static void addCustomer(Customer customer) {
        CustomerMapper cm = new CustomerMapper();
        cm.addCustomer(customer);

    }

    public static Customer createCustomer(Customer customer) {
        CustomerMapper cm = new CustomerMapper();
        cm.addCustomer(customer);
        return customer;
    }

    public static void addCarport(Carport carport, Shed shed) {
        CarportMapper cm = new CarportMapper();
        cm.addCarport(carport, shed);
    }

    public static Shed addShed(Shed shed) {
        CarportMapper cm = new CarportMapper();
        cm.addShed(shed);
        return shed;
    }

    public static List<Carport> getOrdresFromCarportByEnum(String enumValue) {
        CarportMapper cm = new CarportMapper();
        List<Carport> carportList = cm.getCarportByStatus(enumValue);
        return carportList;
    }

    public static List<Carport> getALLOrdresFromCarport() {
        CarportMapper cm = new CarportMapper();
        List<Carport> carportList = cm.getAllCarportOrder();
        return carportList;
    }

    public static void updateOrderStatus(String status, int id) {
        CarportMapper cm = new CarportMapper();
        cm.updateOrderStatus(status, id);
    }

    public static void addProduct(Product product) {
        ProductMapper pm = new ProductMapper();
        pm.addProducts(product);
    }

    public static List<Product> getAllProductsFromDatabase() {
        ProductMapper pm = new ProductMapper();
        List<Product> produktList = pm.allProducts();
        return produktList;
    }

    public static List<Product> searchInDatabaseProductTable(String value) {
        ProductMapper pm = new ProductMapper();
        List<Product> searchList = pm.searchInProductTable(value);
        return searchList;
    }
    
    public static List<Product> remOrderedByLength(){
        ProductMapper pm = new ProductMapper();
        List<Product> remList = pm.orderByLengthRem();
        return remList;
    }
   
   public static void updatePrice(int id, double price) {
       ProductMapper pm = new ProductMapper();
       pm.updatePrice(id, price);
   }
   
   public static void deleteProduct(int productID) {
       ProductMapper pm = new ProductMapper();
       pm.deleteProduct(productID);
   }
   

    // ------- CARPORT CALCULATIONS LOGICFACADE ---------
    public static List<Product> CarportCalculaterFlatRoof(double length, double width, String roofMaterial) {
        CarportFlatProductListe cfp = new CarportFlatProductListe();
        List<Product>  list = cfp.carportCalculaterFlatRoof(length, width, roofMaterial);
        return list;
    }

    public static List<Product> CarportCalculaterFlatRoofIncludingShed(double length, double width, double shedLength, double shedWidth, String roofMaterial) {
        CarportFlatProductListe cfp = new CarportFlatProductListe();
        List<Product>  list = cfp.carportCalculaterFlatRoofIncludingShed(length, width, shedLength, shedWidth, roofMaterial);
        return list;
    }

    public static List<Product> CarportCalculatorPointedRoof(double length, double width, double degree, String roofMaterial) {
        CarportPointedRoofListe cfp = new CarportPointedRoofListe();
        List<Product> list = cfp.carportCalculaterPointedRoof(length, width, degree, roofMaterial);
        return list;
    }

    public static List<Product> CarportCalculatorPointedRoofIncludingShed(double length, double width, double degree, double shedLength, double shedWidth, String roofMaterial) {
        CarportPointedRoofListe cfp = new CarportPointedRoofListe();
        List<Product> list = cfp.carportCalculaterPointedRoofIncludingShed(length, width, degree, length, width, roofMaterial);
        return list;
    }

    public static double roundDoubleToTwoDecimalPoints(double value) {
        DecimalFormat df2 = new DecimalFormat(".##");
        return Double.parseDouble(df2.format(value));

    }


    public static double totalPriceOfCarport(List<Product> stykliste) {
        double totalPriceOfCarport = 0;
        for (Product produkt : stykliste) {
            totalPriceOfCarport += produkt.getTotalPriceOfOrder();
        }
        return roundDoubleToTwoDecimalPoints(totalPriceOfCarport);
    }

//    public static int[] StringArrayToIntArray(String[] s) {
//        int[] arrayOfInteger = new int[s.length];
//        for (int i = 0; i < s.length; i++) {
//            arrayOfInteger[i] = Integer.parseInt(s[i]);
//        }
//        return arrayOfInteger;
//    }
//
//    public static List<Integer> StringListToIntList(List<String> s) {
//        List<Integer> arrayOfInteger = new ArrayList<>();
//        for (String string : s) {
//            arrayOfInteger.add(Integer.valueOf(string));
//        }
//        return arrayOfInteger;
//    }
}
