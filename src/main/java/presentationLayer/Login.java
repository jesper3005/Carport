/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.LogicFacade;
import functionLayer.User;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logging.DefaultLogger;

/**
 *
 * @author Jesper
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            User user = LogicFacade.login(email, password);
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return "../index";         
        } catch(LoginSampleException ex) {
            request.setAttribute("error", "Wrong username or password");
            System.out.println("Login failed");
            DefaultLogger.getMyLogger().log(Level.WARNING, "Login failed " + email+" : "+password);
            return "login";        
        }
        
        
    }
    
}
