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

//rem
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
            if (allProducts != null) {
                double antal = 0;
                if (width >= 510) {
                    antal = Rules.AMOUNT_OF_BEAMS_OVER_OR_EQUAL_540;
                } else {
                    antal = Rules.AMOUNT_OF_BEAMS_UNDER_540;
                }
                for (Product product : productList) {
                    if (product.getCategory().equals("rem") && product.getLength() == length) {
                        p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                    }
                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CalcBeam.class.getName());
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
           System.out.println(e.getMessage() +" "+ CalcBeam.class.getName());
            return p = new Product();
        }

    }

}
