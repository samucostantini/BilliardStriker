package Biliardo.stecche1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public abstract class cueAbs {

    private int dx_cue;
    private int dy_cue;
    private int x_cue=100;
    private int y_cue=100;

    public Image poolCueImg;

    protected double aim;
    protected double strength;
    protected String type;

    public cueAbs(double aim, double strength, String type) {
        this.aim = aim;
        this.strength = strength;
        this.type = type;
    }

    public double getAim(){
        return aim;
    }
    public double getStrength(){
        return strength;
    }
    public int getX(){
        return x_cue;
    }
    public int getY(){
        return y_cue;
    }

    public void move(){
        x_cue=dx_cue;
        y_cue=dy_cue;
    }
    public abstract Image getImg() throws IOException;


    public void mouseMoved(MouseEvent e) {
        dx_cue=e.getX();
        dy_cue=e.getY();
    }

}

