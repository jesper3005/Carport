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
    
    int userID, customerID;
    String password, email, role;
    

    public User(int userID, String password, String email, String role, int customerID) {
        this.userID = userID;
        this.password = password;
        this.email = email;
        this.role = role;
        this.customerID = customerID;
    }
    
    public User(String password, String email, String role, int customerID) {
        this.password = password;
        this.email = email;
        this.role = role;
        this.customerID = customerID;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    public int getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public int getCustomerID() {
        return customerID;
    }
    
    
    
}
