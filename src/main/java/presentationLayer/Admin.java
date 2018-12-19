/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import functionLayer.LogicFacade;
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
    String execute(HttpServletRequest request, HttpServletResponse response)  {

        try {
            HttpSession session = request.getSession();
            String search = search = request.getParameter("search");

            if (search == null) {
                List<Product> allProducts = LogicFacade.getAllProductsFromDatabase();
                session.setAttribute("allProduct", allProducts);
                return "admin";
            } else {
                List<Product> searchList = LogicFacade.searchInDatabaseProductTable(search);
                session.setAttribute("allProduct", searchList);
                return "admin";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ Admin.class.getName());
            return "admin";
        }

    }

}
