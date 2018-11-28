/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import functionLayer.calculation.CarportFlatProductListe;
import dbAccess.ProductMapper;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class LogicFacade {

    public static List<Product> CarportCalculaterFlatRoof(double length, double width, String roofMaterial) {
        CarportFlatProductListe cfp = new CarportFlatProductListe();
        List list = cfp.CarportCalculaterFlatRoof(length, width, roofMaterial);
        return list;
    }

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

}
