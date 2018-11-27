/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculations;

import functionLayer.LogicFacade;
import functionLayer.Product;
import java.util.List;

/**
 *
 * @author Jesper
 */
public class CalcStolper {

    private List<Product> productList = LogicFacade.getAllProductsFromDatabase();
    private Product p;

    public Product calcAntal(double length, double width) {

        try {
            int antal = 0;
            if (length <= 450) {
                antal = 4;
            } else if (length > 450) {
                antal = 6;
            }
            for (Product product : productList) {
                if (product.getCategory().equals("stolpe") && length < 300) {
                    p = new Product(31, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
                if (product.getCategory().equals("stolpe") && length < 450 && length >= 300) {
                    p = new Product(30, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
                if (product.getCategory().equals("stolpe") && length < 660 && length >= 450) {
                    p = new Product(29, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
                if (product.getCategory().equals("stolpe") && length <= 750 && length >= 660) {
                    p = new Product(28, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;

        } catch (NullPointerException e) {
        }
        return p;
    }

    

}
