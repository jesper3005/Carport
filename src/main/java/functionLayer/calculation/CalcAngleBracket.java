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
        if(qty <= 0){
            throw new ArithmeticException("Value has to be larger then 0! CalcAngleBracket");
        }
        try {
            if (qty <= 0) {
                qty = 1;
            } else {
                List<Product> productList = allProducts;
                Product p = null;
                for (Product product : productList) {
                    if (product.getId() == 26) {
                        p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qty, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                    }
                }
                return p;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
