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
public class CalcRem implements icalculator {

    @Override
    public double calcAntal(double length, double width) {
        int antal = 0;
        if (width >= 510) {
            antal = 5;
        } else {
            antal = 4;
        }
        return antal;
    }

    // instead of double price we need id from produkt where we get the actual price
    @Override
    public double calcPrice(double antal, double price) {
        double total = antal * price;
        return total;
    }

}
