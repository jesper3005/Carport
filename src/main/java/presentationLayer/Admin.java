/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dbAccess.ProductMapper;
import exceptions.FogException;
import functionLayer.Product;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oerte
 */
public class Admin extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        ProductMapper pm = new ProductMapper();
        String search = search = request.getParameter("search");

        if (search == null) {
            List<Product> allProducts = pm.allProducts();
            session.setAttribute("allProduct", allProducts);
            return "admin";
        } else {

            System.out.println(search);
            List<Product> searchList = pm.searchInProductTable(search);
            session.setAttribute("allProduct", searchList);
            return "admin";
        }

    }

}
