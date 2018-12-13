/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
import functionLayer.Customer;
import functionLayer.LogicFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class CustomerOrderInfo extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        
        Customer customer = LogicFacade.getCustomerByID(customerID);
        session.setAttribute("customerInfo", customer);
        
        return "customerOrderInfo";
    }
    
}
