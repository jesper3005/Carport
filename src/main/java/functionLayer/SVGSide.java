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
    
    //-----RULES HERE--------
    double remHeight = 30;
    double startPositionRem = 30;
    double stolpeGapFraRem = 10;
    
    public SVGSide(double length, double height) {
        this.sb = sb.append("<SVG width=\"800\" height=\"500\">");
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
        double x1 = startPositionRem + stolpeGapFraRem;
        double x2 = length + 20;
        
        
        sb.append("<rect x=\"" + x1 + "\" y=\"" + remHeight +"\" height=\"" + height + "\" width=\"10\" style=\"stroke: #292929; fill:none;\"/>");
        sb.append("<rect x=\"" + x2 + "\" y=\"" + remHeight + "\" height=\"" + height + "\" width=\"10\" style=\"stroke: #292929; fill:none;\"/>");
        
        
        return sb.toString();
    }
    
    public String createRem(double length) {
        StringBuilder sb = new StringBuilder();
        
        
        sb.append("<rect x=\"" + startPositionRem + "\" y=\"0\" height=\""+ remHeight + "\" width=\"" + length +"\" style=\"stroke: #292929; fill:none; stroke-width: 2;\"/>");
        
        return sb.toString();
    }
    
    
}
