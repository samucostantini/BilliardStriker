package Prog;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(){
    }

    //
    public void paintComponent(Graphics g){
        super.paintComponent(g); //chiama la superclass jpanel

        g.fillRect(100,100,200,50);
    }
}
