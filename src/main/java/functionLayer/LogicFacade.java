/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import calculations.CalcLaegter;
import calculations.CalcRem;
import calculations.CalcRoof;
import calculations.CalcStern;
import calculations.CalcStolper;
import dbAccess.ProductMapper;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class LogicFacade {

    public static int[] StringArrayToIntArray(String[] s) {
        int[] arrayOfInteger = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arrayOfInteger[i] = Integer.parseInt(s[i]);
        }
        return arrayOfInteger;
    }

    public static List<Integer> StringListToIntList(List<String> s) {
        List<Integer> arrayOfInteger = new ArrayList<>();
        for (String string : s) {
            arrayOfInteger.add(Integer.valueOf(string));
        }
        return arrayOfInteger;
    }

    public static double roundDoubleToTwoDecimalPoints(double value) {
        DecimalFormat df2 = new DecimalFormat(".##");
        return Double.parseDouble(df2.format(value));

    }

    public static List<Product> getAllProductsFromDatabase() {
        ProductMapper pm = new ProductMapper();
        List<Product> produktList = pm.allProducts();
        return produktList;
    }

    public static double totalPriceOfCarport(List<Product> stykliste) {
        double totalPriceOfCarport = 0;
        for (Product produkt : stykliste) {
            totalPriceOfCarport += produkt.getTotalPriceOfOrder();
        }
        return roundDoubleToTwoDecimalPoints(totalPriceOfCarport);
    }
    public static void main(String[] args) {
        CarportCalculaterFlatRoof(240, 240, "Tagpap");
    }
    public static List<Product> CarportCalculaterFlatRoof(double length, double width, String roofMaterial) {

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
            //stykliste.add(laegter.calcAntalSøm());
            //
            stykliste.add(rem.calcAntal(length, width));
            //stykliste.add(rem.calcAntalVinkelbeslag(rem.calcAntal(length, width).getQty()));
            //stykliste.add(rem.calcAntalSkruer(rem.calcAntal(length, width).getQty()));
            //
            stykliste.add(roof.calcAntal(length, width, roofMaterial));
//            stykliste.add(roof.calAntalSkruer());
            
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
