/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import java.util.ArrayList;
import calculations.CalcLaegter;
import calculations.CalcRem;
import calculations.CalcRoof;
import calculations.CalcStern;
import calculations.CalcStolper;
import dbAccess.ProduktMapper;
import java.util.Scanner;

/**
 *
 * @author oerte
 */
public class LogicFacade {

    public static void main(String[] args) {
        ProduktMapper pm = new ProduktMapper();
        //
        ArrayList<Produkt> allProduktsFromDatabase = pm.produkts();
        ArrayList<Produkt> stykliste = new ArrayList<>();
        //
        CalcLaegter laegter = new CalcLaegter();
        CalcRem rem = new CalcRem();
        CalcRoof roof = new CalcRoof();
        CalcStern stern = new CalcStern();
        CalcStolper stolper = new CalcStolper();
        //
        double priceOfOrder;

        Scanner sc = new Scanner(System.in);
        System.out.println("Length of carport:");
        double length = sc.nextDouble();
        System.out.println("Width of carport");
        double width = sc.nextDouble();

        for (Produkt produkt : allProduktsFromDatabase) {
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

        }
        for (Produkt produkt : stykliste) {
            System.out.println(produkt);
            
        }

    }

}
