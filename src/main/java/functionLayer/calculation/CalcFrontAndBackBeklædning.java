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
 * @author oerte
 */
public class CalcFrontAndBackBeklædning {

    public Product calcAntal(double length, double width, double degree, List allProducts) {
        
        if (length <= 0 || width <= 0 || degree <=0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        // 10 ER WIDTH OF THE PLANKS
        double antalOfPlanks = width / Rules.PLANKS_WIDTH;

        try {

            for (Product product : productList) {
                if (product.getCategory().equals("udbeklædning") && width >= product.getLength()) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antalOfPlanks, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;

        } catch (Exception e) {
            e.getMessage();
            return p = new Product();
        }
    }
}
