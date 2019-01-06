/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import functionLayer.Carport;
import functionLayer.LogicFacade;
import functionLayer.Product;
import functionLayer.SVGSide;
import functionLayer.SVGTop;
import functionLayer.Shed;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logging.DefaultLogger;
import logging.LoggerConfig;

/**
 *
 * @author oerte
 */
public class OrderRequestFlatRoof extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        
        try {
            HttpSession session = request.getSession();
            List<Product> stykliste;
            //length and width from shed from carportFlatRoof or carportPointedRoof jsp page.
            double shedLength = Double.parseDouble(request.getParameter("skurlaengde"));
            double shedWidth = Double.parseDouble(request.getParameter("skurbredde"));
            //length and width from carportFlatRoof or carportPointedRoof jsp page.
            double length = Double.parseDouble(request.getParameter("laengde"));
            double width = Double.parseDouble(request.getParameter("bredde"));
            String redskabsskur = request.getParameter("redskabsskur");
            // value from roof selector
            String roofMaterial = request.getParameter("Tag");
            String error = "Skurets bredde og/eller længde må ikke være størrer end selve carporten.";
            //Checks if roof is pointed for SVG's sake

            Shed shed;
            if (shedLength > length || shedWidth > width) {
                request.setAttribute("error", error);
                DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.SEVERE, error + System.lineSeparator());
                return "carportFlatRoof";
            }
            
            if (redskabsskur != null) {
                stykliste = LogicFacade.carportCalculaterFlatRoofIncludingShed(length, width, shedLength, shedWidth, roofMaterial);
                shed = new Shed(shedLength, shedWidth);
            } else {
                stykliste = LogicFacade.carportCalculaterFlatRoof(length, width, roofMaterial);
                shed = new Shed(0.0, 0.0);
            }
            
            double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);

            //Set styklisten, bredde, længde and totalPriceOfCarport in session
            Carport carport = new Carport(length, width, 0.0, "FLAT", roofMaterial, totalPriceOfCarport, shed.getShed_id(), 0);
            session.setAttribute("carportFlat", carport);
            session.setAttribute("shedFlat", shed);

            //------------SVG-------------
            //Rules (Tempoarily)
            double height = 230;

            //Inserting svg of the carport
            //Carport fra toppen.
            SVGTop topSVG = new SVGTop(carport, shed);
            request.setAttribute("drawingTop", topSVG.getMySVG());

            //Carport fra siden.
            SVGSide sSVG = new SVGSide(carport, shed, height);
            request.setAttribute("drawingSide", sSVG.getMySVG());
            
            return "orderRequestFlatRoof";
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + OrderRequestFlatRoof.class.getName());
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.WARNING,e.getMessage() +" "+ OrderRequestFlatRoof.class.getName() + System.lineSeparator());
            return "carportFlatRoof";
        }
    }
    
}
