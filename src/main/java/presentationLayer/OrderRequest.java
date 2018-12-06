/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
import functionLayer.SVGSide;
import functionLayer.SVGTop;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oerte
 */
public class OrderRequest extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        boolean shedCheck;
        
        //Check site
        String checkSite = request.getParameter("carport");
        
        String degreeStr = request.getParameter("degree");
        double degree = Double.parseDouble(degreeStr.substring(0, 2));
        boolean pointedRoof;
        //length and width from shed from carportFlatRoof or carportPointedRoof jsp page.
        double shedLength = Double.parseDouble(request.getParameter("skurlaengde"));
        double shedWidth = Double.parseDouble(request.getParameter("skurbredde"));
        //length and width from carportFlatRoof or carportPointedRoof jsp page.
        double length = Double.parseDouble(request.getParameter("laengde"));
        double width = Double.parseDouble(request.getParameter("bredde"));
        String redskabsskur = request.getParameter("redskabsskur");
        // value from roof selector
        String roofMaterial = request.getParameter("Tag");
        
        if (redskabsskur == null) {
            shedCheck = false;
        } else {
            shedCheck = true;
        }

        //Set styklisten, bredde, længde and totalPriceOfCarport in session
        session.setAttribute("roofMaterial", roofMaterial);
        session.setAttribute("redskabsskur", redskabsskur);
        session.setAttribute("bredde", width);
        session.setAttribute("laengde", length);
        session.setAttribute("skurbredde", shedWidth);
        session.setAttribute("skurlaengde", shedLength);
        session.setAttribute("degree", degree);

        //------------SVG-------------
        //Rules (Tempoarily)
        double height = 230;

        //Inserting svg of the carport
        //Carport fra toppen Test
        SVGTop testSVG = new SVGTop(length, width, shedLength, shedWidth, shedCheck);
        request.setAttribute("drawingTop", testSVG.getMySVG());

        //Carport fra toppen.
        //SVGTop cSVG = new SVGTop(length, width, skurLength, skurWidth);
        //request.setAttribute("drawingTop", cSVG.getMySVG());
        //Carport fra siden.
        SVGSide sSVG = new SVGSide(length, height, shedLength, shedWidth, shedCheck);
        request.setAttribute("drawingSide", sSVG.getMySVG());

        // Transfer towards orderRequest.jsp
//        if(checkSite.equals("flat")){
//            
//        }
        return "orderRequest";
    }

}
