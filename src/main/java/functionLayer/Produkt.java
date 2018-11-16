/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

/**
 *
 * @author Jesper
 */
public class Produkt {
    
    private int id;
    private String produktName;
    private String category;
    private double antal;
    private double price;
    private double length;
    private double width;
    private double height;

    public Produkt(int id, String produktName, String category, double antal, double price, double length, double width, double height) {
        this.id = id;
        this.produktName = produktName;
        this.category = category;
        this.antal = antal;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Produkt{" + "id=" + id + ", produktName=" + produktName + ", category=" + category + ", antal=" + antal + ", price=" + price + ", length=" + length + ", width=" + width + ", height=" + height + '}';
    }

    

    
    
    
    
}
