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
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        try {
            HttpSession session = request.getSession();
            List<Carport> allOrders = null;
            List<Product> productList = null;
            String enumValue = request.getParameter("selectOrder");

            if (enumValue == null || enumValue.equals("allOrdre")) {
                allOrders = LogicFacade.getALLOrdresFromCarport();
                session.setAttribute("allOrders", allOrders);
            } else {
                System.out.println(enumValue);
                allOrders = LogicFacade.getOrdresFromCarportByEnum(enumValue);
                session.setAttribute("allOrders", allOrders);
            }
            for (Carport carport : allOrders) {
                if (carport.getRoof().equals("FLAT") && carport.getCarport_length() != 0) {
                    productList = LogicFacade.CarportCalculaterFlatRoofIncludingShed(carport.getCarport_length(), carport.getCarport_width(), carport.getShed().getShed_length(), carport.getShed().getShed_width(), carport.getRoofMaterial());
                    session.setAttribute("productList", productList);
                }
                if (carport.getRoof().equals("FLAT")) {
                    productList = LogicFacade.CarportCalculaterFlatRoof(carport.getCarport_length(), carport.getCarport_width(), carport.getRoofMaterial());
                    session.setAttribute("productList", productList);
                }
                if (carport.getRoof().equals("PEAK") && carport.getCarport_length() != 0) {
                    productList = LogicFacade.CarportCalculatorPointedRoofIncludingShed(carport.getCarport_length(), carport.getCarport_width(), carport.getDegrees(), carport.getShed().getShed_length(), carport.getShed().getShed_width(), carport.getRoofMaterial());
                    session.setAttribute("productList", productList);
                }
                if (carport.getRoof().equals("PEAK")) {
                    productList = LogicFacade.CarportCalculatorPointedRoof(carport.getCarport_length(), carport.getCarport_width(), carport.getDegrees(), carport.getRoofMaterial());
                    session.setAttribute("productList", productList);
                }
            }
            for (Product product : productList) {
                System.out.println(product);
            }
            return "manageOrders";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "manageOrders";
        }
    }

}
