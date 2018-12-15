/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;
import static functionLayer.Rules.*;

/**
 *
 * @author Jesper
 */
public class SVGSide {

    private String mySVG = null;
    private StringBuilder sb = new StringBuilder();

    //-----RULES HERE--------
    double startPosXY = 200;
    


    public SVGSide(Carport carport, Shed shed, double height) {
        this.sb = sb.append("<SVG width=\"800\" height=\"500\">");
        
        double length = carport.getCarport_length();
        double width = carport.getCarport_width();
        double degree = carport.getDegrees();
        double shedLength = shed.getShed_length();
        double shedWidth = shed.getShed_width();
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP
        sb.append(createRem(length));
        sb.append(createStolper(length, height));

        if (shedLength > 0) {
            sb.append(createShed(length, shedWidth, shedLength, shedWidth, height));
        }
        
        if(carport.getRoof().equals("PEAK")) {
            sb.append(createPointedRoof(length, width, degree));
        }
        

        sb.append("</SVG>");
        this.mySVG = sb.toString();
    }

    public String getMySVG() {
        return mySVG;
    }

    public String createRem(double length) {

        sb.append("<rect x=\"").append(startPosXY).append("\" y=\"").append(startPosXY).append("\" height=\"").append(REM_HEIGHT).append("\" width=\"").append(length).append("\" style=\"stroke: #292929; fill:none; stroke-width: 2;\"/>");
        return sb.toString();
    }
    
    public String createStolper(double length, double height) {
        double x1 = startPosXY + POLES_GAP_REM;
        double x2 = startPosXY + length - (POLES_GAP_REM*2);
        double y = startPosXY + REM_HEIGHT;
        
        System.out.println(x2);
        sb.append("<rect x=\"").append(x1).append("\" y=\"").append(y).append("\" height=\"").append(height).append("\" width=\"").append(POLES_WIDTH).append("\" style=\"stroke: #292929; fill:1;\"/>");
        sb.append("<rect x=\"").append(x2).append("\" y=\"").append(y).append("\" height=\"").append(height).append("\" width=\"").append(POLES_WIDTH).append("\" style=\"stroke: #292929; fill:1;\"/>");

        return sb.toString();
    }

    public String createShed(double length, double width, double shedLength, double shedWidth, double height) {
        double qtyShedLength = Math.ceil(shedLength / SHED_PLANK_WIDTH);
        double y = startPosXY + REM_HEIGHT;

        double x = startPosXY + length - (POLES_GAP_REM * 2);
        for (int i = 0; i < qtyShedLength; i++) {
            sb.append("<rect x=\"").append(x).append("\" y=\"").append(y).append("\" height=\"").append(height).append("\" width=\"").append(SHED_PLANK_WIDTH).append("\" style=\"stroke: #292929; fill:none;\"/>");
            x -= SHED_PLANK_WIDTH;
        }

        return sb.toString();
    }

    public String createPointedRoof(double length, double width, double degree) {
        double sinC = 180 - (2 * degree);
       
        //Calculates the length of the hypotenusen (The length of the rem depending on the angle 
        double hypo = (width * Math.sin(degree * (Math.PI/180))) / Math.sin(sinC * (Math.PI/180));
        
        double lengthOfLægte = (width + hypo + hypo/2) / 0.5 * width;
        
        
        double y = 0;
        
        sb.append("<rect x=\"").append(startPosXY).append("\" y=\"").append(y).append("\" height=\"").append(lengthOfLægte).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none;\"/>");
        
        
        
        return sb.toString();
    }
}
