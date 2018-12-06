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
    private double degrees;
    private String roof;
    private String roofMaterial;
    private double total_price;
    private boolean status_of_order;
    private int shed_id;
    private int customer_id;

    public Carport(double carport_length, double carport_width, double degrees, String roof, String roofMaterial, double total_price, int shed_id, int customer_id) {
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.degrees = degrees;
        this.roof = roof;
        this.roofMaterial = roofMaterial;
        this.total_price = total_price;
        this.shed_id = shed_id;
        this.customer_id = customer_id;
    }

    public String getRoof() {
        return roof;
    }

    public double getDegrees() {
        return degrees;
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

    public String getRoofMaterial() {
        return roofMaterial;
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
