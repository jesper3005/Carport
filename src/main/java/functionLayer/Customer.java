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
    
    int id;
    String password, firstName, lastName, email, address, town, zipCode, phone;

    public Customer(int id, String password, String firstName, String lastName, String email, String address, String town, String zipCode, String phone) {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.town = town;
        this.zipCode = zipCode;
        this.phone = phone;
    }


}
