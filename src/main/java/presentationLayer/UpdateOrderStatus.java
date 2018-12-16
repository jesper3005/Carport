/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
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
public class UpdateOrderStatus extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)  {

        try {
            HttpSession session = request.getSession();
            String status = request.getParameter("status");
            String enumValue = request.getParameter("selectOrder");
            int id = Integer.parseInt(request.getParameter("id"));
            LogicFacade.updateOrderStatus(status, id);
            List<Carport> allOrders;

            if (enumValue == null || enumValue.equals("allOrdre")) {
                allOrders = LogicFacade.getAllCarportOrders();
                session.setAttribute("allOrders", allOrders);
            } else {
                System.out.println(enumValue);
                allOrders = LogicFacade.getOrdresFromCarportByEnum(enumValue);
                session.setAttribute("allOrders", allOrders);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ UpdateOrderStatus.class.getName());
        }
        return "manageOrders";
    }

}
