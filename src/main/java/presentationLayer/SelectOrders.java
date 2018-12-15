/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
import functionLayer.Carport;
import functionLayer.LogicFacade;
import functionLayer.Product;
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
            
            List<Product> productList = LogicFacade.getAllProductsFromDatabase();
            session.setAttribute("productList", productList);
            
            //List<Product> stykliste = LogicFacade.CarportCalculaterFlatRoof(0, 0, roofMaterial);
            
            
            String enumValue = request.getParameter("selectOrder");

            if (enumValue == null || enumValue.equals("allOrdre")) {
                allOrders = LogicFacade.getALLOrdresFromCarport();
                session.setAttribute("allOrders", allOrders);
            } else {
                allOrders = LogicFacade.getOrdresFromCarportByEnum(enumValue);
                session.setAttribute("allOrders", allOrders);
            }
            return "manageOrders";
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "manageOrders";
        }
    }

}
