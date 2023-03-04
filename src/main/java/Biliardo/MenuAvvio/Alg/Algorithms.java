package Biliardo.MenuAvvio.Alg;

import java.awt.*;

public class Algorithms {

    public static double getAngle(Point p1, Point p2){
        double dist=Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
        double dist2=Math.abs(p1.y-p2.y);
        double an=Math.asin(dist2/dist);

        if(p1.x<p2.x && p1.y<p2.y)
            return an;
        if(p1.x>p2.x && p1.y<p2.y)
            return Math.PI-an;
        if(p1.x<p2.x && p1.y>p2.y)
            return -an;
        else
            return -(Math.PI-an);
    }
    public static double getAngleC(Point p1,Point p2){
        int angle = (int) Math.toDegrees(Math.atan2(p1.y - p2.x, p1.x - p2.x));

        if(angle < 0){
            angle += 360;
        }
        while (angle>360)
            angle-=360;

        return angle;

    }

}
