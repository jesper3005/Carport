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
 * @author Jesper
 */
public class CreateOrderFlatRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        HttpSession session = request.getSession();
        List<Product> stykliste = null;
        Carport carport;
        Customer customer;
        
        //Get the carport added to the session
        
        

        try {
            //carport and shed measurments
            double shedWidth = 0;
            double shedLength = 0;
            double width = (double) session.getAttribute("bredde");
            double length = (double) session.getAttribute("laengde");
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
            
            Carport carportFlat = (Carport) session.getAttribute("carportFladt");
            Shed shedFlat = (Shed) session.getAttribute("shedFlat");

            if (redskabsskur != null) {
                //shedWidth = (double) session.getAttribute("skurbredde");
                //shedLength = (double) session.getAttribute("skurlaengde");
                stykliste = LogicFacade.carportCalculaterFlatRoofIncludingShed(carportFlat.getCarport_length(), carportFlat.getCarport_width(), shedFlat.getShed_length(), shedFlat.getShed_width(), carportFlat.getRoofMaterial());
                //stykliste = LogicFacade.CarportCalculaterFlatRoofIncludingShed(length, width, shedLength, shedWidth, roofMaterial);
            } else {
                stykliste = LogicFacade.carportCalculaterFlatRoof(carportFlat.getCarport_length(), carportFlat.getCarport_width(), carportFlat.getRoofMaterial());
                //stykliste = LogicFacade.carportCalculaterFlatRoof(length, width, roofMaterial);
            }
            
            //Shed shed = new Shed(shedLength, shedWidth);

            //double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);
            //carportFlat.setTotal_price(totalPriceOfCarport);

            customer = LogicFacade.getCustomerByEmail(email);

            if (customer != null && email.equals(customer.getEmail())) {
                //carport = new Carport(length, width, 0.0, "FLAT", roofMaterial, totalPriceOfCarport, shed.getShed_id(), customer.getId());
                carportFlat.setCustomer_id(customer.getId());
                LogicFacade.addCarport(carportFlat, shedFlat);

            } else {
                Customer newCustomer = new Customer(firstName, lastName, email, addresse, town, zipCode, tel, comment);
                LogicFacade.addCustomer(newCustomer);
                Customer c = LogicFacade.getCustomerByEmail(email);
                //carport = new Carport(length, width, 0.0, "FLAT", roofMaterial, totalPriceOfCarport, shed.getShed_id(), c.getId());
                carportFlat.setCustomer_id(c.getId());
                LogicFacade.addCarport(carportFlat, shedFlat);

            }
            return "orderComplete";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "orderComplete";
        }

    }

}
