    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.LogicFacade;
import functionLayer.Product;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CalcShedSkeletton {

    public static List<Product> productList = LogicFacade.getAllProductsFromDatabase();
    public static Product p;

   
    public Product calcAntalVerticalFrontAndBack(double length, double width) {
        double antal = 4; // top and bottom plank

        try {
            for (Product product : productList) {
                if (product.getCategory().equals("beklædning") && product.getLength() == length) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }
            }
            return p;
        } catch (Exception e) {
            e.getMessage();
        }
        return p;

    }

    public Product calcAntalVerticalLeftAndRight(double length, double width) {
        double antal = 4; // top and bottom plank

        try {
            for (Product product : productList) {
                if (product.getCategory().equals("beklædning") && product.getLength() == width) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }
            }
            return p;
        } catch (Exception e) {
            e.getMessage();
        }
        return p;

    }

    /*
    carport heights is 260 cm 
    260 cm - 30 cm of rem heights
    230 cm - 20 cm of heights of planks vertical
    210 cm planks to be used horizontal 
     */
    public Product calcAntalHorizontal(double length, double width) {
        double doorWidth = 80;
        double antal = Math.ceil((((length * 2) + (width * 2)) - doorWidth) / 50); // horizontal planks with 50 cm space in between

        try {
            for (Product product : productList) {
                if (product.getId() == 58) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }
            }
            return p;
        } catch (Exception e) {
            e.getMessage();
        }
        return p;

    }
    

}
