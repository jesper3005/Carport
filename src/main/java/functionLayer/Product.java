/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import java.text.DecimalFormat;

/**
 *
 * @author Jesper
 */
public class Product {

    private int id;
    private String produktName;
    private String category;
    private double price;
    private double qty;
    private double priceLine;
    private double length;
    private double width;
    private double height;
    private double totalPriceOfOrder;

    
    //constructoren is used in ProductMapper orderByLengthRem()
    public Product(String category, double length) {
        this.category = category;
        this.length = length;
    }
    
    
    
    public Product(int id, String produktName, String category, double price, double length, double width, double height) {
        this.id = id;
        this.produktName = produktName;
        this.category = category;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Product(int id, String produktName, String category, double price, double qty, double priceLine, double length, double width, double height) {
        this.id = id;
        this.produktName = produktName;
        this.category = category;
        this.price = price;
        this.qty = qty;
        this.priceLine = priceLine;
        this.length = length;
        this.width = width;
        this.height = height;
        this.totalPriceOfOrder = totalPriceOfOrder;
    }

    @Override
    public String toString() {
        return "Produkt{" + "id=" + id + ", produktName=" + produktName + ", category=" + category + ", price=" + price + ", qty=" + qty + ", priceLine=" + priceLine + ", length=" + length + ", width=" + width + ", height=" + height + '}';
    }

    public double getPriceLine() {
        return LogicFacade.roundDoubleToTwoDecimalPoints(this.priceLine = this.price * this.qty);
    }

    public double getTotalPriceOfOrder() {
        return this.totalPriceOfOrder += this.priceLine;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public int getId() {
        return id;
    }

    public String getProduktName() {
        return produktName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getQty() {
        return qty;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

}
