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

        HttpSession session = request.getSession();
        List<Product> stykliste = null;
        Carport carport;
        Customer customer;

        try {
            //carport and shed measurments
            double shedWidth = 0;
            double shedLength = 0;
            double width = (double) session.getAttribute("bredde");
            double length = (double) session.getAttribute("laengde");
            double degree = (double) session.getAttribute("degree");
            String roofMaterial = (String) session.getAttribute("roofMaterial");
            String redskabsskur = (String) session.getAttribute("redskabsskur");

            //Customer information
            String firstName = request.getParameter("fornavn");
            String lastName = request.getParameter("efternavn");
            String addresse = request.getParameter("addresse");
            String zipCode = request.getParameter("postnummer").trim();
            String town = request.getParameter("by");
            String tel = request.getParameter("telefon");
            String email = request.getParameter("email");
            String comment = request.getParameter("comment");

            if (redskabsskur != null) {
                shedWidth = (double) session.getAttribute("skurbredde");
                shedLength = (double) session.getAttribute("skurlaengde");
                stykliste = LogicFacade.carportCalculatorPointedRoofIncludingShed(length, width, degree, shedLength, shedWidth, roofMaterial);
            } else {
                stykliste = LogicFacade.carportCalculatorPointedRoof(length, width, degree, roofMaterial);
            }
            Shed shed = new Shed(shedLength, shedWidth);

            double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);

            customer = LogicFacade.getCustomerByEmail(email);

            if (customer != null && email.equals(customer.getEmail())) {
                carport = new Carport(length, width, degree, "PEAK", roofMaterial, totalPriceOfCarport, shed.getShed_id(), customer.getId());
                LogicFacade.addCarport(carport, shed);

            } else {
                Customer newCustomer = new Customer(firstName, lastName, email, addresse, town, zipCode, tel, comment);
                LogicFacade.addCustomer(newCustomer);
                Customer c = LogicFacade.getCustomerByEmail(email);
                carport = new Carport(length, width, degree, "PEAK", roofMaterial, totalPriceOfCarport, shed.getShed_id(), c.getId());
                LogicFacade.addCarport(carport, shed);

            }
            return "orderComplete";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "orderComplete";
        }

    }
}
