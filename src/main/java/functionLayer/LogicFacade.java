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

/**
 *
 * @author oerte
 */
public class LogicFacade {
    
    public static ArrayList<Produkt> stykliste = new ArrayList<>();
    
    public static void Stykliste(double length, double width){
        //calculation objekter
        CalcLaegter laegter = new CalcLaegter();
        CalcRem rem = new CalcRem();
        CalcRoof roof = new CalcRoof();
        CalcStern stern = new CalcStern();
        CalcStolper stolper = new CalcStolper();
        //
        laegter.calcAntal(length, width);
        rem.calcAntal(length, width);
        roof.calcAntal(length, width);
        stern.calcAntal(length, width);
        stolper.calcAntal(length, width);
        
        
        
        
        
    }
    
            
}
