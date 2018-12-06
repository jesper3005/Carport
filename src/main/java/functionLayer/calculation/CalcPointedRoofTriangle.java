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

        double b;
        double sinC = 180 - (2 * degree);

        b = (c * Math.sin(25 * (Math.PI / 180))) / Math.sin(sinC * (Math.PI / 180));

        return b;

    }

    public static double CalcArealTriangle(double length, double c, double degree) {

        double b = CalcArealTriangle(length, c, degree);
        double h = ((b + b + c) / 2) / (1/2) * c;
        double A = (1/2) * h * c;
        return A;

    }
}
