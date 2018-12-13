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

    public CalcRoof() {
        this.antalScrews = antalScrews;
    }

    public double getAntalScrews() {
        return antalScrews;
    }

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
        double m2 = 0;
        double antal; // antal tagpap

        try {
            cm2 = (width * length);
            for (Product product : productList) {
                if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (width % 60) == 0) {
                    antal = Math.ceil(cm2 / 45000);
                    p = new Product(39, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                    this.antalScrews = 0;
                } else if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (cm2 % 80000) > 1) {
                    antal = Math.ceil(cm2 / 50000);
                    p = new Product(40, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                    this.antalScrews = 0;
                } else if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (cm2 % 80000) < (cm2 % 50000)) {
                    antal = Math.ceil(cm2 / 80000);
                    p = new Product(38, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                    this.antalScrews = 0;
                    //on each side of the carport we add 20 cm to the length or width
                } else if (roofMaterial.equals("Trapeztag PVC Glasklar")) {
                    cm2 = ((width + 40) * (length + 40));
                    m2 = cm2/10000;
                    //20 screws per m2 plus 50 ekstra
                    this.antalScrews = Math.ceil((m2 * 20) + 50);
                    //length 110 cm * width 61 cm = 6710cm2
                    antal = Math.ceil(cm2 / 6710);
                    p = new Product(68, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } //on each side of the carport we add 20 cm to the length or width
                else if (roofMaterial.equals("Trapeztag Boelgeplade")) {
                    cm2 = ((width + 40) * (length + 40));
                    m2 = cm2/10000;
                    //20 screws per m2 plus 50 ekstra
                    this.antalScrews = Math.ceil((m2 * 20) + 50);
                    //length 109 cm * width 118 cm = 12862cm2
                    antal = Math.ceil(cm2 / 12862);
                    p = new Product(69, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }

            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();

        }
    }

    public Product calcAntalPointedRoof(double length, double width, double degree, String roofMaterial, List allProducts) {
        System.out.println(roofMaterial +" calcAntal");

        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        if (allProducts == null || roofMaterial == null || roofMaterial.equals("")) {
            throw new NullPointerException();
        }

        width = CalcPointedRoofTriangle.CalcKatete(length, width, degree);
        width += 20; //on the left and right side we add 20 cm
        List<Product> productList = allProducts;
        Product p = null;
        double tagstenCm2;
        double antal; // antal tagpap

        try {
            double roofCm2 = (length * width) * 2; // quadratcentimeter
            for (Product product : productList) {
                if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (width % 60) == 0) {
                    antal = Math.ceil(roofCm2 / 45000);
                    p = new Product(39, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } else if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (roofCm2 % 80000) > 1) {
                    antal = Math.ceil(roofCm2 / 50000);
                    p = new Product(38, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } else if (roofMaterial.equals("Tagpap") && product.getCategory().equals("tagpap") && (roofCm2 % 80000) < (roofCm2 % 50000)) {
                    antal = Math.ceil(roofCm2 / 80000);
                    p = new Product(40, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                } else if (roofMaterial.equals("Tagsten")) {
                    tagstenCm2 = 40 * 24;
                    antal = Math.ceil(roofCm2 / tagstenCm2);
                    p = new Product(66, product.getProductName(), product.getCategory(), product.getPrice(), antal, product.getPriceLine(), product.getLength(), product.getWidth(), product.getHeight());
                }

            }
            return p;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return p = new Product();

        }
    }

}
