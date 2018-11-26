    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationLayer;

import dbAccess.ProductMapper;
import exceptions.LoginSampleException;
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
public class UpdateProduct extends Command {

@Override
   String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
       HttpSession session = request.getSession();
       ProductMapper pm = new ProductMapper();
       String action = request.getParameter("action");
       System.out.println(action);
       if ("Update".equals(action)) {

           double price = Double.parseDouble(request.getParameter("price"));
           System.out.println(price);
           int id = Integer.parseInt(request.getParameter("id"));
           System.out.println(id + "hallo");
           pm.updatePrice(id, price);
       } else {
           int product_id = Integer.parseInt(request.getParameter("product_id"));
           System.out.println(product_id);
           pm.deleteProduct(product_id);
       }
       List<Product> allProducts = pm.allProducts();
       session.setAttribute("allProduct", allProducts);
       return "admin";
   }
   
   

}
