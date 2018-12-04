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
public class Customer {
    
    private int id;
    private String firstName, lastName, email, address, town, zipCode, phone, comments;
    
    public Customer( int id, String firstName, String lastName, String email, String address, String town, String zipCode, String phone, String comments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.town = town;
        this.zipCode = zipCode;
        this.phone = phone;
        this.comments = comments;
    }

    public Customer( String firstName, String lastName, String email, String address, String town, String zipCode, String phone, String comments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.town = town;
        this.zipCode = zipCode;
        this.phone = phone;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getTown() {
        return town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getComments() {
        return comments;
    }

    public void setId(int id) {
        this.id = id;
    }

    

}
