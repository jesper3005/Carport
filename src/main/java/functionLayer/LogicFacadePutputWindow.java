/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import java.util.ArrayList;
import calculations.CalcLaegter;
import calculations.CalcRem;
import calculations.CalcTag;
import calculations.CalcStern;
import calculations.CalcStolper;
import dbAccess.ProductMapper;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author oerte
 */
public class LogicFacadePutputWindow {

    public static void main(String[] args) {
        ProductMapper pm = new ProductMapper();
        //
        List<Product> allProduktsFromDatabase = pm.products();
        List<Product> stykliste = new ArrayList<>();
        //
        CalcLaegter laegter = new CalcLaegter();
        CalcRem rem = new CalcRem();
        CalcTag roof = new CalcTag();
        CalcStern stern = new CalcStern();
        CalcStolper stolper = new CalcStolper();
        //
        double priceOfOrder = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Length of carport:");
        double length = sc.nextDouble();
        System.out.println("Width of carport");
        double width = sc.nextDouble();

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
        for (Product produkt : stykliste) {
            System.out.println(produkt);
            priceOfOrder += produkt.getTotalPriceOfOrder();
        }
        
        for (Product produkt : allProduktsFromDatabase) {
            if(produkt.getCategory().equals("rem")){
                System.out.println(produkt.getLength());
            }
        }
        System.out.println("Total Price: " + priceOfOrder);
    }

}
