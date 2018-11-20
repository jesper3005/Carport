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
public class CalcTag implements icalculator {

    // flat tag lavede med tagpap
    @Override
    public double calcAntal(double length, double width) {
        double antal = 0; // antal tagpap
        double cm2 = 0; // quadratmeter
        int TagPap = 80000; // hardt codet tagpappe som er 8m lang det 80000 cm2
        cm2 = (width * length);
        antal = Math.ceil(cm2 / TagPap);
        return antal;
    }

    @Override
    public double calcPrice(double antal, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
