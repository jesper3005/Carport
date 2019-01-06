/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import functionLayer.LogicFacade;
import functionLayer.Product;
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
public class FlatRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
            HttpSession session = request.getSession();

        try {
            List<Product> orderByLengthRemList = LogicFacade.remOrderedByLength();
            session.setAttribute("orderByLengthRemList", orderByLengthRemList);
            
            return "carportFlatRoof";

        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ FlatRoof.class.getName());
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.WARNING,e.getMessage() +" "+ FlatRoof.class.getName() + System.lineSeparator());
            return "../index";
        }
    }

}
