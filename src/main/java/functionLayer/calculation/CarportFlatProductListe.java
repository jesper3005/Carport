/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import dbAccess.ProductMapper;
import functionLayer.calculation.CalcPoles;
import functionLayer.calculation.CalcStern;
import functionLayer.calculation.CalcRoof;
import functionLayer.calculation.CalcBeam;
import functionLayer.calculation.CalcBattens;
import functionLayer.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CarportFlatProductListe {
    

    private ProductMapper pm = new ProductMapper();
    private List<Product> list = pm.allProducts();
    private CalcBattens battens = new CalcBattens();
    private CalcBeam beam = new CalcBeam();//rem
    private CalcRoof roof = new CalcRoof();
    private CalcStern stern = new CalcStern();
    private CalcPoles poles = new CalcPoles();//stolper
    private CalcNails nail = new CalcNails(); //søm
    private CalcAngleBracket angleBracket = new CalcAngleBracket();//vinkelbeslag
    private CalcScrew screw = new CalcScrew();//skrue
    private CalcOuterLayerOfShed shedOuterLayer = new CalcOuterLayerOfShed();
    private CalcShedSkeletton shed_InnerLayer = new CalcShedSkeletton();
    

    private Product pBattens;
    private Product pBeam;
    private Product pRoof;
    private Product pPoles;
    private Product pSternOver;
    private Product pSternMellem;
    private Product pSternUnder;
    private Product pshed_innerLayer;
    private Product pOuterLayer;
    

    public List<Product> carportCalculaterFlatRoof(double length, double width, String roofMaterial) {

        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        try {
            //Objekter Af Carport part calculations
            pBattens = battens.calcAntal(length, width, list);//lægter
            pBeam = beam.calcAntal(length, width, list);
            pRoof = roof.calcAntal(length, width, roofMaterial, list);
            pPoles = poles.calcAntal(length, width, list);
            pSternOver = stern.calcAntalOverbrædt(length, width, list);
            pSternMellem = stern.calcAntalMellembrædt(length, width, list);
            pSternUnder = stern.calcAntalUnderbrædt(length, width, list);

            //20 screws per m2 of roof plus 50 ekstra
            //stykliste.add(screw.calcAntal_3X25MM(roof.calcAntalScrews(), list));
            //4 nails per battens ('36', 'NKT FIRKANT SØM 1,6X25MM VARMFORZINKET', 'søm', '36', '0', '0', '0')
            stykliste.add(nail.calcAntal_25mm_Varmforzinket(pPoles.getQty(), list));
            //4 screws per stern ('32', 'NKT FRANSK SKRUE 8X120MM VFZ 50 STK/PK', 'skrue', '29.9', '0', '0', '0')
            double antalScrewsStern = Math.ceil((pSternOver.getQty() + pSternMellem.getQty() + pSternUnder.getQty()) / 50);
            stykliste.add(screw.calcAntal_8X120MM_50STK_Pakke((antalScrewsStern), list));
            /*
            2 angle bracket per pole
            4 angle bracket per beam
             */
            double antal = ((pPoles.getQty() * 2) + (pBeam.getQty() * 4));
            stykliste.add(angleBracket.calcAntal(antal, list));
            //6 screws per angle bracket ('33', 'NKT SPUN+ SKRUE UHJ 3,5X30MM TORX ELFORZINKET', 'skrue', '36', '0', '0', '0')
            stykliste.add(screw.calcAntal_3komma5X30MM(antal, list));
            
            

            stykliste.add(pBattens);
            stykliste.add(pBeam);
            stykliste.add(pRoof);
            stykliste.add(pSternOver);
            stykliste.add(pSternMellem);
            stykliste.add(pSternUnder);
            stykliste.add(pPoles);

            return stykliste;
        } catch (Exception e) {
            e.getMessage();
        }
        return stykliste;

    }

    public List<Product> carportCalculaterFlatRoofIncludingShed(double length, double width, double shedLength, double shedWidth, String roofMaterial) {

        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        try {
            //Objekter Af Carport part calculations

            pBattens = battens.calcAntal(length, width, list);//lægter
            pBeam = beam.calcAntal(length, width, list);
            pRoof = roof.calcAntal(length, width, roofMaterial, list);
            pPoles = poles.calcAntal(length, width, list);
            pSternOver = stern.calcAntalOverbrædt(length, width, list);
            pSternMellem = stern.calcAntalMellembrædt(length, width, list);
            pSternUnder = stern.calcAntalUnderbrædt(length, width, list);

            //20 screws per m2 of roof plus 50 ekstra
            //stykliste.add(screw.calcAntal_3X25MM(roof.calcAntalScrews(), list));
            //4 nails per battens ('36', 'NKT FIRKANT SØM 1,6X25MM VARMFORZINKET', 'søm', '36', '0', '0', '0')
            stykliste.add(nail.calcAntal_25mm_Varmforzinket(pPoles.getQty(), list));
            //4 screws per stern ('32', 'NKT FRANSK SKRUE 8X120MM VFZ 50 STK/PK', 'skrue', '29.9', '0', '0', '0')
            double antalScrewsStern = Math.ceil((pSternOver.getQty() + pSternMellem.getQty() + pSternUnder.getQty()) / 50);
            stykliste.add(screw.calcAntal_8X120MM_50STK_Pakke((antalScrewsStern), list));
            /*
            2 angle bracket per pole
            4 angle bracket per beam
             */
            double antal = ((pPoles.getQty() * 2) + (pBeam.getQty() * 4));
            stykliste.add(angleBracket.calcAntal(antal, list));
            //6 screws per angle bracket ('33', 'NKT SPUN+ SKRUE UHJ 3,5X30MM TORX ELFORZINKET', 'skrue', '36', '0', '0', '0')
            stykliste.add(screw.calcAntal_3komma5X30MM(antal, list));
            
            //add all from doorList to styklist
            List<Product> doorList = shedOuterLayer.calcAntalDoor(list);
            for (Product product : doorList) {
                stykliste.add(product);
            }

            stykliste.add(pBattens);
            stykliste.add(pBeam);
            stykliste.add(pRoof);
            stykliste.add(pSternOver);
            stykliste.add(pSternMellem);
            stykliste.add(pSternUnder);
            stykliste.add(pPoles);
            //
            stykliste.add(shed_InnerLayer.calcAntalHorizontal(shedLength, shedWidth, list));
            stykliste.add(shed_InnerLayer.calcAntalVerticalFrontAndBack(shedLength, shedWidth, list));
            stykliste.add(shed_InnerLayer.calcAntalVerticalLeftAndRight(shedLength, shedWidth, list));
            //
            stykliste.add(shedOuterLayer.calAntal(length, width, list));

            return stykliste;
        } catch (Exception e) {
            e.getMessage();
        }
        return stykliste;

    }
}