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
public class SVGTop {

    private String mySVG = null;
    private StringBuilder sb = new StringBuilder();

    double remWidth = 10;
    double lægteWidth = 5;
    double stolpeWidth = 10;
    double stolpeHeight = 10;
    double startPosXY = 30;
    double lægtePosInd = 40;
    double shedPlankWidth = 15;
    double doorWidth = 80;

    public SVGTop(double length, double width, double shedLength, double shedWidth, boolean shedCheck) {
        this.sb = sb.append("<SVG width=\"820\" height=\"820\">");
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP

        //Creates carport
        sb.append(createRemme(length, width));
        sb.append(createLægter(length, width));

        //Creates text and lines
        sb.append(createLengthText(length, width));
        sb.append(createWidthText(length, width));
        
        //Creates shed
        if(shedCheck == true) {
            sb.append(createShed(length, width, shedLength, shedWidth));   
        }
        
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
    

    private String createRemme(double length, double width) {
        
        //Decides where the bottom REM goes on y axis.
        double bottomRemY = width + (startPosXY - remWidth);
        //Decides where both bottom and top side REM will be placed on the x axis.
        double remXSides = startPosXY + remWidth;
        //lengthOfRem decides the actual length of the REMME.
        double lengthOfRem = length - (remWidth*2); 

        //Side rem top.
        sb.append("<rect x=\"" + remXSides + "\" y=\"" + startPosXY + "\" height=\"10\" width=\"" + lengthOfRem + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        //Side rem bottom.
        sb.append("<rect x=\"" + remXSides + "\" y=\"" + bottomRemY + "\" height=\"10\" width=\"" + lengthOfRem + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");

        //Remme front og bag.
        //x2 decides where the furthest back rem will be placed on the x axis.
        double x2 = startPosXY + length - remWidth;

        sb.append("<rect x=\"" + startPosXY + "\" y=\"" + startPosXY + "\" height=\"" + width + "\" width=\"" + remWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        sb.append("<rect x=\"" + x2 + "\" y=\"" + startPosXY + "\" height=\"" + width + "\" width=\"" + remWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");

        return sb.toString();
    }

    private String createLægter(double length, double width) {
        
        
        double lægteLength = width + 25;

        double firstLægte = startPosXY + (lægtePosInd - remWidth);
        double lastLægte = startPosXY + length - lægtePosInd;
        double y2 = startPosXY - 10;
        
        sb.append("<rect x=\"" + firstLægte + "\" y=\"" + y2 + "\" height=\"" + lægteLength + "\" width=\"" + lægteWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        sb.append("<rect x=\"" + lastLægte + "\" y=\"" + y2 + "\" height=\"" + lægteLength + "\" width=\"" + lægteWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        double qty = Math.ceil(length / 50);
        length -= (lægtePosInd * 2);
        double delta = length / (qty + 1);
        double lægtePos = delta + firstLægte;
        for (int i = 0; i < qty; i++) {
            System.out.println(qty);
            sb.append("<rect x=\"" + lægtePos + "\" y=\"" + y2 + "\" height=\"" + lægteLength + "\" width=\"" + lægteWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            lægtePos += delta; 
        }
        
        
        return sb.toString();
    }

    private String createLengthText(double length, double width) {
        
        double lineY = width + startPosXY + 30;
        double startLine = startPosXY - remWidth;
        double lenghtOfLine = length + startPosXY;

        sb.append("<line x1=\"" + startLine + "\" y1=\"" + lineY + "\" x2=\"" + lenghtOfLine + "\" y2=\"" + lineY + "\" style=\"stroke:rgb(255,0,0);stroke-width:2\" />");

        //Minus 50 to get text centered, dividing with 2 will get the middle, but thats where the text will start
        double textX = (lenghtOfLine / 2) - 50;
        double textY = lineY + 20;

        sb.append("<text x=\"" + textX + "\" y=\"" + textY + "\" fill=\"red\">" + "Længde: " + width + " cm" + "</text>");
        return sb.toString();
    }

    private String createWidthText(double length, double width) {
        

        double x1 = length + startPosXY + 30;
        double y2 = width + startPosXY;

        sb.append("<line x1=\"" + x1 + "\" y1=\"" + startPosXY + "\" x2=\"" + x1 + "\" y2=\"" + y2 + "\" style=\"stroke:rgb(255,0,0);stroke-width:2\" />");

        return sb.toString();
    }
    
    private String createShed(double length, double width,double shedLength, double shedWidth) {
        
        //Amount of planks needed for both lengths 
        double qtyShedLength = Math.ceil(shedLength / shedPlankWidth);
        //Side with door
        double qtyShedWidth = Math.ceil((shedWidth - doorWidth) / shedPlankWidth);
        //Side no door
        double qtyBackWidth = Math.ceil(shedWidth / shedPlankWidth);
        
        //Creating sides length.
        //TOP
        double xTOP = startPosXY + length - remWidth - shedPlankWidth;
        for (int i = 0; i < qtyShedLength; i++) {
            sb.append("<rect x=\"" + xTOP + "\" y=\"" + (startPosXY + remWidth) + "\" height=\"5\" width=\"" + shedPlankWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            xTOP -= shedPlankWidth;
        }
        
        //BOT
        double xBOT = startPosXY + length - remWidth - shedPlankWidth;
        double y = (startPosXY + remWidth + shedWidth);
        for (int i = 0; i < qtyShedLength; i++) {
            sb.append("<rect x=\"" + xBOT + "\" y=\"" + y + "\" height=\"5\" width=\"" + shedPlankWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            xBOT -= shedPlankWidth;
        }
        
        //Right
        double xRight = startPosXY + length - remWidth - 5;
        double yRight = startPosXY + remWidth;
        for (int i = 0; i < qtyBackWidth; i++) {
            sb.append("<rect x=\"" + xRight + "\" y=\"" + yRight + "\" height=\"" + shedPlankWidth + "\" width=\"5\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            yRight += shedPlankWidth;
        }
        
        //Left
        double yLeft = startPosXY + remWidth + 5;
        double xLeft = startPosXY + length - remWidth - shedLength;
        for (int i = 0; i < qtyShedWidth; i++) {
            sb.append("<rect x=\"" + xLeft + "\" y=\"" + yLeft + "\" height=\"" + shedPlankWidth + "\" width=\"5\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
            yLeft += shedPlankWidth;
        }
        
        
        return sb.toString();
    }
    
    private String createPointedRoof() {
        return sb.toString();
    }
    
}
