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
import functionLayer.calculation.CalcBattens;
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
            CalcBattens battens = new CalcBattens();
            CalcRem rem = new CalcRem();
            CalcRoof roof = new CalcRoof();
            CalcStern stern = new CalcStern();
            CalcStolper stolper = new CalcStolper();
            CalcNails nail = new CalcNails();

            Product pBattens = battens.calcAntal(length, width);//lægter
            Product pRem = rem.calcAntal(length, width);
            Product pRoof = roof.calcAntal(length, width, roofMaterial);
            Product pStolper = stolper.calcAntal(length, width);
            Product pSternOver = stern.calcAntalOverbrædt(length, width);
            Product pSternMellem = stern.calcAntalMellembrædt(length, width);
            Product pSternUnder = stern.calcAntalUnderbrædt(length, width);
            
            //4 nails per battens ('36', 'NKT FIRKANT SØM 1,6X25MM VARMFORZINKET', 'søm', '36', '0', '0', '0')
            stykliste.add(nail.calcAntal_25mm_Varmforzinket(pStolper.getQty()));

            stykliste.add(pBattens);
            stykliste.add(pRem);
            stykliste.add(pRoof);
            stykliste.add(pSternOver);
            stykliste.add(pSternMellem);
            stykliste.add(pSternUnder);
            stykliste.add(pStolper);

            return stykliste;
        } catch (Exception e) {
            e.getMessage();
        }
        return stykliste;

    }

    public List<Product> CarportCalculaterFlatRoofIncludingShed(double length, double width, double shedLength, double shedWidth, String roofMaterial) {

        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        try {
             //Objekter Af Carport part calculations
            CalcBattens battens = new CalcBattens();
            CalcRem rem = new CalcRem();
            CalcRoof roof = new CalcRoof();
            CalcStern stern = new CalcStern();
            CalcStolper stolper = new CalcStolper();
            CalcShedSkeletton shedSkeletton = new CalcShedSkeletton();

            Product pBattens = battens.calcAntal(length, width);
            Product pRem = rem.calcAntal(length, width);
            Product pRoof = roof.calcAntal(length, width, roofMaterial);
            Product pStolper = stolper.calcAntal(length, width);
            Product pSternOver = stern.calcAntalOverbrædt(length, width);
            Product pSternMellem = stern.calcAntalMellembrædt(length, width);
            Product pSternUnder = stern.calcAntalUnderbrædt(length, width);
            
            //4 nails per lægte

            stykliste.add(pBattens);
            stykliste.add(pRem);
            stykliste.add(pRoof);
            stykliste.add(pSternOver);
            stykliste.add(pSternMellem);
            stykliste.add(pSternUnder);
            stykliste.add(pStolper);
            //
            stykliste.add(shedSkeletton.calcAntalHorizontal(shedLength, shedWidth));
            stykliste.add(shedSkeletton.calcAntalVerticalFrontAndBack(shedLength, shedWidth));
            stykliste.add(shedSkeletton.calcAntalVerticalLeftAndRight(shedLength, shedWidth));

            return stykliste;
        } catch (Exception e) {
            e.getMessage();
        }
        return stykliste;

    }
}
