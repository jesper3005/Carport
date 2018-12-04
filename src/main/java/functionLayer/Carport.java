/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import java.util.Date;

/**
 *
 * @author Jesper
 */
public class Carport {
    
    private int id;
    private Date date;
    private double carport_length;
    private double carport_width;
    private int roof_id;
    private double total_price;
    private boolean status_of_order;
    private int shed_id;
    private int customer_id;

    public Carport(double carport_length, double carport_width, int roof_id, double total_price, int shed_id, int customer_id) {
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.roof_id = roof_id;
        this.total_price = total_price;
        this.customer_id = customer_id;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public double getCarport_length() {
        return carport_length;
    }

    public double getCarport_width() {
        return carport_width;
    }

    public int getRoof_id() {
        return roof_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public boolean isStatus_of_order() {
        return status_of_order;
    }

    public int getShed_id() {
        return shed_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }
    
    
    
    
}
