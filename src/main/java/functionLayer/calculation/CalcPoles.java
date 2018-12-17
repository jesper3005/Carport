/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.Product;
import functionLayer.Rules;
import java.util.List;

/**
 *
 * @author Jesper
 */
public class CalcPoles {

    public Product calcAntal(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        try {
            double antal = 0;
            if (length <= 450) {
                antal = Rules.AMOUNT_OF_POLES_LESS_OR_EQUAL_450;
            } else if (length > 450) {
                antal = Rules.AMOUNT_OF_POLES_OVER_450;
            }
            for (Product product : productList) {
                if (product.getCategory().equals("stolpe") && length < 300) {
                    p = new Product(30, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
                if (product.getCategory().equals("stolpe") && length < 450 && length >= 300) {
                    p = new Product(29, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
                if (product.getCategory().equals("stolpe") && length < 660 && length >= 450) {
                    p = new Product(28, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
                if (product.getCategory().equals("stolpe") && length <= 750 && length >= 660) {
                    p = new Product(27, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();
        }
    }

}
