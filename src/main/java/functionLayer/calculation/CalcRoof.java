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
public class CalcRoof {

    private double antalScrews;

    public Product calcAntal(double length, double width, String roofMaterial, List allProducts) {
        List<Product> productList = allProducts;
        Product p = null;
        double antal; // antal tagpap
        double cm2; // quadratmeter

        try {
            cm2 = (width * length);
            for (Product product : productList) {
                if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (width % 60) == 0) {
                    antal = Math.ceil(cm2 / 45000);
                    p = new Product(40, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } else if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (cm2 % 80000) > 1) {
                    antal = Math.ceil(cm2 / 50000);
                    p = new Product(41, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } else if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (cm2 % 80000) < (cm2 % 50000)) {
                    antal = Math.ceil(cm2 / 80000);
                    p = new Product(39, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                    //on each side of the carport we add 20 cm to the length or width
                } else if (roofMaterial.equals("Trapeztag PVC Glasklar") && product.getId() == 73) {
                    cm2 = ((width + 40) * (length + 40));
                    //20 screws per m2 plus 50 ekstra
                    antalScrews = ((cm2 / 100) * 20) + 50;
                    //length 110 cm * width 61 cm = 6710cm2
                    antal = Math.ceil(cm2 / 6710);
                    p = new Product(73, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } //on each side of the carport we add 20 cm to the length or width
                else if (roofMaterial.equals("Trapeztag Boelgeplade") && product.getId() == 74) {
                    cm2 = ((width + 40) * (length + 40));
                    //20 screws per m2 plus 50 ekstra
                    antalScrews = ((cm2 / 100) * 20) + 50;
                    //length 109 cm * width 118 cm = 12862cm2
                    antal = Math.ceil(cm2 / 12862);
                    p = new Product(74, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }

            }
            return p;
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return p;
    }

    public int calcAntalScrews() {
        return (int) antalScrews;
    }

}
