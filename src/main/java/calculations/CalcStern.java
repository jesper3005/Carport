/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculations;

/**
 *
 * @author oerte
 */
public class CalcStern implements icalculator {

    @Override
    public double calcAntal(double length, double width) {
        double totalLength = ((2 * length) + (2 * width));
        return Math.ceil(totalLength / 540);
    }

    @Override
    public double calcPrice(double antal, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
