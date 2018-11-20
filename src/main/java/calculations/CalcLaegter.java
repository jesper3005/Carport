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
public class CalcLaegter implements icalculator {

    @Override
    public double calcAntal(double length, double width) {
        length = length / 100; //from cm til meters
        width = width / 100;
        double antalLaegterLength = 0;
        double totalMeterLægter = 0;
        double antal = 0;
        antalLaegterLength = Math.ceil(length / 0.5);
        totalMeterLægter = Math.ceil(antalLaegterLength * width);//12 meter
        antal = Math.ceil(totalMeterLægter / 5.4) + antalLaegterLength; //
        return antal;
    }

    @Override
    public double calcPrice(double antal, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
