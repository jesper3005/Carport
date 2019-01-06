/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

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
public class Navigator extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        
        
        try {
            String site = request.getParameter("site");

            switch (site) {
                case "login":
                    return "login";
                case "registration":
                    return "registration";
                case "home":
                    return "../index";
                case "logout":
                    session.invalidate();
                    return "../index";

            }
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ Navigator.class.getName());
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.WARNING,e.getMessage() +" "+ Navigator.class.getName() + System.lineSeparator());
        }

        return "login";

    }

}
