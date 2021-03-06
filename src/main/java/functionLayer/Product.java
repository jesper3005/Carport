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
    private String productName;
    private String category;
    private double price;
    private double qty;
    private double priceLine;
    private double length;
    private double width;
    private double height;
    private double totalPriceOfOrder;

    //default constructor
    public Product() {
        this(0, "default", "default", 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    //constructoren is used in ProductMapper orderByLengthRem()
    public Product(String category, double length) {
        this.category = category;
        this.length = length;
    }

    //constructor is used in AddProduct PresentaionLayer
    public Product(String productName, String category, double price, double length, double width, double height) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    //constructor is used in ProductMapper in  dbAccess pack. in method allProducts
    public Product(int id, String productName, String category, double price, double length, double width, double height) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    //constructor is used in ProductMapper in method getProductById and in functionLayer.calculation for passing a product through a method
    public Product(int id, String productName, String category, double price, double qty, double priceLine, double length, double width, double height) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.qty = qty;
        this.priceLine = price * qty;
        this.length = length;
        this.width = width;
        this.height = height;
        this.totalPriceOfOrder = totalPriceOfOrder;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", productName=" + productName + ", category=" + category + ", price=" + price + ", qty=" + qty + ", priceLine=" + priceLine + ", length=" + length + ", width=" + width + ", height=" + height + '}';
    }

    public double getPriceLine() {
        //return this.getPrice() * qty;
        return LogicFacade.roundDoubleToTwoDecimalPoints(this.priceLine);
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

    public String getProductName() {
        return productName;
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
