/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import calculations.CalcLaegter;
import calculations.CalcRem;
import calculations.CalcTag;
import calculations.CalcStern;
import calculations.CalcStolper;
import dbAccess.ProductMapper;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class LogicFacade {
    
    public static int[] StringArrayToIntArray(String[] s){
    int[] arrayOfInteger = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arrayOfInteger[i] = Integer.parseInt(s[i]);
        }
        return arrayOfInteger;
}
    public static List<Integer> StringListToIntList(List<String> s){
    List<Integer> arrayOfInteger = new ArrayList<>();
        for (String string : s) {
            arrayOfInteger.add(Integer.valueOf(string));
        }
        return arrayOfInteger;
}

    public static double roundDoubleToTwoDecimalPoints(double value) {        
        DecimalFormat df2 = new DecimalFormat(",##");
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

    public static List<Product> CarportCalculater(double length, double width) {
        //Objekter Af Carport part calculations
        CalcLaegter laegter = new CalcLaegter();
        CalcRem rem = new CalcRem();
        CalcTag roof = new CalcTag();
        CalcStern stern = new CalcStern();
        CalcStolper stolper = new CalcStolper();
        // List with all proucts from our product linje. Ordered by length of "rem"
        List<Product> allProduktsFromDatabase = getAllProductsFromDatabase();
        // List included everything needed to build the requestet carport
        List<Product> stykliste = new ArrayList<>();

        for (Product produkt : allProduktsFromDatabase) {
            if (produkt.getCategory().equals("lægte")) {
                produkt.setQty(laegter.calcAntal(length, width));
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getCategory().equals("rem") && produkt.getLength() == length) {
                produkt.setQty(rem.calcAntal(length, width));
                produkt.getPriceLine();
                stykliste.add(produkt);

            }
            if (produkt.getCategory().equals("tagpap") && produkt.getLength() == 800) {
                produkt.setQty(roof.calcAntal(length, width));
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getCategory().equals("stern") && produkt.getId() == 42) {
                produkt.setQty(stern.calcAntal(length, width));
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getCategory().equals("stolpe") && produkt.getLength() == 390) {
                produkt.setQty(stolper.calcAntal(length, width));
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getCategory().equals("skrue") && produkt.getId() == 32) {
                double antalRem, antalStern;
                antalRem = (rem.calcAntal(length, width) * 8);
                antalStern = (stern.calcAntal(length, width) * 6);//per stern 6 skruer
                produkt.setQty(antalRem + antalStern);
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getCategory().equals("søm") && produkt.getId() == 36) {
                double antalLægte;
                antalLægte = (laegter.calcAntal(length, width) * 4);//4 søm per lægte
                produkt.setQty(antalLægte);
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getId() == 27) {//vinkelbeslag
                double antalRem;
                antalRem = (rem.calcAntal(length, width) * 4);//4 vinkelbeslag per rem
                produkt.setQty(antalRem);
                produkt.getPriceLine();
                stykliste.add(produkt);
            }

        }
        return stykliste;

    }
}
