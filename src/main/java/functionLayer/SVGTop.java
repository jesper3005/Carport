
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
public class SVGTop {

    private String mySVG = null;
    private StringBuilder sb = new StringBuilder();
    double startPosXY = 30;

//    double REM_WIDTH = 10;
//    double BATTEN_WIDTH = 5;
//    double POLES_WIDTH = 10;
//    double POLES_HEIGHT = 10;
//    double BATTENS_GAP_REM = 40;
//    double SHED_PLANK_WIDTH = 15;
//    double DOOR_WIDTH = 80;

    public SVGTop(Carport carport, Shed shed) {
        this.sb = sb.append("<SVG width=\"820\" height=\"820\">");
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP
        double length = carport.getCarport_length();
        double width = carport.getCarport_width();
        double shedLength = shed.getShed_length();
        double shedWidth = shed.getShed_width();
        //Creates carport
        sb.append(createRemme(length, width));

        //Creates shed
        if(shedLength > 0) {
            sb.append(createShed(length, width, shedLength, shedWidth));   
        }
        
        //For pointed roof
        if(carport.getRoof().equals("PEAK")) {
            sb.append(createLægterPointeRoof(length, width));
            sb.append(createSupportingLægter(length, width));
        } else {
            sb.append(createLægterFlatRoof(length, width));
        }
        
        //Creates text and lines
        sb.append(createLengthText(length, width));
        sb.append(createWidthText(length, width));
        
        sb.append("</SVG>");
        this.mySVG = sb.toString();

    }

    public String getMySVG() {
        return mySVG;
    }
    
    /*         Y
               |
               |
         x - - - - - 
               |
               |
    */
    
