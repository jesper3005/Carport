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
public class Product {

    private int id;
    private String produktName;
    private String category;
    private double price;
    private double qty;
    private double priceLine;
    private int length;
    private int width;
    private int height;
    private double totalPriceOfOrder;

    public Product(int id, String produktName, String category, double price, int length, int width, int height) {
        this.id = id;
        this.produktName = produktName;
        this.category = category;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Product(int id, String produktName, String category, double price, double qty, double priceLine, int length, int width, int height) {
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
        return this.priceLine = this.price * this.qty;
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

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
