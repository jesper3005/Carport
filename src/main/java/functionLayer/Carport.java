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
    private String status_of_order;
    private int shed_id;
    private int customer_id;
    private Shed shed;

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

    public Carport(int id, Date date, double carport_length, double carport_width, double degrees, String roof, String roofMaterial, double total_price, String status_of_order, int shed_id, int customer_id, Shed shed) {
        this.id = id;
        this.date = date;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.degrees = degrees;
        this.roof = roof;
        this.roofMaterial = roofMaterial;
        this.total_price = total_price;
        this.status_of_order = status_of_order;
        this.shed_id = shed_id;
        this.customer_id = customer_id;
        this.shed = shed;
    }

    @Override
    public String toString() {
        return "Carport{" + "id=" + id + ", date=" + date + ", carport_length=" + carport_length + ", carport_width=" + carport_width + ", degrees=" + degrees + ", roof=" + roof + ", roofMaterial=" + roofMaterial + ", total_price=" + total_price + ", status_of_order=" + status_of_order + ", shed_id=" + shed_id + ", customer_id=" + customer_id + ", shed=" + shed + '}';
    }

    public Shed getShed() {
        return shed;
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

    public String getStatus_of_order() {
        return status_of_order;
    }

    public int getShed_id() {
        return shed_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

}
