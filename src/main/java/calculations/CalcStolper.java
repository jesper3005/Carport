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
public class CalcStolper implements icalculator {

    @Override
    public double calcAntal(int length, int width) {
        int antal = 0;
        if (length <= 450) {
            antal = 4;
        } else if (length > 450) {
            antal = 6;
        }
        return antal;
    }

    @Override
    public double calcPrice(double antal, double price) {
        double total = antal * price;
        return total;
    }
}
