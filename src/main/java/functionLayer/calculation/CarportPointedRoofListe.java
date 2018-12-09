/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import dbAccess.ProductMapper;
import functionLayer.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CarportPointedRoofListe {

    private ProductMapper pm = new ProductMapper();
    private List<Product> list = pm.allProducts();
    private CalcBattens battens = new CalcBattens();
    private CalcBeam beam = new CalcBeam();//rem
    private CalcStern stern = new CalcStern();
    private CalcPoles poles = new CalcPoles();//stolper
    private CalcNails nail = new CalcNails(); //søm
    private CalcAngleBracket angleBracket = new CalcAngleBracket();//vinkelbeslag
    private CalcScrew screw = new CalcScrew();//skrue
    private CalcOuterLayerOfShed shedOuterLayer = new CalcOuterLayerOfShed();
    private CalcShedSkeletton shed_InnerLayer = new CalcShedSkeletton();
    private CalcLøsholt løsholdt = new CalcLøsholt();
    private CalcFrontAndBackBeklædning arealTriangleBackAndFront = new CalcFrontAndBackBeklædning();

    private Product pBattens;
    private Product pBeam;
    private Product pPoles;
    private Product pSternOver;
    private Product pSternMellem;
    private Product pSternUnder;
    private Product pshed_innerLayer;
    private Product pOuterLayer;
    private Product pLøsholdt;
    private Product pArealTriangleBackAndFront;

    public List<Product> carportCalculaterPointedRoof(double length, double width, double degree, String roofMaterial) {

       

        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        try {
            //Objekter Af Carport part calculations
            pBeam = beam.calcAntal(length, width, list);
            pPoles = poles.calcAntal(length, width, list);
            pBattens = battens.calcAntalPointedRoof(length, width, degree, list);
            pLøsholdt = løsholdt.calcAntalPointedRoof(length, width, degree, list);
            pArealTriangleBackAndFront = arealTriangleBackAndFront.calcAntal(length, width, degree, list);

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

            stykliste.add(pBeam);
            stykliste.add(pPoles);
            stykliste.add(pBattens);
            stykliste.add(pLøsholdt);
            stykliste.add(pArealTriangleBackAndFront);
            stykliste.add(beam.calcAntalPointedRoofTOP(length, width, list));

            return stykliste;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;

    }

    public List<Product> carportCalculaterPointedRoofIncludingShed(double length, double width, double degree, double shedLength, double shedWidth, String roofMaterial) {
        
        

        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        try {
            //Objekter Af Carport part calculations

            pBeam = beam.calcAntal(length, width, list);
            pPoles = poles.calcAntal(length, width, list);
            pBattens = battens.calcAntalPointedRoof(length, width, degree, list);
            pLøsholdt = løsholdt.calcAntalPointedRoof(length, width, degree, list);
            pArealTriangleBackAndFront = arealTriangleBackAndFront.calcAntal(length, width, degree, list);

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

            stykliste.add(pBeam);
            stykliste.add(pPoles);
            stykliste.add(pBattens);
            stykliste.add(pLøsholdt);
            stykliste.add(pArealTriangleBackAndFront);
            stykliste.add(beam.calcAntalPointedRoofTOP(length, width, list));
            //
            stykliste.add(shed_InnerLayer.calcAntalHorizontal(shedLength, shedWidth, list));
            stykliste.add(shed_InnerLayer.calcAntalVerticalFrontAndBack(shedLength, shedWidth, list));
            stykliste.add(shed_InnerLayer.calcAntalVerticalLeftAndRight(shedLength, shedWidth, list));
            //
            stykliste.add(shedOuterLayer.calAntal(length, width, list));

            return stykliste;
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return null;

    }

}
