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
 * @author oerte
 */
public class CalcFrontAndBackBeklædning {

    public Product calcAntal(double length, double width, double degree, List allProducts) {

        List<Product> productList = allProducts;
        Product p = null;
        double antalOfPlanks = width / 10;

        try {

            for (Product product : productList) {
                if (product.getCategory().equals("udbeklædning") && width >= product.getLength()) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antalOfPlanks, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;

        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
