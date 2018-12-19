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
    
    /*
    (a/sin(A))  =  (c/sin(C))
    Hvor 
    a = width;
    c = katete
    Sin(A) = 180 - (2 * degree)
    Sin(C) = degree
    
    */
    public static double CalcKatete(double length, double width, double degree) {

        if (length <= 0 || width <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }

        double c = 0;
        try {
            double sinA = 180 - (2 * degree);
            c = (width/Math.sin(sinA * (Math.PI / 180))) * Math.sin(degree * (Math.PI / 180));
            c = LogicFacade.roundDoubleToTwoDecimalPoints(c);
            return c;
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CalcPointedRoofTriangle.class.getName());
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
            System.out.println(e.getMessage() +" "+ CalcPointedRoofTriangle.class.getName());
        }
        return 0;

    }
}
