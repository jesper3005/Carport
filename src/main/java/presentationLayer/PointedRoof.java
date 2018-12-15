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
 * @author Jesper
 */
public class PointedRoof extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            List<Product> orderByLengthRemList = LogicFacade.remOrderedByLength();
            HttpSession session = request.getSession();
            session.setAttribute("orderByLengthRemList", orderByLengthRemList);

            return "carportPointedRoof";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "carportPointedRoof";
        }

    }

}
