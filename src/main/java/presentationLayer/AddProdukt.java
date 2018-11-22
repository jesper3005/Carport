/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dbAccess.ProductMapper;
import exceptions.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oerte
 */
public class AddProdukt extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        ProductMapper pm = new ProductMapper();
        //get all parameters from admin.jsp to add a produkt to table ´produkt´ in database
        String produkt_navn = request.getParameter("produkt_name");
        String category = request.getParameter("category");
        System.out.println(request.getParameter("price"));
        Double price = Double.parseDouble(request.getParameter("price"));
        Double length = Double.parseDouble(request.getParameter("length"));
        Double width = Double.parseDouble(request.getParameter("width"));
        Double height = Double.parseDouble(request.getParameter("height"));
        pm.addProducts(produkt_navn, category, price, length, width, height);
        return "admin";
    }

}
