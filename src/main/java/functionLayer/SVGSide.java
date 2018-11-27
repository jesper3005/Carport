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
public class SVGSide {
    
    private String mySVG = null;
    private StringBuilder sb = new StringBuilder();
    
    public SVGSide(double length, double height) {
        double width1 = length + 100;
        double height1 = height + 100;
        this.sb = sb.append("<SVG width=\"" + width1 +"\" height=\""+ height1 +"\">");
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP
        sb.append(createRem(length));
        sb.append(createStolper(height, height));
        sb.append("</SVG>");
        this.mySVG = sb.toString();
    }

    public String getMySVG() {
        return mySVG;
    }
    
    public String createStolper(double length, double height) {
        StringBuilder sb = new StringBuilder();
        double x = length - 60;
        
        sb.append("<rect x=\"40\" y=\"0\" height=\"" + height + "\" width=\"10\" style=\"stroke: #292929; fill:none;\"/>");
        sb.append("<rect x=\"" + x + "\" y=\"0\" height=\"" + height + "\" width=\"10\" style=\"stroke: #292929; fill:none;\"/>");
        
        
        return sb.toString();
    }
    
    public String createRem(double length) {
        StringBuilder sb = new StringBuilder();
        
        
        sb.append("<rect x=\"30\" y=\"0\" height=\"10\" width=\"" + length +"\" style=\"stroke: #292929; fill:none; stroke-width: 2;\"/>");
        
        return sb.toString();
    }
    
    
}
