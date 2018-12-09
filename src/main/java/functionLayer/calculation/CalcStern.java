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
public class CalcStern {

    public Product calcAntalOverbrædt(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        try {
            double totalLength = ((2 * length) + (2 * width));
            //on the front and back we have to deduct the height of each "stern"
            totalLength -= (4 * 3);
            double antal = Math.ceil(totalLength / 540);
            for (Product product : productList) {
                if (product.getId() == 42) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();
        }

    }

    public Product calcAntalMellembrædt(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        try {
            double totalLength = ((2 * length) + (2 * width));
            //on the front and back we have to deduct the height of each "stern"
            totalLength -= (4 * 3);
            double antal = Math.ceil(totalLength / 540);
            for (Product product : productList) {
                if (product.getId() == 43) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return p = new Product();
        }

    }

    public Product calcAntalUnderbrædt(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        try {
            double totalLength = ((2 * length) + (2 * width));
            //on the front and back we have to deduct the height of each "stern"
            totalLength -= (4 * 3);
            double antal = Math.ceil(totalLength / 540);
            for (Product product : productList) {
                if (product.getId() == 44) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return p = new Product();
        }

    }

}
