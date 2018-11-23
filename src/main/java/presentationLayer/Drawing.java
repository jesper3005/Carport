/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.CreateSVG;
import functionLayer.SVGSideView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class Drawing extends Command {

    public String carport(int length, int width, int height) {

        return "";
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        //Carport fra toppen.
        //HttpSession session = request.getSession();
        //int height = (int) session.getAttribute("laengde");
        HttpSession session = request.getSession();
        double length = (double) session.getAttribute("laengde");
        double width = (double) session.getAttribute("bredde");

        //Carport fra toppen.
        CreateSVG cSVG = new CreateSVG(length, width);
        request.setAttribute("drawingTop", cSVG.getMySVG());

        //Carport fra siden.
        SVGSideView sSVG = new SVGSideView(length, 310);
        request.setAttribute("drawingSide", sSVG.getMySVG());
<<<<<<< HEAD
        
        
=======

>>>>>>> fbdd9d80c24b4e16bed0f8229b31cd656253dfc8
        return "svgTest";
    }

}
