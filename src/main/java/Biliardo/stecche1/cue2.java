package Biliardo.stecche1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class cue2 extends cueAbs {


    private int dx_cue;
    private int dy_cue;
    private int x_cue=100;
    private int y_cue=100;


    public cue2(double aim, double strength) {

        super(1, 8, "1");
    }


    public void move(){
        x_cue=dx_cue;
        y_cue=dy_cue;
    }

    public int getX(){
        return x_cue;
    }
    public int getY(){
        return y_cue;
    }

    public Image getImg() throws IOException {
        poolCueImg = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/cue2.png"));
        poolCueImg=poolCueImg.getScaledInstance(300,40,0);
        return poolCueImg;
    }

    public void mouseMoved(MouseEvent e) {
        dx_cue=e.getX();
        dy_cue=e.getY();
    }



}
