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
public class CalcAngleBracket {

    public Product calcAntal(double qty, List allProducts) {

       if (qty <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        Product p = null;

        try {
            List<Product> productList = allProducts;
            for (Product product : productList) {
                if (product.getId() == 26) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qty, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();

        }

    }

}
