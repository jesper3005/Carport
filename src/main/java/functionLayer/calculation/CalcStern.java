/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.LogicFacade;
import functionLayer.Product;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CalcStern {

    private List<Product> productList = LogicFacade.getAllProductsFromDatabase();
    private Product p;

    public Product calcAntalOverbrædt(double length, double width) {

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
            e.getMessage();
        }
        return p;

    }

    public Product calcAntalMellembrædt(double length, double width) {

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
            e.getMessage();
        }
        return null;

    }

    public Product calcAntalUnderbrædt(double length, double width) {

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
            e.getMessage();
        }
        return null;

    }

}
