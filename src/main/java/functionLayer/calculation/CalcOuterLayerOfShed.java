/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CalcOuterLayerOfShed {

    /*
    All planks are placed horizontal, incl. the part on top of the door
    
     */
    public Product calAntal(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        double widthOfPlanks = 10; //cm
        double doorWidth = 80;
        // doorTop is the gap between roof and door
        double doorTop = 2;
        double antalOfPlanks;

        try {
            antalOfPlanks = Math.ceil(((((length * 2) + (width * 2)) - doorWidth) / widthOfPlanks) + doorTop);

            for (Product product : productList) {
                if (product.getId() == 65) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antalOfPlanks, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();
        }
    }

    /*
    Door is 80 cm in width and 2040 cm in length
    One door needs 
    - one door handle
    - three planks to attach the front planks of the door
    - two hinges (hængsel)
     */
    public List<Product> calcAntalDoor(List allProducts) {
        
        if (allProducts == null) {
            throw new NullPointerException();
        }
        
        List<Product> list = allProducts;
        List<Product> doorList = new ArrayList<>();
        double calcFrontPlanksAntal = 80 / 10;//door width divided with plank width
        Product handtag;
        Product haengsel;
        Product firstAndSecondPlank;// top and bottom blank to hold the door
        Product thirdPlank; //cross  between the top and bottom plank
        Product frontPlanks;
        Product screws; // en pakke med 50st screws

        try {
            for (Product product : list) {
                if (product.getId() == 81) {
                    handtag = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), 1, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                    doorList.add(handtag);
                }
                if (product.getId() == 82) {
                    haengsel = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), 1, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                    doorList.add(haengsel);
                }
                if (product.getId() == 3) {
                    firstAndSecondPlank = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), 2, product.getPriceLine(), 80, product.getWidth(), product.getHeight());
                    doorList.add(firstAndSecondPlank);
                    thirdPlank = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), 1, product.getPriceLine(), 200, product.getWidth(), product.getHeight());
                    doorList.add(thirdPlank);
                }
                if (product.getId() == 60) {
                    frontPlanks = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), calcFrontPlanksAntal, product.getPriceLine(), 204, product.getWidth(), product.getHeight());
                    doorList.add(frontPlanks);
                }
                if (product.getId() == 33) {
                    screws = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), product.getQty(), product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                    doorList.add(screws);
                }

            }
            return doorList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
