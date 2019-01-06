/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.FogException;
import functionLayer.LogicFacade;
import functionLayer.User;
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
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String email = null;
        String password = null;
        try {
            email = request.getParameter("email");
            password = request.getParameter("password");
            password = LogicFacade.createHashedPassword(password);
            User user = LogicFacade.login(email, password);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            String ipAddress = request.getRemoteAddr();
            System.out.println("Ipaddresse: "+ ipAddress);
            return "../index";
        } catch (FogException ex) {
            System.out.println(ex.getMessage() +" "+ Login.class.getName());
            request.setAttribute("error", ex.getMessage());
            System.out.println("Login failed");
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.SEVERE, "Login failed. Email: " + email + " Password: " + password + System.lineSeparator());
            return "login";
        }

    }

}
