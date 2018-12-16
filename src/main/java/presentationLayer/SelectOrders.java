/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import functionLayer.Carport;
import functionLayer.LogicFacade;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class SelectOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)  {

        try {
            HttpSession session = request.getSession();
            List<Carport> allOrders;
            String enumValue = request.getParameter("selectOrder");

            if (enumValue == null || enumValue.equals("allOrdre")) {
                allOrders = LogicFacade.getAllCarportOrders();
                session.setAttribute("allOrders", allOrders);
            } else {
                allOrders = LogicFacade.getOrdresFromCarportByEnum(enumValue);
                session.setAttribute("allOrders", allOrders);
            }
            return "manageOrders";
            
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ SelectOrders.class.getName());
            return "manageOrders";
        }
    }

}
