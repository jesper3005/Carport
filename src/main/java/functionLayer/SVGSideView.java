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
public class SVGSideView {
    
    private String mySVG = null;
    private StringBuilder sb = new StringBuilder();
    
    public SVGSideView(double length, double height) {
        double width1 = length + 200;
        double height1 = height + 100;
        this.sb = sb.append("<SVG width=\"" + width1 +"\" height=\""+ height1 +"\">");
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP
        sb.append(createRem(length, height));
        
        sb.append("</SVG>");
        this.mySVG = sb.toString();
    }

    public String getMySVG() {
        return mySVG;
    }
    
    public String createStolper(double lenght, double height) {
        StringBuilder sb = new StringBuilder();
        height = 310;
        
        
        
        return sb.toString();
    }
    
    public String createRem(double length, double height) {
        StringBuilder sb = new StringBuilder();
        
        
        sb.append("<rect x=\"30\" y=\"0\" height=\"10\" width=\"" + length +"\" style=\"stroke: #292929; fill:none; stroke-width: 2;\"/>");
        
        return sb.toString();
    }
    
    
}
