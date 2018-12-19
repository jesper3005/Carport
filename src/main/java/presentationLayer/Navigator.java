/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        }

        return "login";

    }

}
