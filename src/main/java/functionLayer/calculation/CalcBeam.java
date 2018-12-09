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
public class CalcBeam {

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
            int antal = 0;
            if (width >= 510) {
                antal = 5;
            } else {
                antal = 4;
            }
            for (Product product : productList) {
                if (product.getCategory().equals("rem") && product.getLength() == length) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            e.getMessage();
            return p = new Product();
        }

    }

    public Product calcAntalPointedRoofTOP(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        double antal = 0;
        try {

            for (Product product : productList) {
                if (product.getCategory().equals("rem") && product.getLength() == length) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            e.getMessage();
            return p = new Product();
        }

    }

}
