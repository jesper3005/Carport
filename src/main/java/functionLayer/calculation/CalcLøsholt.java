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
public class CalcLøsholt {

    public Product calcAntalPointedRoof(double length, double width, double degree, List allProducts) {

        Product p = null;
        List<Product> productList = allProducts;

        double løsholdtLengthB = CalcPointedRoofTriangle.CalcHypotesen(length, width, degree) + 25;
        double antal = 4;

        for (Product product : productList) {
            if (product.getCategory().equals("løsholdt") && løsholdtLengthB >= product.getLength()) {
                p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

            }
            return p;
        }
        return p;
    }
    
    

}
