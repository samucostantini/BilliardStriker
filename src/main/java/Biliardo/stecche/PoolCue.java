package Biliardo.stecche;

import Biliardo.MenuAvvio.cueChooser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

//!!instance only the cue selected  delete the other

public class PoolCue  {
    private int dx_cue;
    private int dy_cue;
    private int x_cue=100;
    private int y_cue=100;

    public Image poolCueImg;

    public PoolCue(){
        loadImage();
    }

    public void loadImage(){
        try {
            if(cueChooser.set_cue==1){
                poolCueImg = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/stecca.png"));
            }
            if(cueChooser.set_cue==2){
                poolCueImg=ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/cue2.png"));
            }
            if(cueChooser.set_cue==3){
                poolCueImg=ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/cue3.png"));
            }

            poolCueImg=poolCueImg.getScaledInstance(300,40,0);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public Image getImage(){return poolCueImg;}


    public void mouseDragged(MouseEvent e) {
        dx_cue=e.getX();
        dy_cue=e.getY();
    }

    public void mouseClicked(MouseEvent e){

    }



    public void mouseMoved(MouseEvent e) {
        dx_cue=e.getX();
        dy_cue=e.getY();
    }




}
