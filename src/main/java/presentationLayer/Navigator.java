/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesper
 */
public class Navigator extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String site = request.getParameter("site");
        
        switch(site) {
            case "login": 
                return "login";
            case "registration":
                return "registration";
            
        }
            
        
        
        
        return "login";
        
    }
    
}
