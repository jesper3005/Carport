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
public class CalcBattens {

    public Product calcAntal(double length, double width, List allProducts) {

       if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        Product p = null;
        List<Product> productList = allProducts;
        double antal;
        try {
            double antalLaegterLength = 0;
            double totalMeterLægter = 0;
            //En lægte per 0.5 meter (50 cm)
            antalLaegterLength = length / 50;//50 cm
            // Hvad mange meter lægter skal vi brug til hele carportens bredje
            totalMeterLægter = (antalLaegterLength * width) / 540;//
            antal = Math.ceil(totalMeterLægter + antalLaegterLength);
            for (Product product : productList) {
                if (product.getCategory().equals("lægte")) {
                    p = new Product(product.getId(), product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());

                }
            }
            return p;
        } catch (Exception e) {
            e.getMessage();
            return p = new Product();
        }

    }

    public Product calcAntalPointedRoof(double length, double width, double degree, List allProducts) {

        if (length <= 0 || width <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null) {
            throw new NullPointerException();
        }

        Product p = null;
        List<Product> productList = allProducts;
        double antal;
        try {
            //+25 to make the roof extend out of the carport.
            double b = CalcPointedRoofTriangle.CalcKatete(length, width, degree) + 25;
            double antalLaegter = 0;
            double totalMeterLægter = 0;
            //En lægte per 0.5 meter (50 cm)
            antalLaegter = ((length / 50) * 2);//50 cm
            //Hvor mange meter lægter skal vi bruge til hele carportens length
            totalMeterLægter = (antalLaegter * b) / 540;//
            antal = Math.ceil((totalMeterLægter + antalLaegter) * 2);
            for (Product product : productList) {
                if (product.getCategory().equals("lægte")) {
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
