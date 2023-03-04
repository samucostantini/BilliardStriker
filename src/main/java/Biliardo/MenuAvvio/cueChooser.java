package Biliardo.MenuAvvio;

import Biliardo.RunGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class cueChooser extends JFrame {
    private JPanel panelCue;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    public static int set_cue=1;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;

        BufferedImage cue1 = new BufferedImage(200,20,1);
        try {
            cue1 = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/stecca.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage cue2 = new BufferedImage(200,20,1);
        try {
            cue2 = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/cue2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage cue3 = new BufferedImage(200,30,1);
        try {
            cue3 = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/cue3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g2d.drawImage(cue1, 20, 40,200,60 ,this);
        g2d.drawImage(cue2, 20, 300,200,70 ,this);
        g2d.drawImage(cue3, 300, 40,200,70 ,this);
    }

    public cueChooser() {
        setContentPane(panelCue);
        setSize(new Dimension(800,800));
        setResizable(false);
        setLocationRelativeTo(null);

        button1.addActionListener(e -> {
            set_cue=1;
            setVisible(false);
            new RunGame();
        });
        button2.addActionListener(e -> {
            set_cue=2;
            setVisible(false);
            new RunGame();
        });
        button3.addActionListener(e -> {
            set_cue=3;
            setVisible(false);
            new RunGame();
        });


        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {
        new cueChooser();
    }

}