    //Base model
    private String createRemme(double length, double width) {
        //Decides where the bottom REM goes on y axis.
        double bottomRemY = width + (startPosXY - REM_WIDTH);
        //Decides where both bottom and top side REM will be placed on the x axis.
        double remXSides = startPosXY + REM_WIDTH;
        //lengthOfRem decides the actual length of the REMME.
        double lengthOfRem = length - (REM_WIDTH*2); 

        //Side rem top.
        sb.append("<rect x=\"").append(remXSides).append("\" y=\"").append(startPosXY).append("\" height=\"10\" width=\"").append(lengthOfRem).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        //Side rem bottom.
        sb.append("<rect x=\"").append(remXSides).append("\" y=\"").append(bottomRemY).append("\" height=\"10\" width=\"").append(lengthOfRem).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");

        //Remme front og bag.
        //x2 decides where the furthest back rem will be placed on the x axis.
        double x2 = startPosXY + length - REM_WIDTH;

        sb.append("<rect x=\"").append(startPosXY).append("\" y=\"").append(startPosXY).append("\" height=\"").append(width).append("\" width=\"").append(REM_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        sb.append("<rect x=\"").append(x2).append("\" y=\"").append(startPosXY).append("\" height=\"").append(width).append("\" width=\"").append(REM_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");

        return sb.toString();
    }
   
    private String createLengthText(double length, double width) {
        double lineY = width + startPosXY + 30;
        double startLine = startPosXY - REM_WIDTH;
        double lenghtOfLine = length + startPosXY;

        sb.append("<line x1=\"").append(startLine).append("\" y1=\"").append(lineY).append("\" x2=\"").append(lenghtOfLine).append("\" y2=\"").append(lineY).append("\" style=\"stroke:rgb(255,0,0);stroke-width:2\" />");

        //Minus 50 to get text centered, dividing with 2 will get the middle, but thats where the text will start
        double textXPos = (lenghtOfLine / 2) - 50;
        double textYPos = lineY + 20;

        sb.append("<text x=\"").append(textXPos).append("\" y=\"").append(textYPos).append("\" fill=\"red\">L\u00e6ngde: ").append(width).append(" cm</text>");
        return sb.toString();
    }

    private String createWidthText(double length, double width) {
        

        double x1 = length + startPosXY + 30;
        double y2 = width + startPosXY;

        sb.append("<line x1=\"").append(x1).append("\" y1=\"").append(startPosXY).append("\" x2=\"").append(x1).append("\" y2=\"").append(y2).append("\" style=\"stroke:rgb(255,0,0);stroke-width:2\" />");

        return sb.toString();
    }
    
    //For shed
    private String createShed(double length, double width,double shedLength, double shedWidth) {
        
        //Amount of planks needed for both lengths 
        double qtyShedLength = Math.ceil(shedLength / SHED_PLANK_WIDTH);
        //Side with door
        double qtyShedWidth = Math.ceil((shedWidth - DOOR_WIDTH) / SHED_PLANK_WIDTH);
        //Side no door
        double qtyBackWidth = Math.ceil(shedWidth / SHED_PLANK_WIDTH);
        
        //Creating sides length.
        //TOP
        double xTOP = startPosXY + length - REM_WIDTH - SHED_PLANK_WIDTH;
        for (int i = 0; i < qtyShedLength; i++) {
            sb.append("<rect x=\"").append(xTOP).append("\" y=\"").append(startPosXY).append(REM_WIDTH).append("\" height=\"5\" width=\"").append(SHED_PLANK_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            xTOP -= SHED_PLANK_WIDTH;
        }
        
        //BOT
        double xBOT = startPosXY + length - REM_WIDTH - SHED_PLANK_WIDTH;
        double y = (startPosXY + REM_WIDTH + shedWidth);
        for (int i = 0; i < qtyShedLength; i++) {
            sb.append("<rect x=\"").append(xBOT).append("\" y=\"").append(y).append("\" height=\"5\" width=\"").append(SHED_PLANK_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            xBOT -= SHED_PLANK_WIDTH;
        }
        
        //Right
        double xRight = startPosXY + length - REM_WIDTH - 5;
        double yRight = startPosXY + REM_WIDTH;
        for (int i = 0; i < qtyBackWidth; i++) {
            sb.append("<rect x=\"").append(xRight).append("\" y=\"").append(yRight).append("\" height=\"").append(SHED_PLANK_WIDTH).append("\" width=\"5\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            yRight += SHED_PLANK_WIDTH;
        }
        
        //Left
        double yLeft = startPosXY + REM_WIDTH + 5;
        double xLeft = startPosXY + length - REM_WIDTH - shedLength;
        for (int i = 0; i < qtyShedWidth; i++) {
            sb.append("<rect x=\"").append(xLeft).append("\" y=\"").append(yLeft).append("\" height=\"").append(SHED_PLANK_WIDTH).append("\" width=\"5\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            yLeft += SHED_PLANK_WIDTH;
        }
        
        
        return sb.toString();
    }
    
    //If flat roof is choosen
    private String createLægterFlatRoof(double length, double width) {
        
        
        double lægteLength = width + 25;

        double firstLægte = startPosXY + (BATTENS_GAP_REM - REM_WIDTH);
        double lastLægte = startPosXY + length - BATTENS_GAP_REM;
        double y2 = startPosXY - 10;
        
        sb.append("<rect x=\"").append(firstLægte).append("\" y=\"").append(y2).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        sb.append("<rect x=\"").append(lastLægte).append("\" y=\"").append(y2).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        double qty = Math.ceil(length / 50);
        length -= (BATTENS_GAP_REM * 2);
        double delta = length / (qty + 1);
        double lægtePos = delta + firstLægte;
        for (int i = 0; i < qty; i++) {
            System.out.println(qty);
            sb.append("<rect x=\"").append(lægtePos).append("\" y=\"").append(y2).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            lægtePos += delta; 
        }
        
        
        return sb.toString();
    }
    
    //If pointed roof is choosen
    private String createLægterPointeRoof(double length, double width) {
        double lægteLength = width / 2;
        double firstLægte = startPosXY + (BATTENS_GAP_REM - REM_WIDTH);
        double lastLægte = startPosXY + length - BATTENS_GAP_REM;
        double y1 = startPosXY - 10;
        double y2 = startPosXY + (width / 2) + 10;
        
        double qty = Math.ceil(length / 50);
        length -= (BATTENS_GAP_REM * 2);
        double delta = length / (qty + 1);
        double leftLægtePos = delta + firstLægte;
        //Left side lægter
        sb.append("<rect x=\"").append(firstLægte).append("\" y=\"").append(y1).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        sb.append("<rect x=\"").append(lastLægte).append("\" y=\"").append(y1).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        for (int i = 0; i < qty; i++) {
           sb.append("<rect x=\"").append(leftLægtePos).append("\" y=\"").append(y1).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
           leftLægtePos += delta;
        }
        
        
        //Right side lægter
        sb.append("<rect x=\"").append(firstLægte).append("\" y=\"").append(y2).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        sb.append("<rect x=\"").append(lastLægte).append("\" y=\"").append(y2).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        double rightLægtePos = delta + firstLægte;
        for (int i = 0; i < qty; i++) {
            sb.append("<rect x=\"").append(rightLægtePos).append("\" y=\"").append(y2).append("\" height=\"").append(lægteLength).append("\" width=\"").append(BATTEN_WIDTH).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            rightLægtePos = delta + rightLægtePos;
        }
        
        return sb.toString();
    }
    
    private String createSupportingLægter(double length, double width) {
        //The supporting lapth
        double remXPos = startPosXY + REM_WIDTH;
        double lengthOfRem = length - (REM_WIDTH*2);
        
        //Left
        double y1 = startPosXY + (width/4);
        sb.append("<rect x=\"").append(remXPos).append("\" y=\"").append(y1).append("\" height=\"").append(BATTEN_WIDTH).append("\" width=\"").append(lengthOfRem).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        
        //Right
        double width1 = width / 2;
        double y2 = startPosXY + width1 + (width1 / 2);
        
        sb.append("<rect x=\"").append(remXPos).append("\" y=\"").append(y2).append("\" height=\"").append(BATTEN_WIDTH).append("\" width=\"").append(lengthOfRem).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        //Middle
        double y3 = startPosXY + (width / 2) - REM_WIDTH;
        double middleRemWidth = REM_WIDTH + 10;
        sb.append("<rect x=\"").append(remXPos).append("\" y=\"").append(y3).append("\" height=\"").append(middleRemWidth).append("\" width=\"").append(lengthOfRem).append("\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        
        return sb.toString();
    }
    
    //Test
    private String createPointedRoof(double length, double width) {
        int degree = 20;

        double sinC = 180 - (2 * degree);
       
        //Calculates the length of the hypotenusen
        double hypo = (width * Math.sin(degree * (Math.PI/180))) / Math.sin(sinC * (Math.PI/180));
        
        double lengthOfLægte = (width + hypo + hypo/2) / 0.5 * width;
        double middleLægte = length;
        double middleLægtePos = lengthOfLægte / 2;
        
        sb.append("");
        
        
        return sb.toString();
    }
    
    
 
    
}
