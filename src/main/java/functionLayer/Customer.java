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
    
    String firstName, lastName, street, town;
    int password, id, zipCode, phone;

    public Customer(String firstName, String lastName, String street, String town, int password, int id, int zipCode, int phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.town = town;
        this.password = password;
        this.id = id;
        this.zipCode = zipCode;
        this.phone = phone;
    }


}
