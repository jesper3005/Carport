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
import functionLayer.SVGSide;
import functionLayer.SVGTop;
import functionLayer.Shed;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class OrderRequestPointedRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        try {
            HttpSession session = request.getSession();
            List<Product> stykliste;
            boolean shedCheck;
            boolean roofCheck = true;
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
            if (shedLength > length) {
                request.setAttribute("error", "Skur længde skal være mindre den selve carporten.");
                throw new FogException("Skur længde skal være mindre den selve carporten.");
            }
            if (shedWidth > width) {
                request.setAttribute("error", "Skur bredde skal være mindre den selve carporten.");
                throw new FogException("Skur bredde skal være mindre den selve carporten.");
            }

            if (redskabsskur != null) {
                stykliste = LogicFacade.CarportCalculatorPointedRoofIncludingShed(length, width, degree, shedLength, shedWidth, roofMaterial);
                shed = new Shed(shedLength, shedWidth);
            } else {
                stykliste = LogicFacade.CarportCalculatorPointedRoof(length, width, degree, roofMaterial);
                shed = new Shed(0.0, 0.0);
            }

            double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);

            Carport carport = new Carport(length, width, degree, "PEAK", roofMaterial, totalPriceOfCarport, shed.getShed_id(), 0);
            session.setAttribute("carportPeak", carport);
            session.setAttribute("shedPeak", shed);

            //Set styklisten, bredde, længde and totalPriceOfCarport in session
            session.setAttribute("totalPrice", totalPriceOfCarport);
            session.setAttribute("roofMaterial", roofMaterial);
            session.setAttribute("redskabsskur", redskabsskur);
            session.setAttribute("bredde", width);
            session.setAttribute("laengde", length);
            session.setAttribute("skurbredde", shedWidth);
            session.setAttribute("skurlaengde", shedLength);
            session.setAttribute("degree", degree);

            //------------SVG-------------
            if (redskabsskur == null) {
                shedCheck = false;
            } else {
                shedCheck = true;
            }

            //Rules (Tempoarily)
            double height = 230;

            //Inserting svg of the carport
            //Carport from top
            SVGTop testSVG = new SVGTop(length, width, shedLength, shedWidth, shedCheck, roofCheck);
            request.setAttribute("drawingTop", testSVG.getMySVG());

            //Carport from side.
            SVGSide sSVG = new SVGSide(length, height, shedLength, shedWidth, shedCheck);
            request.setAttribute("drawingSide", sSVG.getMySVG());

            return "orderRequestPointedRoof";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "carportPointedRoof";
        }

    }

}
