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
public class manageOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        List<Carport> allOrders;
        String enumValue = request.getParameter("selectOrder");

        try {
            if (enumValue == null || enumValue.equals("allOrdre")) {
                allOrders = LogicFacade.getALLOrdresFromCarport();
                session.setAttribute("allOrders", allOrders);
            } else {
                System.out.println(enumValue);
                allOrders = LogicFacade.getOrdresFromCarportByEnum(enumValue);
                session.setAttribute("allOrders", allOrders);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "manageOrders";
    }

}
