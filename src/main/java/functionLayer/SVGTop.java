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
    
    double startPosX = 45;
    double startPosY = 5;
    
    double remWidth = 5;
    double lægteWidth = 5;
    double stolpeWidth = 10;
    double stolpeHeight = 10;

    public SVGTop(double length, double width, double skurLength, double skurWidth) {
        double width1 = length + 100;
        double height1 = width + 100;
        this.sb = sb.append("<SVG width=\"800\" height=\"800\">");
        //ADD ALL METHODS FOR SVG DRAWING FROM TOP
        sb.append(createRemme(length, width));
        sb.append(createLægter(length, width));
        sb.append(createStolper(length, width));
        sb.append(createLenghtText(length, width));
        sb.append(createWidthText(length, width));
        sb.append(createShed(length, skurLength, skurWidth));

        sb.append("</SVG>");
        this.mySVG = sb.toString();

    }

    public String getMySVG() {
        return mySVG;
    }

    private String createLægter(double length, double width) {
        StringBuilder sb = new StringBuilder();

        //Calculates the quantity of current material.
        double qty = Math.ceil(length / 50);
        //Minus 2 because we will always place the two first the same place, 40 cm in from each side.
        qty -= 2;
        //We create a variable to store where the first and last lægte will be placed.
        double firstLægte = 40 + startPosY;
        double lastLægte = length - (40 + remWidth);
        //+ 25 thats the length of the lapths
        width += 25;
        //The two first laphts 
        sb.append("<rect x=\"30\" y=\"" + firstLægte + "\" height=\"" + lægteWidth +"\" width=\"" + width + "\" style=\"stroke: #292929; fill:none;\"/>");
        sb.append("<rect x=\"30\" y=\"" + lastLægte + "\" height=\"" + lægteWidth +"\" width=\"" + width + "\" style=\"stroke: #292929; fill:none;\"/>");
        
        //We get the remaining space left
        length -= 80;
        double delta = length / (qty + 1); //68
        double lægterPos = delta + firstLægte;
        for (int i = 0; i < qty; i++) {
            System.out.println(qty);
            sb.append("<rect x=\"30\" y=\"" + lægterPos + "\" height=\"" + lægteWidth + "\" width=\"" + width + "\" style=\"stroke: #292929; fill:none;\"/>");
            lægterPos += delta; 

        }
        return sb.toString();
    }

    private String createRemme(double length, double width) {
        StringBuilder sb = new StringBuilder();
        double totalRemWidth = remWidth * 2;
        double realLength = length - totalRemWidth;
        double y = startPosY + (remWidth - 5);
        double x = width + (45 - remWidth);
        
        //Vertical
        sb.append("<rect x=\"" + startPosX + "\" y=\"" + y + "\" height=\"" + realLength + "\" width=\""+ remWidth +"\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        sb.append("<rect x=\"" + x + "\" y=\"" + y + "\" height=\"" + realLength + "\" width=\"" + remWidth + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        
        //Horizontal
        sb.append("<rect x=\"45\" y=\"0\" height=\"" + remWidth + "\" width=\"" + width + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        sb.append("<rect x=\"45\" y=\"" + (realLength + remWidth ) + "\" height=\"" + remWidth + "\" width=\"" + width + "\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");

        if (width >= 510) {
            double placering = width / 2;
            sb.append("<rect x=\"" + (placering + 40) + "\" y=\"0\" height=\"" + realLength + "\" width=\"" + remWidth +"\" style=\"stroke: #292929; fill:none; stroke-width: 1.5;\"/>");
        }
        return sb.toString();
    }

    private String createStolper(double length, double width) {
        StringBuilder sb = new StringBuilder();
        double y = length - (stolpeWidth + remWidth);
        
        double x1 = remWidth + startPosX;
        double x2 = width + startPosX - (remWidth + stolpeWidth);
        
        double y3 = startPosY + (remWidth - 5);
        
        double y1 = length / 2;
        

        if (length <= 450) {
            //Back stolper
            sb.append("<rect x=\"" + x1 + "\" y=\"" + y + "\" height=\"" + stolpeHeight + "\" width=\"" + stolpeWidth + "\" style=\"stroke: #292929; fill:1;\"/>");
            sb.append("<rect x=\"" + x2 + "\" y=\"" + y + "\" height=\"" + stolpeHeight + "\" width=\"" + stolpeWidth + "\" style=\"stroke: #292929; fill:1;\"/>");
            //Front stolper
            sb.append("<rect x=\"" + x1 + "\" y=\"" + y3 + "\" height=\"" + stolpeHeight + "\" width=\"" + stolpeWidth + "\" style=\"stroke: #292929; fill:1;\"/>");
            sb.append("<rect x=\"" + x2 + "\" y=\"" + y3 + "\" height=\"" + stolpeHeight + "\" width=\"" + stolpeWidth + "\" style=\"stroke: #292929; fill:1;\"/>");
        } else if (length > 450) {
            //Back Stolper
            sb.append("<rect x=\"" + x1 + "\" y=\"" + y + "\" height=\"" + stolpeHeight + "\" width=\"" + stolpeWidth + "\" style=\"stroke: #292929; fill:1;\"/>");
            sb.append("<rect x=\"" + x2 + "\" y=\"" + y + "\" height=\"" + stolpeHeight + "\" width=\"" + stolpeWidth + "\" style=\"stroke: #292929; fill:1;\"/>");
            //Front stolper
            sb.append("<rect x=\"" + x1 + "\" y=\"" + y3 + "\" height=\"10\" width=\"10\" style=\"stroke: #292929; fill:1;\"/>");
            sb.append("<rect x=\"" + x2 + "\" y=\"" + y3 + "\" height=\"10\" width=\"10\" style=\"stroke: #292929; fill:1;\"/>");
            //The two extra stolper placed in the middle
            sb.append("<rect x=\""+ x1 + "\" y=\"" + y1 + "\" height=\"10\" width=\"10\" style=\"stroke: #292929; fill:1;\"/>");
            sb.append("<rect x=\"" + x2 + "\" y=\"" + y1 + "\" height=\"10\" width=\"10\" style=\"stroke: #292929; fill:1;\"/>");
        }

        return sb.toString();

    }

    private String createLenghtText(double length, double width) {
        StringBuilder sb = new StringBuilder();
        double x1 = width + 70;
        double x = width + 80;
        double y = length / 2;

        sb.append("<line x1=\"" + x1 + "\" y1=\"0\" x2=\"" + x1 + "\" y2=\"" + length + "\" style=\"stroke:rgb(255,0,0);stroke-width:2\" />");
        sb.append("<text x=\"" + x + "\" y=\"" + y + "\" fill=\"red\">" + length + " cm" + "</text>");

        return sb.toString();
    }

    private String createWidthText(double length, double width) {
        StringBuilder sb = new StringBuilder();
        double y = length + 15;
        double x = width + startPosX;
        double xText = 20 + (width / 2);
        double yText = length + 40;

        // y1 og y2 skal være det samme, bestemmer hvor langt nede den skal ligge
        // x1 er hvor linjen skal starte og x2 er hvor linjen skal slutte
        sb.append("<line x1=\"45\" y1=\"" + y + "\" x2=\"" + x + "\" y2=\"" + y + "\" style=\"stroke:rgb(255,0,0);stroke-width:2\"/>");
        sb.append("<text x=\"" + xText + "\" y=\"" + yText + "\" fill=\"red\">" + width + " cm" + "</text>");

        return sb.toString();
    }
    
    private String createShed(double length, double skurLength, double skurWidth) {
        StringBuilder sb = new StringBuilder();
        double x = startPosX + remWidth;
        double y = length - (remWidth + skurLength);
        double length1 = skurLength;
        double width = skurWidth;
        
        sb.append("<rect x=\"" + x + "\" y=\"" + y +"\" width=\""+ width + "\" height=\"" + length1 + "\" style=\"fill:#a7a5a5db; stroke: #a7a5a5db; fill:1;\" />");
        
        return sb.toString();
    }
}
