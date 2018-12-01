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
public class CalcNails {

    public Product calcAntal_25mm_Varmforzinket(double qty, List allProducts) {
        List<Product> productList = allProducts;
        Product p = null;
        try {
            for (Product product : productList) {
                if (product.getId() == 36) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qty, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
        }
        return p;

    }

    public Product calcAntal_25mm_Blanke(double qty, List allProducts) {
        List<Product> productList = allProducts;
        Product p = null;
        try {
            for (Product product : productList) {
                if (product.getId() == 35) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qty, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
        }
        return p;

    }

    public Product calcAntal_20mm_Blanke(double qty, List allProducts) {
        List<Product> productList = allProducts;
        Product p = null;
        try {
            for (Product product : productList) {
                if (product.getId() == 34) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qty, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
        }
        return p;

    }

}
