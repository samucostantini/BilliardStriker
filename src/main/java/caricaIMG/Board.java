package caricaIMG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Player player;
    private final int DELAY=10;

    /* provo ad aggiungere la modalità di pausa  cercando di
    * farla poi diventare un menù iniziale */

    public enum STATE {
        PAUSA, PLAY
    };
    private STATE statoAttuale = STATE.PLAY;

    // ha due stati, play e pausa...


    public Board(){
        initUI();
    }

    public void initUI() {
        addKeyListener(new Adapt());
        setBackground(Color.black);
        setFocusable(true);
        player = new Player();
        //fa cose solo se non è in pausa
        if (statoAttuale == STATE.PLAY) {
            timer = new Timer(DELAY, this);
            timer.start();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        g2d.drawImage(player.background,0,0,this);
        g2d.drawImage(player.image, player.getX(),player.getY(),this);

        if(player.shoot){
            g2d.drawImage(player.missile,player.getX(),player.getY(),this);
            moveM();
            int xm=player.getX();
            int ym= player.getY();
            while(xm<800){
                xm+=2;
                g2d.drawImage(player.missile,xm,ym,this);

            }
            player.shoot=false;
        }

    }
    public void move(){
        player.move();
        repaint();
    }
    public void moveM(){

        repaint();
    }


    private class Adapt extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            player.KeyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            player.KeyReleased(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        statoAttuale=player.cambiaStato();

        //fa cose solo se non è in pausa
        if (statoAttuale == STATE.PLAY) {
            move();
            repaint(player.getX() - 1, player.getY() - 1, player.getW() + 2, player.getH() + 2);
        }

    }
}

