/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.LogicFacade;

/**
 *
 * @author oerte
 */
public class CalcPointedRoofTriangle {

    public static double CalcKatete(double length, double c, double degree) {

        if (length <= 0 || c <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }

        double b = 0;
        try {
            double sinC = 180 - (2 * degree);

            b = (c * Math.sin(25 * (Math.PI / 180))) / Math.sin(sinC * (Math.PI / 180));
            //b = LogicFacade.roundDoubleToTwoDecimalPoints(b);
            return b;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 0;

    }

    
    /*
    Area of a Triangle --> A = (a+b+c)/2
    
    */
    
    public static double CalcArealTriangle(double length, double width, double degree) {

        if (length <= 0 || width <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }

        try {
            double b = CalcKatete(length, width, degree);
            double A = (b+b+width)/2;
            return A;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;

    }
}
