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
public class AddProduct extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response){

        try {
            HttpSession session = request.getSession();
            //get all parameters from admin.jsp to add a produkt to table ´produkt´ in database
            String produkt_navn = request.getParameter("produkt_name");
            String category = request.getParameter("category");
            double price = Double.parseDouble(request.getParameter("price"));
            double length = Double.parseDouble(request.getParameter("length"));
            double width = Double.parseDouble(request.getParameter("width"));
            double height = Double.parseDouble(request.getParameter("height"));

            Product product = new Product(produkt_navn, category, price, length, width, height);

            LogicFacade.addProduct(product);
            List<Product> allProducts = LogicFacade.getAllProductsFromDatabase();
            session.setAttribute("allProduct", allProducts);
            return "manageProducts";
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + " " + AddProduct.class.getName());
            DefaultLogger.getLogger(LoggerConfig.PRODUCTION, false).log(Level.WARNING,e.getMessage() + " " + AddProduct.class.getName() + System.lineSeparator());
            return "manageProducts";
        }

    }

}
