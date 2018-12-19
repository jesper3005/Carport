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
public class Employee {
    
    String firstName, lastName, email, role;
    int password, id;

    public Employee(String firstName, String lastName, String email, String role, int password, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
        this.id = id;
    }

}
