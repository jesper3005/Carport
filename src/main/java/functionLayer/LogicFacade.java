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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oerte
 */
public class LogicFacade {

    public static ProductMapper pm = new ProductMapper();

    public static List<Product> getAllProductsFromDatabase() {
        List<Product> produktList = pm.products();
        return produktList;
    }

    public static double totalPriceOfCarport(List<Product> stykliste) {
        double totalPriceOfCarport = 0;
        for (Product produkt : stykliste) {
            totalPriceOfCarport += produkt.getTotalPriceOfOrder();
        }
        return totalPriceOfCarport;
    }

    public static List<Product> CarportCalculater(double length, double width) {
        // Mapper who returns all products from our product line
        ProductMapper pm = new ProductMapper();
        //Objekter Af Carport part calculations
        CalcLaegter laegter = new CalcLaegter();
        CalcRem rem = new CalcRem();
        CalcRoof roof = new CalcRoof();
        CalcStern stern = new CalcStern();
        CalcStolper stolper = new CalcStolper();
        // List with all proucts from our product linje. Ordered by length of "rem"
        List<Product> allProduktsFromDatabase = pm.products();
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
            if (produkt.getCategory().equals("tagpap") && produkt.getLength() == 8000) {
                produkt.setQty(roof.calcAntal(length, width));
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getCategory().equals("stern")) {
                produkt.setQty(stern.calcAntal(length, width));
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getCategory().equals("stolpe") && produkt.getLength() == 3900) {
                produkt.setQty(stolper.calcAntal(length, width));
                produkt.getPriceLine();
                stykliste.add(produkt);
            }
            if (produkt.getCategory().equals("skrue") && produkt.getPrice() == 3600) {
                produkt.setQty(rem.calcAntal(length, width) * 8);
                produkt.getPriceLine();
                stykliste.add(produkt);
            }

        }
        return stykliste;

    }
}
