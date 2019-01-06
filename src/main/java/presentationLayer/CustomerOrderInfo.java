/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import functionLayer.Customer;
import functionLayer.LogicFacade;
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
public class CustomerOrderInfo extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            HttpSession session = request.getSession();
            int customerID = Integer.parseInt(request.getParameter("customerID"));
            Customer customer = LogicFacade.getCustomerByID(customerID);
            session.setAttribute("customerInfo", customer);

            return "customerOrderInfo";
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + CustomerOrderInfo.class.getName());
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.WARNING,e.getMessage() +" "+ CustomerOrderInfo.class.getName() + System.lineSeparator());
            return "customerOrderInfo";
        }
    }

}
