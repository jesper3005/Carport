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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    /**
     * This method will create a hashed password and return it, with help of
     * userns password.
     *
     * @param password Userns password.
     * @return Returns a new hashed password String
     */
    public static String createHashedPassword(String password) {
        String passwordToHash = password;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static User createUser(String email, String password, int customerID) {
        User user = new User(password, email, "customer", customerID);
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

    public static int createCustomer(Customer customer) {
        CustomerMapper cm = new CustomerMapper();
        int id = cm.addCustomerAndUser(customer);
        return id;
    }

    public static void addCarport(Carport carport, Shed shed) {
        System.out.println("addCarportLogicFacade");
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

    public static List<Product> remOrderedByLength() {
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
    
    public static Carport getCarportByID(int caportID) {
        CarportMapper cm = new CarportMapper();
        Carport carport = cm.getCarportById(caportID);
        return carport;
    }

    // -----------------CARPORT CALCULATIONS LOGICFACADE --------------------------------
    /**
     * This methode is called in,
     * CreateOrderFlatRoof.java in presentationLayer, to get the total price of the carport, what is then used to create a carport in the Database,
     * OrderRequestFlatRoof.java in presentationLayer, to get the total price of the carport, what is used to show the price at orderRequestFlatRoof.jsp,
     * SeeOrderProductList.java in presentationLayer, to show a List of parts for an specifik customer by Id.
     *
     * @param length Length of the carport from carportFlatRood.jsp
     * @param width Width of the carport from carportFlatRood.jsp
     * @param roofMaterial Roof material is choosen from the client through carportFlarRoof.jsp or carportPointedRoof.jsp.
     * @return Returns a list of all products, that is needed to build a carport with a flat roof.
     * 
     */
    public static List<Product> CarportCalculaterFlatRoof(double length, double width, String roofMaterial) {
        CarportFlatProductListe cfp = new CarportFlatProductListe();
        List<Product> list = cfp.carportCalculaterFlatRoof(length, width, roofMaterial);
        return list;
    }
    
    /**
     * This methode is called in, 
     * CreateOrderFlatRoof.java in presentationLayer, to get the total price of the carport, what is then used to create a carport in the Database,
     * OrderRequestFlatRoof.java in presentationLayer, to get the total price of the carport, what is used to show the price at orderRequestFlatRoof.jsp,
     * SeeOrderProductList.java in presentationLayer, to show a List of parts for an specifik customer by Id.
     * 
     * @param length Length of the carport from carportFlatRood.jsp.
     * @param width Width of the carport from carportFlatRood.jsp.
     * @param shedLength Length of shed from carportFlatRood.jsp.
     * @param shedWidth Width of shed from carportFlatRood.jsp.
     * @param roofMaterial Roof material is choosen from the client through carportFlarRoof.jsp or carportPointedRoof.jsp.
     * @return Returns a list of all products, that is needed to build a carport with a flat roof and shed.
     * 
     */
    public static List<Product> CarportCalculaterFlatRoofIncludingShed(double length, double width, double shedLength, double shedWidth, String roofMaterial) {
        CarportFlatProductListe cfp = new CarportFlatProductListe();
        List<Product> list = cfp.carportCalculaterFlatRoofIncludingShed(length, width, shedLength, shedWidth, roofMaterial);
        return list;
    }
    
    /**
     * This methode is called in, 
     * CreateOrderPointedRoof.java in presentationLayer, to get the total price of the carport, what is then used to create a carport in the Database,
     * OrderRequestPointedRoof.java in presentationLayer, to get the total price of the carport, what is used to show the price at orderRequestPointedRoof.jsp,
     * SeeOrderProductList.java in presentationLayer, to show a List of parts for an specifik customer by Id.
     *
     * @param length Length of the carport from carportPointedRoodf.jsp.
     * @param width Width of the carport from carportPointedRoof.jsp.
     * @param degree Degree of the carports Pointed roof from carportPointedRoof.jsp.
     * @param roofMaterial Roof material is choosen from the client through carportFlarRoof.jsp or carportPointedRoof.jsp.
     * @return Returns a list of all products, that is needed to build a carport with a Pointed roof.
     */
    public static List<Product> CarportCalculatorPointedRoof(double length, double width, double degree, String roofMaterial) {
        CarportPointedRoofListe cfp = new CarportPointedRoofListe();
        List<Product> list = cfp.carportCalculaterPointedRoof(length, width, degree, roofMaterial);
        return list;
    }
    
    /**
     * This methode is called in, 
     * CreateOrderPointedRoof.java in presentationLayer, to get the total price of the carport, what is then used to create a carport in the Database,
     * OrderRequestPointedRoof.java in presentationLayer, to get the total price of the carport, what is used to show the price at orderRequestPointedRoof.jsp,
     * SeeOrderProductList.java in presentationLayer, to show a List of parts for an specifik customer by Id.
     * 
     * @param length Length of the carport from carportPointedRoodf.jsp.
     * @param width Width of the carport from carportPointedRoof.jsp.
     * @param degree Degree of the carports Pointed roof from carportPointedRoof.jsp.
     * @param shedLength Length of shed from carportPointedRood.jsp.
     * @param shedWidth Width of shed from carportPointedRood.jsp.
     * @param roofMaterial Roof material is choosen from the client through carportFlatRoof.jsp or carportPointedRoof.jsp.
     * @return Returns a list of all products, that is needed to build a carport with a Pointed roof and shed.
     */
    public static List<Product> CarportCalculatorPointedRoofIncludingShed(double length, double width, double degree, double shedLength, double shedWidth, String roofMaterial) {
        CarportPointedRoofListe cfp = new CarportPointedRoofListe();
        List<Product> list = cfp.carportCalculaterPointedRoofIncludingShed(length, width, degree, length, width, roofMaterial);
        return list;
    }
    /**
     * This method with help of javas DecimalFormater, rounds a double to two decimal after the comma,
     * This methode is called in,
     * LogicFacade.java in functionLayer, in method totalPriceOfCarport,
     * Product.java in functionLayer, in method getPriceLine.
     * 
     * @param value 
     * @return Returns a double with two decimals after the comma.
     */
    public static double roundDoubleToTwoDecimalPoints(double value) {
        DecimalFormat df2 = new DecimalFormat(".##");
        return Double.parseDouble(df2.format(value));

    }
    
    /**
     * This method takes a list of parts, loop through the list and add each priceLine of each product with eachother.
     * 
     * @param stykliste Is a specific list of an Carport with all products needed to build it.
     * @return Returns the total price of an Carport.
     */
    public static double totalPriceOfCarport(List<Product> stykliste) {
        double totalPriceOfCarport = 0;
        for (Product produkt : stykliste) {
            totalPriceOfCarport += produkt.getTotalPriceOfOrder();
        }
        return roundDoubleToTwoDecimalPoints(totalPriceOfCarport);
    }


}
