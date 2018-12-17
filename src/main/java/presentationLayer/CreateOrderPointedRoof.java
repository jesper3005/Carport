/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import functionLayer.Carport;
import functionLayer.Customer;
import functionLayer.LogicFacade;
import functionLayer.Shed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oerte
 */
public class CreateOrderPointedRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        Customer customer;

        try {
           
            //Customer information
            String firstName = request.getParameter("fornavn");
            String lastName = request.getParameter("efternavn");
            String addresse = request.getParameter("addresse");
            String zipCode = request.getParameter("postnummer").trim();
            String town = request.getParameter("by");
            String tel = request.getParameter("telefon");
            String email = request.getParameter("email");
            String comment = request.getParameter("comment");
            
            //Gets carport and shed from session
            Carport carportPeak = (Carport) session.getAttribute("carportPeak");
            Shed shedPeak = (Shed) session.getAttribute("shedPeak");

            customer = LogicFacade.getCustomerByEmail(email);

            if (customer != null && email.equals(customer.getEmail())) {
               carportPeak.setCustomer_id(customer.getId());
               LogicFacade.addCarport(carportPeak, shedPeak);

           } else {
               Customer newCustomer = new Customer(firstName, lastName, email, addresse, town, zipCode, tel, comment);
               LogicFacade.addCustomer(newCustomer);
               Customer c = LogicFacade.getCustomerByEmail(email);
               carportPeak.setCustomer_id(c.getId());
               LogicFacade.addCarport(carportPeak, shedPeak);

           }
            return "orderComplete";

        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CreateOrderPointedRoof.class.getName());
            return "orderRequestPointedRoof";
        }

    }
}
