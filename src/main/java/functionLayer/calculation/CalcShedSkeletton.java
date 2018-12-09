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
public class CalcShedSkeletton {

    public Product calcAntalVerticalFrontAndBack(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new ArithmeticException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        double antal = 4; // top and bottom plank

        try {
            for (Product product : productList) {
                if (product.getCategory().equals("beklædning") && product.getLength() == length) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();
        }

    }

    public Product calcAntalVerticalLeftAndRight(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new ArithmeticException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        double antal = 4; // top and bottom plank
        double heightOfPlanksFrontandBack = 4;
        try {
            for (Product product : productList) {
                if (product.getCategory().equals("beklædning") && product.getLength() == width) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength() - heightOfPlanksFrontandBack, product.getWidth(), product.getHeight());
                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();
        }

    }

    /*
    carport heights is 260 cm 
    260 cm - 30 cm of beam heights
    230 cm - 20 cm of heights of planks vertical
    210 cm - 4 cm of heights from both planks _ top and bottom
    206 cm planks to be used horizontal 
     */
    public Product calcAntalHorizontal(double length, double width, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new ArithmeticException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        double doorWidth = 80;
        double antal;

        try {
            antal = Math.ceil((((length * 2) + (width * 2)) - doorWidth) / 50); // horizontal planks with 50 cm space in between
            for (Product product : productList) {
                if (product.getId() == 37) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }
            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();
        }

    }

}
