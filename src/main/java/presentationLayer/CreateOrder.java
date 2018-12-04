/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dbAccess.CarportMapper;
import dbAccess.CustomerMapper;
import exceptions.LoginSampleException;
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
public class CreateOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        CustomerMapper cm = new CustomerMapper();
        CarportMapper carportMapper = new CarportMapper();
        List<Product> stykliste = null;
        Carport carport;
        Customer customer;
        Shed shed = null;
        int roof_id = 0;
        //carport and shed measurments
        double width = (double) session.getAttribute("bredde");
        double length = (double) session.getAttribute("laengde");
        double shedWidth = (double) session.getAttribute("skurbredde");
        double shedLength = (double) session.getAttribute("skurlaengde");
        String roofMaterial = (String) session.getAttribute("roofMaterial");
        String redskabsskur = (String) session.getAttribute("redskabsskur");

        if (redskabsskur == null) {
            stykliste = LogicFacade.CarportCalculaterFlatRoof(length, width, roofMaterial);
        } else {
            shed = new Shed(shedLength, shedWidth);
            stykliste = LogicFacade.CarportCalculaterFlatRoofIncludingShed(length, width, shedLength, shedWidth, roofMaterial);
        }

        for (Product product : stykliste) {
            if (product.getCategory().equals("tagpap") || product.getCategory().equals("trapeztag")) {
                roof_id = product.getId();
                System.out.println(roof_id+"  roof_id");
            } 
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

        customer = cm.customerId(email);
        System.out.println(shed.getShed_id()+" 1");
        

        if (email.equals(customer.getEmail())) {
            carport = new Carport(length, width, roof_id, 0,shed.getShed_id(), customer.getId());
            carportMapper.addCarport(carport,shed);

        } else {
            Customer newCustomer = new Customer(firstName, lastName, email, addresse, town, zipCode, tel, comment);
            cm.addCustomer(newCustomer);
            Customer c = cm.customerId(email);
            System.out.println(shed.getShed_id()+" shed id ");
            carport = new Carport(length, width, roof_id, 0, shed.getShed_id(), c.getId());
            carportMapper.addCarport(carport, shed);

        }
        return "createOrder";
    }

}
