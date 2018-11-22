/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.CreateSVG;
<<<<<<< HEAD
=======
import functionLayer.Product;
import functionLayer.SVGSideView;
import java.util.List;
>>>>>>> 35c4a6479cbbcd3a3dfee94d7c22718a0bcf93f8
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class Drawing extends Command {

        public String carport(int length, int width, int height){
            
            return "";
        }
    
        
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        
        //Carport fra toppen.
        //HttpSession session = request.getSession();
        //int height = (int) session.getAttribute("laengde");

        HttpSession session = request.getSession();
        int length = (int) session.getAttribute("laengde");
        int width = (int) session.getAttribute("bredde");

        
        //Carport fra toppen.
        CreateSVG cSVG = new CreateSVG(length, width);
        request.setAttribute("drawingTop", cSVG.getMySVG());
        
        
        //Carport fra siden.
        SVGSideView sSVG = new SVGSideView(length, 310);
        request.setAttribute("drawingSide", sSVG.getMySVG());
        
        
        
        
       
        
        
        return "svgTest";
    }
    
}
