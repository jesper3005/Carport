/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.LogicFacade;
import functionLayer.Product;
import functionLayer.Rules;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CalcLøsholt {
    
    

    public Product calcAntalPointedRoof(double length, double width, double degree, List allProducts) {

        if (length <= 0 || width <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        Product p = null;
        List<Product> productList = allProducts;
        try {
            double løsholtLengthB = CalcPointedRoofTriangle.CalcKatete(length, width, degree) + Rules.POINTED_ROOF_SURPLUS;
            double antal = 4;

            for (Product product : productList) {
                if (product.getCategory().equals("løsholt") && product.getLength() >= løsholtLengthB) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;

        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CalcLøsholt.class.getName());
            return p = new Product();

        }

    }

}
