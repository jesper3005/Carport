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
public class CalcScrew {
    
    
    public Product calcAntal_3X25MM(double qyt, List allProducts) {

        if (qyt <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;

        try {
            for (Product product : productList) {
                if (product.getId() == 31) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qyt, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CalcScrew.class.getName());
            return p = new Product();
        }
    }

    public Product calcAntal_8X120MM_50STK_Pakke(double qyt, List allProducts) {

        if (qyt <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;

        try {
            for (Product product : productList) {
                if (product.getId() == 32) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qyt, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CalcScrew.class.getName());
            return p = new Product();
        }
    }

    public Product calcAntal_3komma5X30MM(double qyt, List allProducts) {

        if (qyt <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;

        try {
            for (Product product : productList) {
                if (product.getId() == 33) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qyt, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CalcScrew.class.getName());
            return p = new Product();
        }
    }

}
