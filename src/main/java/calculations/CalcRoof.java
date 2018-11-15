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
public class CalcRoof {
    
    public double CalcRoofAmount(int width, int length) {
        double antal = 0;
        int TagPap = 8;
        width = 240 / 10;
        length = 420 / 10;
        double Circ = width * length;
        antal = Math.ceil(Circ / TagPap);
        return antal;
    }
    
}
