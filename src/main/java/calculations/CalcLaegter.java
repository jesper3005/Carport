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
        double antalLaegterLength = 0;
        double totalMeterLægter = 0;
        double antal = 0;
        //En lægte per 0.5 meter (50 cm)
        antalLaegterLength = length / 50;//50 cm
        // Hvad mange meter lægter skal vi brug til hele carportens bredje
        totalMeterLægter = antalLaegterLength * width;//
        antal = Math.ceil((totalMeterLægter / 540)+ antalLaegterLength); //
        return antal;
    }

    @Override
    public double calcPrice(double antal, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
