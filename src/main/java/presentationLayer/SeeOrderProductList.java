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
public class SeeOrderProductList extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        int carportID = Integer.parseInt(request.getParameter("carportID"));
        Carport c = LogicFacade.getCarportByID(carportID);
        
        if(c.getRoof().equals("FLAT") && c.getShed().getShed_length() > 0) {
            List<Product> stykListe = LogicFacade.carportCalculaterFlatRoofIncludingShed(c.getCarport_length(), c.getCarport_width(), c.getShed().getShed_length(), c.getShed().getShed_width(), c.getRoofMaterial());
            session.setAttribute("orderProductList", stykListe);
        } else if(c.getRoof().equals("FLAT") && c.getShed().getShed_length() == 0) {
            List<Product> stykListe = LogicFacade.carportCalculaterFlatRoof(c.getCarport_length(), c.getCarport_width(), c.getRoofMaterial());
            session.setAttribute("orderProductList", stykListe);
        } 
        
        if(c.getRoof().equals("PEAK") && c.getShed().getShed_length() > 0) {
           List<Product> stykListe = LogicFacade.carportCalculatorPointedRoofIncludingShed(c.getCarport_length(), c.getCarport_width(), c.getDegrees(), c.getShed().getShed_length(), c.getShed().getShed_width(), c.getRoofMaterial());
           session.setAttribute("orderProductList", stykListe);
        } else if(c.getRoof().equals("PEAK") && c.getShed().getShed_length() == 0 ) {
           List<Product> stykListe = LogicFacade.carportCalculatorPointedRoof(c.getCarport_length(), c.getCarport_width(), c.getDegrees(), c.getRoofMaterial());
           session.setAttribute("orderProductList", stykListe);
        }
        
        
        return "seeOrderProductList";
    }
    
}
