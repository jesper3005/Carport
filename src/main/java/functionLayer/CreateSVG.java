/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

/**
 *
 * @author Jesper
 */
public class CreateSVG {

    private String mySVG = null;
    private StringBuilder sb = new StringBuilder();

    public CreateSVG(int height) {
        this.sb
                = sb.append("<SVG width=\"600\" height=\"600\">");
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP
        sb.append(createLægter(height));

        sb.append("</SVG>");
        this.mySVG = sb.toString();

    }

    public String getMySVG() {
        return mySVG;
    }

    private String createLægter(int height) {
        StringBuilder sb = new StringBuilder();
        int qty = height / 50;

        sb.append("<rect x=\"30\" y=\"40\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
        sb.append("<rect x=\"30\" y=\"380\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
        height -= 80;

        double delta = height / (qty - 2);
        for (int i = 0; i < qty; i++) {
            System.out.println(qty);
            sb.append("<rect x=\"30\" y=\"" + height + "\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
            height -= delta;
        }
        return sb.toString();
    }

}
