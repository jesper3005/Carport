/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
public class CreateSVG {

    private String mySVG = null;
    

    public CreateSVG(List<Product> stykliste, int width, int height) {
        StringBuilder sb = new StringBuilder();
        sb.append("<SVG width=\"600\" height=\"600\">");
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP
        sb.append(createLægter(stykliste, width, height));
        
        sb.append("</SVG>");
        mySVG = sb.toString();

    }

    public String getMySVG() {
        return mySVG;
    }

    private String createLægter(List<Product> stykliste, int width, int height) {
        StringBuilder sb = new StringBuilder();
        int qty = 0;
        for (Product product : stykliste) {
            if (product.getCategory().equals("laegte")) {
                qty = (int) product.getQty() -2;
            }
        }
        
        sb.append("<rect x=\"30\" y=\"40\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
        sb.append("<rect x=\"30\" y=\"380\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
        height -= 80;
        
        int delta = height / (qty + 1);
        for (int i = 0; i < qty+1; i++) {
            height -= delta;
            sb.append("<rect x=\"30\" y=\""+height+"\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
        }
        return sb.toString();
    }

}
