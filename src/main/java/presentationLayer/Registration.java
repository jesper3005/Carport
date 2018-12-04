/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.Customer;
import functionLayer.LogicFacade;
import functionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class Registration extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String town = request.getParameter("town");
        String zipCode = request.getParameter("zipCode");
        String phone = request.getParameter("phone");
        
        Customer customer = new Customer(firstName, lastName, email, address, town, zipCode, phone, town);
        LogicFacade.createCustomer(customer);
        
        int id = customer.getId();
        
        if(password1.equals(password2)) {
            User user;
            user = LogicFacade.createUser(email, password2, 1);
            session.setAttribute("user", user);
        } else {
            throw new LoginSampleException("the two password did not match");
        }
        
        return "../index";
    }
    
}
