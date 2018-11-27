/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.SVGTop;
import functionLayer.SVGSide;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class Drawing extends Command {



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        //Carport fra toppen.
        //HttpSession session = request.getSession();
        //int height = (int) session.getAttribute("laengde");
        HttpSession session = request.getSession();
        double length = (double) session.getAttribute("laengde");
        double width = (double) session.getAttribute("bredde");
        int height = 210;

        //Carport fra toppen.
        SVGTop cSVG = new SVGTop(length, width);
        request.setAttribute("drawingTop", cSVG.getMySVG());

        //Carport fra siden.
        SVGSide sSVG = new SVGSide(length, height);
        request.setAttribute("drawingSide", sSVG.getMySVG());

        return "svgTest";
    }

}
