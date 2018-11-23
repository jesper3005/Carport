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
        if ("Slet".equals(action)) {
            try {

                String[] selectProduct_id = request.getParameterValues("Select");
                int[] id = LogicFacade.StringArrayToIntArray(selectProduct_id);
                for (int i = 0; i < id.length; i++) {
                    pm.deleteProduct(id[i]);
                }

            } catch (Exception e) {
                e.getMessage();
            }
        } else if ("Update".equals(action)) {
            try {
                String[] selectProduct_id = request.getParameterValues("Select");
                int[] idArray = LogicFacade.StringArrayToIntArray(selectProduct_id);
                session.setAttribute("Update", idArray);
                return "update";
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            int product_id = Integer.parseInt(request.getParameter("product_id"));
            pm.deleteProduct(product_id);
        }
        List<Product> allProducts = pm.allProducts();
        session.setAttribute("allProduct", allProducts);
        return "admin";
    }

}
