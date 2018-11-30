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
public class SVGTopTest {
    
    private String mySVG = null;
    private StringBuilder sb = new StringBuilder();
    
    double remWidth = 10;
    double lægteWidth = 5;
    double stolpeWidth = 10;
    double stolpeHeight = 10;
    double startPosXY = 30;
    
    public SVGTopTest(double length, double width) {
        this.sb = sb.append("<SVG width=\"800\" height=\"800\">");
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP
        sb.append(createRemmeString(length, width));

        sb.append("</SVG>");
        this.mySVG = sb.toString();

    }

    public String getMySVG() {
        return mySVG;
    }
    
    
    private String createRemmeString(double length, double width){
    StringBuilder sb = new StringBuilder();
    double y = width + startPosXY;
    length -= remWidth;
    
    
    //Remme sider
    sb.append("<rect x=\"" + startPosXY + "\" y=\"" + startPosXY + "\" height=\"10\" width=\"" + length + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
    sb.append("<rect x=\"" + startPosXY + "\" y=\"" + startPosXY + "\" height=\"10\" width=\"" + length + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
    
    //Remme front og bag
    double y2 = startPosXY + remWidth;
    double x2 = startPosXY - remWidth;
    
    sb.append("<rect x=\"" + x2 + "\" y=\"" + y2 + "\" height=\"" + width +"\" width=\"" + remWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");

    return sb.toString();
    }
    
    
}
