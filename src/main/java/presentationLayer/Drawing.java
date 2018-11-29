/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.SVGTop;
import functionLayer.SVGSide;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class Drawing extends Command {



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        

        return "svgTest";
    }

}
