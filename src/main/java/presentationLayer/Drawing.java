/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.CreateSVG;
import functionLayer.Product;
import java.util.List;
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
        
<<<<<<< HEAD
        //Carport fra toppen.
        //HttpSession session = request.getSession();
        //int height = (int) session.getAttribute("laengde");
        
        
        CreateSVG cSVG = new CreateSVG(420);
        
       
=======
        HttpSession session = request.getSession();
        int length = (int) session.getAttribute("laengde");
        int width = (int) session.getAttribute("bredde");
>>>>>>> d54826f3861be3c6f510ffc8adfaa48669ed4ac1
        
        //Carport fra toppen.
        CreateSVG cSVG = new CreateSVG(length, width);
        request.setAttribute("drawing", cSVG.getMySVG());
        
        
        //Carport fra siden.
        
        
        
        
        
       
        
        
        return "svgTest";
    }
    
}
