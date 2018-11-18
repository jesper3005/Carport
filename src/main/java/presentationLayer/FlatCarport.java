/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import exceptions.LoginSampleException;
import functionLayer.LogicFacade;
import functionLayer.Produkt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oerte
 */
public class FlatCarport extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        List<Produkt> productList = LogicFacade.getAllProduktFromDatabase();
        HttpSession session = request.getSession();
        session.setAttribute("productList", productList);
        
        return "carportFlatTag";
    }
    
}
