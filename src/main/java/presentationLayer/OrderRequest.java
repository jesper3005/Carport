/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
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
        List<Product> stykliste = null;
        double shedLength = 0;
        double shedWidth = 0;
        //length and width from carportFlatRoof or carportPointedRoof jsp page.
        double length = Double.parseDouble(request.getParameter("laengde"));
        double width = Double.parseDouble(request.getParameter("bredde"));
        // length and widt from carportFlatRoof or carportPointedRoof jsp page.
        String redskabsskur = request.getParameter("redskabsskur");
        // value from roof selector
        String roofMaterial = request.getParameter("Tag");
        if (redskabsskur == null) {
            stykliste = LogicFacade.CarportCalculaterFlatRoof(length, width, roofMaterial);
        } else {
            shedLength = Double.parseDouble(request.getParameter("skurlaengde"));
            shedWidth = Double.parseDouble(request.getParameter("skurbredde"));
            stykliste = LogicFacade.CarportCalculaterFlatRoofIncludingShed(length, width, shedLength, shedWidth, roofMaterial);
        }

        //
        Collections.sort(stykliste, new Comparator<Product>() {
            @Override
            public int compare(Product t, Product t1) {
                return (int) (t.getPriceLine() - t1.getPriceLine());
            }

        });
        //passing length to CarportCalulator in LogicFacade class
        // "stykliste is passed to a metode in LogicFacde, what calculates the total price of the carport
        double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);
        //Set styklisten, bredde, længde and totalPriceOfCarport in session
        session.setAttribute("bredde", width);
        session.setAttribute("laengde", length);
        session.setAttribute("skurbredde", shedWidth);
        session.setAttribute("skurlaengde", shedLength);
        session.setAttribute("stykliste", stykliste);
        session.setAttribute("totalPriceOfCarport", totalPriceOfCarport);

        
        //------------SVG-------------
        
        //Rules (Tempoarily)
        double height = 230;
        double skurLength = 120;
        double skurWidth = 120;
        
        //Inserting svg of the carport
        
        //Carport fra toppen Test
        SVGTopTest testSVG = new SVGTopTest(length, width);
        request.setAttribute("drawingTop", testSVG.getMySVG());

        //Carport fra toppen.
        //SVGTop cSVG = new SVGTop(length, width, skurLength, skurWidth);
        //request.setAttribute("drawingTop", cSVG.getMySVG());

        //Carport fra siden.
        SVGSide sSVG = new SVGSide(length, height);
        request.setAttribute("drawingSide", sSVG.getMySVG());

        // Transfer towards orderRequest.jsp
        return "orderRequest";
    }

}
