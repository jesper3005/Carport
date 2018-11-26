/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.SVGTop;
import functionLayer.LogicFacade;
import functionLayer.Product;
import functionLayer.SVGSide;
import functionLayer.SVGTopTest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oerte
 */
public class OrderRequest extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        //length and width from carportFlatRoof or carportPointedRoof jsp page.
        double laengde = Double.parseDouble(request.getParameter("laengde"));
        double bredde = Double.parseDouble(request.getParameter("bredde"));
        //passing length to CarportCalulator in LogicFacade classe
        List<Product> stykliste = LogicFacade.CarportCalculater(laengde, bredde);
        Collections.sort(stykliste, new Comparator<Product>(){
            @Override
            public int compare(Product t, Product t1) {
               return (int) (t.getPriceLine()-t1.getPriceLine());
            }
            
             });
        // "stykliste is passed to a metode in LogicFacde, who calculates the total price of the carport
        double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);
        //Set styklisten, bredde, længde and totalPriceOfCarport in session
        session.setAttribute("bredde", bredde);
        session.setAttribute("laengde", laengde);
        session.setAttribute("stykliste", stykliste);
        session.setAttribute("totalPriceOfCarport", totalPriceOfCarport);
        
        //Inserting svg of the carport
        double length = (double) session.getAttribute("laengde");
        double width = (double) session.getAttribute("bredde");
        int height = 310;
        
        //Carport fra toppen.
        SVGTop cSVG = new SVGTop(length, width);
        request.setAttribute("drawingTop", cSVG.getMySVG());
        
//        SVGTopTest testSVG = new SVGTopTest(length, width);
//        request.setAttribute("drawingTop", testSVG.getMySVG());

        //Carport fra siden.
        SVGSide sSVG = new SVGSide(length, height);
        request.setAttribute("drawingSide", sSVG.getMySVG());
        
        // Transfer towards orderRequest.jsp
        return "orderRequest";
    }

}
