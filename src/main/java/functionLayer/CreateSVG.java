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
        double h = height;
        double antalLægter = Math.ceil((h/50))-2;
        System.out.println(antalLægter);
                

        sb.append("<rect x=\"30\" y=\"40\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
        sb.append("<rect x=\"30\" y=\""+(h-40)+"\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
        h -= 40;

        double delta = (h-80)/antalLægter; //afstand mellem lægterne
        for (double i = 0; i < antalLægter; i++) {
            h -= delta;
            sb.append("<rect x=\"30\" y=\"" + h + "\" height=\"5\" width=\"405\" style=\"stroke: #292929; fill:none;\"/>");
            
        }
        return sb.toString();
    }

}
