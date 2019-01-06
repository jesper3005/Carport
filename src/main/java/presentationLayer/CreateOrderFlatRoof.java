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
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logging.DefaultLogger;
import logging.LoggerConfig;

/**
 *
 * @author Jesper
 */
public class CreateOrderFlatRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)  {

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
            
            Carport carportFlat = (Carport) session.getAttribute("carportFlat");
            Shed shedFlat = (Shed) session.getAttribute("shedFlat");

            customer = LogicFacade.getCustomerByEmail(email);

            if (customer != null && email.equals(customer.getEmail())) {
               carportFlat.setCustomer_id(customer.getId());
               LogicFacade.addCarport(carportFlat, shedFlat);
            } else {
                Customer newCustomer = new Customer(firstName, lastName, email, addresse, town, zipCode, tel, comment);
                LogicFacade.addCustomer(newCustomer);
                Customer c = LogicFacade.getCustomerByEmail(email);
                carportFlat.setCustomer_id(c.getId());
                LogicFacade.addCarport(carportFlat, shedFlat);
           }
            return "orderComplete";
            
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ CreateOrderFlatRoof.class.getName());
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.WARNING,e.getMessage() +" "+ CreateOrderFlatRoof.class.getName() + System.lineSeparator());
            return "orderRequestFlatRoof";
        }

    }

}
