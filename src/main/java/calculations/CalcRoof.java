/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculations;

/**
 *
 * @author Jesper
 */
public class CalcRoof implements icalculator {

    // flat tag lavede med tagpap
    @Override
    public double calcAntal(double length, double width) {
        double antal = 0; // antal stolperne
        double m2 = 0; // quadratmeter
        int TagPap = 8; // hardt codet tagpappe som er 8m lang
        m2 = (width * length) / 10000; // omregning fra cm2 til m2//1 m2 = 10000cm2
        antal = Math.ceil(m2 / TagPap);
        return antal;
    }

    @Override
    public double calcPrice(double antal, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
