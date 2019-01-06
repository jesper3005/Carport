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
 * @author Jesper
 */
public class OrderRequestPointedRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        try {

            HttpSession session = request.getSession();
            List<Product> stykliste;
            String degreeStr = request.getParameter("degree");
            double degree = Double.parseDouble(degreeStr.substring(0, 2));
            //length and width from shed from carportFlatRoof or carportPointedRoof jsp page.
            double shedLength = Double.parseDouble(request.getParameter("skurlaengde"));
            double shedWidth = Double.parseDouble(request.getParameter("skurbredde"));
            //length and width from carportFlatRoof or carportPointedRoof jsp page.
            double length = Double.parseDouble(request.getParameter("laengde"));
            double width = Double.parseDouble(request.getParameter("bredde"));
            String redskabsskur = request.getParameter("redskabsskur");
            // value from roof selector
            String roofMaterial = request.getParameter("Tag");

            Shed shed;
            String error = "Skurets bredde og/eller længde må ikke være størrer end selve carporten.";

            if (shedLength > length || shedWidth > width) {
                request.setAttribute("error", error);
                DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.SEVERE, error + System.lineSeparator());
                return "carportPointedRoof";
            }

            if (redskabsskur != null) {
                stykliste = LogicFacade.carportCalculatorPointedRoofIncludingShed(length, width, degree, shedLength, shedWidth, roofMaterial);
                shed = new Shed(shedLength, shedWidth);
            } else {
                stykliste = LogicFacade.carportCalculatorPointedRoof(length, width, degree, roofMaterial);
                shed = new Shed(0.0, 0.0);
            }

            double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);

            Carport carport = new Carport(length, width, degree, "PEAK", roofMaterial, totalPriceOfCarport, shed.getShed_id(), 0);
            session.setAttribute("carportPeak", carport);
            session.setAttribute("shedPeak", shed);

            //------------SVG-------------
            //Rules (Tempoarily)
            double height = 230;

            //Inserting svg of the carport
            //Carport from top
            SVGTop topSVG = new SVGTop(carport, shed);
            request.setAttribute("drawingTop", topSVG.getMySVG());

            //Carport from side.
            SVGSide sSVG = new SVGSide(carport, shed, height);
            request.setAttribute("drawingSide", sSVG.getMySVG());

            return "orderRequestPointedRoof";
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + OrderRequestPointedRoof.class.getName());
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.WARNING,e.getMessage() +" "+ OrderRequestPointedRoof.class.getName() + System.lineSeparator());
            return "carportPointedRoof";
        }
    }
}
