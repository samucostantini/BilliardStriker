package Biliardo.stecche1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class cue1 extends cueAbs {
    private int dx_cue;
    private int dy_cue;
    private int x_cue=100;
    private int y_cue=100;


    public cue1(double aim, double strength) {
        super(10, 4, "1");
    }


    public Image getImg() throws IOException {
        poolCueImg = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/stecca.png"));
        poolCueImg=poolCueImg.getScaledInstance(300,40,0);
        System.out.println("immagine caricata");
        return poolCueImg;
    }




}
