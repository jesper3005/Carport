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
public class ManageProducts extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)  {

        try {
            HttpSession session = request.getSession();
            String search = search = request.getParameter("search");

            if (search == null) {
                List<Product> allProducts = LogicFacade.getAllProductsFromDatabase();
                session.setAttribute("allProduct", allProducts);
                return "manageProducts";
            } else {
                List<Product> searchList = LogicFacade.searchInDatabaseProductTable(search);
                session.setAttribute("allProduct", searchList);
                return "manageProducts";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() +" "+ ManageProducts.class.getName());
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.WARNING,e.getMessage() +" "+ ManageProducts.class.getName() + System.lineSeparator());
            return "manageProducts";
        }

    }

}
