/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dbAccess.CarportMapper;
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
        CarportMapper carportMapper = new CarportMapper();
        List<Product> stykliste = null;
        Carport carport;
        Customer customer;
        

        try {
            //carport and shed measurments
            double shedWidth = 0;
            double shedLength = 0;
            double width = (double) session.getAttribute("bredde");
            double length = (double) session.getAttribute("laengde");
            String roofMaterial = (String) session.getAttribute("roofMaterial");
            String redskabsskur = (String) session.getAttribute("redskabsskur");
            

            if (redskabsskur != null) {
                shedWidth = (double) session.getAttribute("skurbredde");
                shedLength = (double) session.getAttribute("skurlaengde");
                stykliste = LogicFacade.CarportCalculaterFlatRoofIncludingShed(length, width, shedLength, shedWidth, roofMaterial);
            } else {
                stykliste = LogicFacade.CarportCalculaterFlatRoof(length, width, roofMaterial);
            }
            Shed shed = new Shed(shedLength, shedWidth);

            for (Product product : stykliste) {
                System.out.println(product);
            }

            double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);
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
                carport = new Carport(length, width, 0.0, "FLAT", roofMaterial, totalPriceOfCarport, shed.getShed_id(), customer.getId());
                carportMapper.addCarport(carport, shed);

            } else {
                Customer newCustomer = new Customer(firstName, lastName, email, addresse, town, zipCode, tel, comment);
                LogicFacade.addCustomer(newCustomer);
                Customer c = LogicFacade.getCustomerByEmail(email);
                //  public Carport(double carport_length, double carport_width, double degrees, String roof, String roofMaterial, double total_price, int shed_id, int customer_id) {
                carport = new Carport(length, width, 0.0, "FLAT", roofMaterial, totalPriceOfCarport, shed.getShed_id(), c.getId());
                carportMapper.addCarport(carport, shed);

            }
            return "orderComplete";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "orderComplete";
        }

    }

}
