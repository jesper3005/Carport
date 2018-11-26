/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculations;

import functionLayer.LogicFacade;
import functionLayer.Product;
import java.util.List;

/**
 *
 * @author Jesper
 */
public class CalcRem {

    private List<Product> productList = LogicFacade.getAllProductsFromDatabase();
    private Product p;

    public Product calcAntal(double length, double width) {

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
        } catch (NullPointerException e) {
            e.getMessage();
        }
        return null;

    }

//    //4 vinkelbeslag per rem
//    public Product calcAntalVinkelbeslag(double qty) {
//        qty *= 4;
//        for (Product product : productList) {
//            if (product.getId() == 27) {
//                p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qty, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
//
//            }
//        }
//        return p;
//    }
//
//    //8 skruer per vinkelbeslag = det er 24 per rem
//    public Product calcAntalSkruer(double qty) {
//        double antalSkruerIpakken = 50;
//        qty *= 24;
//        qty = Math.ceil(qty/antalSkruerIpakken);
//        for (Product product : productList) {
//            if (product.getId() == 33) {
//                p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), qty, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
//
//            }
//        }
//        return p;
//    }

}
