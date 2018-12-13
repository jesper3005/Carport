/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
import functionLayer.Carport;
import functionLayer.Customer;
import functionLayer.LogicFacade;
import functionLayer.Product;
import functionLayer.Shed;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class CreateOrderFlatRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        HttpSession session = request.getSession();
        Customer customer;
        
        //Get the carport added to the session
        
        

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
            
            Carport carportFlat = (Carport) session.getAttribute("carportFladt");
            Shed shedFlat = (Shed) session.getAttribute("shedFlat");

            
            //Shed shed = new Shed(shedLength, shedWidth);

            //double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);
            //carportFlat.setTotal_price(totalPriceOfCarport);

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
            System.out.println(e.getMessage() + "Hall World");
            return "orderRequestFlatRoof";
        }

    }

}
