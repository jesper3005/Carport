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
public class User {
    
    int userID;
    String password, email, role;
    int customerID;

    public User(int userID, String password, String email, String role, int customerID) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.role = role;
        this.customerID = customerID;
    }
    
    
    
}
