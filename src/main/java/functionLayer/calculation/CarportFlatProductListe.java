/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.calculation.CalcStolper;
import functionLayer.calculation.CalcStern;
import functionLayer.calculation.CalcRoof;
import functionLayer.calculation.CalcRem;
import functionLayer.calculation.CalcLaegter;
import functionLayer.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CarportFlatProductListe {
    
    
    public List<Product> CarportCalculaterFlatRoof(double length, double width, String roofMaterial) {

        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        try {
            //Objekter Af Carport part calculations
            CalcLaegter laegter = new CalcLaegter();
            CalcRem rem = new CalcRem();
            CalcRoof roof = new CalcRoof();
            CalcStern stern = new CalcStern();
            CalcStolper stolper = new CalcStolper();

            stykliste.add(laegter.calcAntal(length, width));
            //Product laegterTest = laegter.calcAntal(length, width);
            //soem.calcAntal(laegterTest.getQty())
            //
            stykliste.add(rem.calcAntal(length, width));
            
            //
            stykliste.add(roof.calcAntal(length, width, roofMaterial));
            
            //
            stykliste.add(stern.calcAntalOverbrædt(length, width));
            stykliste.add(stern.calcAntalMellembrædt(length, width));
            stykliste.add(stern.calcAntalUnderbrædt(length, width));
            //
            stykliste.add(stolper.calcAntal(length, width));
            //
            
            
            
            return stykliste;
        } catch (Exception e) {
            e.getMessage();
        }
        return stykliste;

    }
}
