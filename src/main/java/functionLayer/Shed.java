/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionLayer;

/**
 *
 * @author oerte
 */
public class Shed {
    
    private int shed_id;
    private double shed_length;
    private double shed_width;
    private int shed_facade_id;

    public Shed(int shed_id, double shed_length, double shed_width, int shed_facade_id) {
        this.shed_id = shed_id;
        this.shed_length = shed_length;
        this.shed_width = shed_width;
        this.shed_facade_id = shed_facade_id;
    }

    public int getShed_id() {
        return shed_id;
    }

    public double getShed_length() {
        return shed_length;
    }

    public double getShed_width() {
        return shed_width;
    }

    public int getShed_facade_id() {
        return shed_facade_id;
    }
    
    
    
}
