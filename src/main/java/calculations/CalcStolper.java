/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculations;

/**
 *
 * @author Jesper
 */
public class CalcStolper {
      public int calAntalStolper(int length) {
       int antal = 0;
       if (length <= 450) {
           antal = 4;
       } else if (length > 450) {
           antal = 6;
       }
       return antal;
   }


   // instead of double price we need id from produkt where we get the actual price
   public double priceStolper(int antal, double price){
       double total = antal * price;
       return total;
   }
}
