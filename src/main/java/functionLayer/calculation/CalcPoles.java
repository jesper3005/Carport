/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.Product;
import java.util.List;

/**
 *
 * @author Jesper
 */
public class CalcPoles {

    public Product calcAntal(double length, double width, List allProducts) {
        
        if(length <= 0 || width <= 0){
            throw new IllegalArgumentException("Value has to be larger den o. CalcPoles class");
        }
        
        List<Product> productList = allProducts;
        Product p = null;
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