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
        
        //Carport fra toppen.
        HttpSession session = request.getSession();
        int height = (int) session.getAttribute("laengde");
        
        CreateSVG cSVG = new CreateSVG(height);
        
       
        
        request.setAttribute("drawing", cSVG.getMySVG());
        
        
        
//        double laegterAntal = -2; //-2 fordi vi ved hvor den første og sidste skal ligge
//        for (Product product : stykliste) {
//            if(product.getCategory().equals("laegte")) {
//               laegterAntal = product.getQty();
//            }
//        }
//        
//        int width = 390; //Request
//        int height = 420; //Request
//        
//        int resternedeLaegterPlads = height - 80;
//        resternedeLaegterPlads /= (laegterAntal + 1);
//        
//        StringBuilder sb = new StringBuilder();
        
        
    
        
        
        //String drawing = "<rect x=\"30\" y=\"40\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>";
        
        
       
        //request.setAttribute("drawing", fundament);
        
        return "svgTest";
    }
    
}
