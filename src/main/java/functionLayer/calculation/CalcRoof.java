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

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null || roofMaterial == null || roofMaterial.equals("")) {
            throw new NullPointerException();
        }

        List<Product> productList = allProducts;
        Product p = null;
        double cm2 = length * width; // quadratcentimeter
        double antal; // antal tagpap

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
                } else if (roofMaterial.equals("Trapeztag PVC Glasklar") && product.getId() == 64) {
                    cm2 = ((width + 40) * (length + 40));
                    //20 screws per m2 plus 50 ekstra
                    antalScrews = ((cm2 / 100) * 20) + 50;
                    //length 110 cm * width 61 cm = 6710cm2
                    antal = Math.ceil(cm2 / 6710);
                    p = new Product(64, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } //on each side of the carport we add 20 cm to the length or width
                else if (roofMaterial.equals("Trapeztag Boelgeplade") && product.getId() == 65) {
                    cm2 = ((width + 40) * (length + 40));
                    //20 screws per m2 plus 50 ekstra
                    antalScrews = ((cm2 / 100) * 20) + 50;
                    //length 109 cm * width 118 cm = 12862cm2
                    antal = Math.ceil(cm2 / 12862);
                    p = new Product(65, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }

            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();

        }
    }

    public Product calcAntalPointedRoof(double length, double width, double degree, String roofMaterial, List allProducts) {

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null || roofMaterial == null || roofMaterial.equals("")) {
            throw new NullPointerException();
        }

        width = CalcPointedRoofTriangle.CalcHypotesen(length, width, degree);
        List<Product> productList = allProducts;
        Product p = null;
        double tagstenCm2;
        double antal; // antal tagpap

        try {
            double roofCm2 = (length * width) * 2; // quadratcentimeter
            roofCm2 = (width * length);
            for (Product product : productList) {
                if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (width % 60) == 0) {
                    antal = Math.ceil(roofCm2 / 45000);
                    p = new Product(40, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } else if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (roofCm2 % 80000) > 1) {
                    antal = Math.ceil(roofCm2 / 50000);
                    p = new Product(41, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } else if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (roofCm2 % 80000) < (roofCm2 % 50000)) {
                    antal = Math.ceil(roofCm2 / 80000);
                    p = new Product(39, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                    //on each side of the carport we add 20 cm to the length or width
                } else if (roofMaterial.equals("Tagsten") && product.getId() == 66) {
                    tagstenCm2 = 40 * 24;
                    antal = Math.ceil(roofCm2 / tagstenCm2);
                    p = new Product(64, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }

            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();

        }
    }

    public int calcAntalScrews() {
        return (int) antalScrews;
    }

}
