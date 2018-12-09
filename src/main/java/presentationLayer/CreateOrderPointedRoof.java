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
 * @author oerte
 */
public class CreateOrderPointedRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        try {
            HttpSession session = request.getSession();
            List<Product> stykliste = null;
            Carport carport;
            Customer customer;
            Shed shed = null;
            //carport and shed measurments
            double width = (double) session.getAttribute("bredde");
            double length = (double) session.getAttribute("laengde");
            double shedWidth = (double) session.getAttribute("skurbredde");
            double shedLength = (double) session.getAttribute("skurlaengde");
            double degree = (double) session.getAttribute("degree");
            String roofMaterial = (String) session.getAttribute("roofMaterial");
            String redskabsskur = (String) session.getAttribute("redskabsskur");

            if (redskabsskur == null) {
                stykliste = LogicFacade.CarportCalculatorPointedRoof(length, width, degree, roofMaterial);
            } else {
                shed = new Shed(shedLength, shedWidth);
                stykliste = LogicFacade.CarportCalculatorPointedRoofIncludingShed(length, width, degree, shedLength, shedWidth, roofMaterial);
            }

            //double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);
            //Customer information
            String firstName = request.getParameter("fornavn");
            String lastName = request.getParameter("efternavn");
            String addresse = request.getParameter("addresse");
            String zipCode = request.getParameter("postnummer").trim();
            String town = request.getParameter("by");
            String tel = request.getParameter("telefon");
            String email = request.getParameter("email");
            String comment = request.getParameter("comment");

            customer = LogicFacade.getCustomerByEmail(email);

            if (customer != null && email.equals(customer.getEmail())) {
                carport = new Carport(length, width, degree, "PEAK", roofMaterial, 0.0, shed.getShed_id(), customer.getId());
                LogicFacade.addCarport(carport, shed);

            } else {
                Customer newCustomer = new Customer(firstName, lastName, email, addresse, town, zipCode, tel, comment);
                LogicFacade.addCustomer(newCustomer);
                Customer c = LogicFacade.getCustomerByEmail(email);
                carport = new Carport(length, width, degree, "PEAK", roofMaterial, 0.0, shed.getShed_id(), c.getId());
                LogicFacade.addCarport(carport, shed);

            }
            return "orderComplete";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "orderComplete";
        }

    }
}
