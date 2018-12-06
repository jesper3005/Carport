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
public class SearchResult extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        ProductMapper pm = new ProductMapper();
        HttpSession session = request.getSession();
        String result = request.getParameter("result");
        System.out.println(result);
        List<Product> searchList = pm.searchInProductTable(result);
        session.setAttribute("searchList", searchList);
        
        return "searchResult";
    }

  
}
