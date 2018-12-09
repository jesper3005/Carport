/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

/**
 *
 * @author oerte
 */
public class CalcPointedRoofTriangle {

    public static double CalcHypotesen(double length, double c, double degree) {

        if (length <= 0 || c <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }

        double b = 0;
        try {
            double sinC = 180 - (2 * degree);

            b = (c * Math.sin(25 * (Math.PI / 180))) / Math.sin(sinC * (Math.PI / 180));
            return b;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;

    }

    public static double CalcArealTriangle(double length, double c, double degree) {

        if (length <= 0 || c <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }

        try {
            double b = CalcArealTriangle(length, c, degree);
            double h = ((b + b + c) / 2) / (1 / 2) * c;
            double A = (1 / 2) * h * c;
            return A;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;

    }
}
