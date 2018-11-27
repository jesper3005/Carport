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
public class CalcLaegter {

    private List<Product> productList = LogicFacade.getAllProductsFromDatabase();
    private Product p;
    private double antal;

    public CalcLaegter() {
        this.antal = antal;
    }
    
    

    public Product calcAntal(double length, double width) {

        try {
            double antalLaegterLength = 0;
            double totalMeterLægter = 0;
            //En lægte per 0.5 meter (50 cm)
            antalLaegterLength = length / 50;//50 cm
            // Hvad mange meter lægter skal vi brug til hele carportens bredje
            totalMeterLægter = (antalLaegterLength * width) / 540;//
            this.antal = Math.ceil(totalMeterLægter + antalLaegterLength);
            for (Product product : productList) {
                if (product.getCategory().equals("lægte")) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), this.antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return null;

    }

//    //6 søm per lægte
//    public Product calcAntalSøm() {
//        this.antal *= 6;
//        for (Product product : productList) {
//            if (product.getId() == 35) {
//                p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), this.antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
//
//            }
//        }
//        return p;
//    }

}
