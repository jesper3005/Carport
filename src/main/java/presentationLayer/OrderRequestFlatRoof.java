/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
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
 * @author oerte
 */
public class OrderRequestFlatRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        try {
            HttpSession session = request.getSession();

            List<Product> stykliste;
            //length and width from shed from carportFlatRoof or carportPointedRoof jsp page.
            boolean shedCheck;
            double shedLength = Double.parseDouble(request.getParameter("skurlaengde"));
            double shedWidth = Double.parseDouble(request.getParameter("skurbredde"));
            //length and width from carportFlatRoof or carportPointedRoof jsp page.
            double length = Double.parseDouble(request.getParameter("laengde"));
            double width = Double.parseDouble(request.getParameter("bredde"));
            String redskabsskur = request.getParameter("redskabsskur");
            // value from roof selector
            String roofMaterial = request.getParameter("Tag");
            //Checks if roof is pointed for SVG's sake

            if(shedLength > length ){
                request.setAttribute("error", "Skur længde skal være mindre den selve carporten.");
                throw new FogException("Skur længde skal være mindre den selve carporten.");
            }if(shedWidth > width){
                request.setAttribute("error", "Skur bredde skal være mindre den selve carporten.");
                throw new FogException("Skur bredde skal være mindre den selve carporten.");
            }
            
            if (redskabsskur != null) {
                stykliste = LogicFacade.CarportCalculaterFlatRoofIncludingShed(length, width, shedLength, shedWidth, roofMaterial);
            } else {
                stykliste = LogicFacade.CarportCalculaterFlatRoof(length, width, roofMaterial);
            }

            double totalPriceOfCarport = LogicFacade.totalPriceOfCarport(stykliste);

            //Set styklisten, bredde, længde and totalPriceOfCarport in session
            session.setAttribute("totalPrice", totalPriceOfCarport);
            session.setAttribute("roofMaterial", roofMaterial);
            session.setAttribute("redskabsskur", redskabsskur);
            session.setAttribute("bredde", width);
            session.setAttribute("laengde", length);
            session.setAttribute("skurbredde", shedWidth);
            session.setAttribute("skurlaengde", shedLength);

            //------------SVG-------------
            if (redskabsskur == null) {
                shedCheck = false;
            } else {
                shedCheck = true;
            }

            //Rules (Tempoarily)
            double height = 230;

            //Inserting svg of the carport
            //Carport fra toppen.
            SVGTop testSVG = new SVGTop(length, width, shedLength, shedWidth, shedCheck);
            request.setAttribute("drawingTop", testSVG.getMySVG());

            //Carport fra siden.
            SVGSide sSVG = new SVGSide(length, height, shedLength, shedWidth, shedCheck);
            request.setAttribute("drawingSide", sSVG.getMySVG());

            return "orderRequestFlatRoof";

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "carportFlatRoof";
        }

    }

}
