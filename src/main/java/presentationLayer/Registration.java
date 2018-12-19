/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

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
    String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
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
            
            Customer c = LogicFacade.getCustomerByEmail(email);
            if(!password1.equals(password2)){
                request.setAttribute("error", "Password doesn't match!");
            }
            if(c != null && email.equals(c.getEmail())){
                request.setAttribute("error", "Email is allready on file.");
            }
            else if (c == null && password1.equals(password2)){
                password2 = LogicFacade.createHashedPassword(password2);
                Customer customer = new Customer(firstName, lastName, email, address, town, zipCode, phone, town);
                int id = LogicFacade.createCustomer(customer);
                System.out.println(id + " customer_id");
                User user;
                user = LogicFacade.createUser(email, password2, id);
                session.setAttribute("user", user);
                return "../index";
                
            }
            

        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + Registration.class.getName());
            return "registration";
        }
        return "registration";

    }
}
