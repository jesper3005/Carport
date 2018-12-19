/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer.calculation;

import functionLayer.LogicFacade;
import functionLayer.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class CarportPointedRoofProductListe {

    private  List<Product> list = LogicFacade.getAllProductsFromDatabase();
    private  CalcBattens battens = new CalcBattens();
    private  CalcBeam beam = new CalcBeam();//rem
    private  CalcRoof roof = new CalcRoof();
    private  CalcPoles poles = new CalcPoles();//stolper
    private  CalcNails nail = new CalcNails(); //søm
    private  CalcAngleBracket angleBracket = new CalcAngleBracket();//vinkelbeslag
    private  CalcScrew screw = new CalcScrew();//skrue
    private  CalcOuterLayerOfShed shedOuterLayer = new CalcOuterLayerOfShed();
    private  CalcShedSkeletton shed_InnerLayer = new CalcShedSkeletton();
    private  CalcLøsholt løsholdt = new CalcLøsholt();
    private  CalcFrontAndBackBeklædning arealTriangleBackAndFront = new CalcFrontAndBackBeklædning();

    private  Product pBattens;
    private  Product pBeam;
    private  Product pRoof;
    private  Product pPoles;
    private  Product pshed_innerLayer;
    private  Product pOuterLayer;
    private  Product pLøsholdt;
    private  Product pArealTriangleBackAndFront;


    public List<Product> carportCalculaterPointedRoof(double length, double width, double degree, String roofMaterial) {
        
        if (length <= 0 || width <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }
        if (roofMaterial.isEmpty()) {
            throw new NullPointerException();
        }

        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        try {
            //Objekter Af Carport part calculations
            pBattens = battens.calcAntalPointedRoof(length, width, degree, list);
            pBeam = beam.calcAntal(length, width, list);
            pRoof = roof.calcAntalPointedRoof(length, width, degree, roofMaterial, list);
            pPoles = poles.calcAntal(length, width, list);
            pLøsholdt = løsholdt.calcAntalPointedRoof(length, width, degree, list);
            pArealTriangleBackAndFront = arealTriangleBackAndFront.calcAntal(length, width, degree, list);
//
//            //4 nails per battens ('36', 'NKT FIRKANT SØM 1,6X25MM VARMFORZINKET', 'søm', '36', '0', '0', '0')
            stykliste.add(nail.calcAntal_25mm_Varmforzinket(pPoles.getQty(), list));
//            /*
//            2 angle bracket per pole
//            4 angle bracket per beam
//             */
            double antal = ((pPoles.getQty() * 2) + (pBeam.getQty() * 4));
            stykliste.add(angleBracket.calcAntal(antal, list));
//            //6 screws per angle bracket ('33', 'NKT SPUN+ SKRUE UHJ 3,5X30MM TORX ELFORZINKET', 'skrue', '36', '0', '0', '0')
            stykliste.add(screw.calcAntal_3komma5X30MM(antal, list));
//
            stykliste.add(pBattens);
            stykliste.add(pBeam);
            stykliste.add(pRoof);
            stykliste.add(pPoles);
            stykliste.add(pLøsholdt);
            stykliste.add(pArealTriangleBackAndFront);
            stykliste.add(beam.calcAntalPointedRoofTOP(length, width, list));

            return stykliste;
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CarportPointedRoofProductListe.class.getName());
        }
        return null;

    }

    public List<Product> carportCalculaterPointedRoofIncludingShed(double length, double width, double degree, double shedLength, double shedWidth, String roofMaterial) {
        
        if (length <= 0 || width <= 0 || degree <= 0) {
            throw new IllegalArgumentException();
        }
        if (roofMaterial.isEmpty()) {
            throw new NullPointerException();
        }

        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        try {
            //Objekter Af Carport part calculations

            pBattens = battens.calcAntalPointedRoof(length, width, degree, list);
            pBeam = beam.calcAntal(length, width, list);
            System.out.println(roofMaterial + "carportcalculator");
            pRoof = roof.calcAntalPointedRoof(length, width, degree, roofMaterial, list);
            pPoles = poles.calcAntal(length, width, list);
            pLøsholdt = løsholdt.calcAntalPointedRoof(length, width, degree, list);
            pArealTriangleBackAndFront = arealTriangleBackAndFront.calcAntal(length, width, degree, list);

            
            //4 nails per battens ('36', 'NKT FIRKANT SØM 1,6X25MM VARMFORZINKET', 'søm', '36', '0', '0', '0')
            stykliste.add(nail.calcAntal_25mm_Varmforzinket(pPoles.getQty(), list));
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
            stykliste.add(pPoles);
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
            System.out.println(e.getMessage() +" "+ CarportPointedRoofProductListe.class.getName());

        }
        return null;

    }

}
