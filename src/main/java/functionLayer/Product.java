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
    
    int id;
    String name, category;
    int price, length, width, height;    

    public Product(int id, String name, String category, int price, int length, int width, int height) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }
}
