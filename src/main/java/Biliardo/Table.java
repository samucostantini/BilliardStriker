package Biliardo;

import Biliardo.MenuAvvio.*;
import Biliardo.Template.CommandPaint;
import Biliardo.Template.ConcreteCommand;
import Biliardo.Template.Command;
import Biliardo.Template.ConcreteCompaint;
import Biliardo.stecche1.*;
import Biliardo.table.PaintTable;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Biliardo.Constants.*;
import static Biliardo.MenuAvvio.Alg.Algorithms.getAngle;

public class Table extends JPanel implements ActionListener {
    public int coloreSelezionato;
    private Timer timer;
    //private PoolCue poolCue;

    private cueAbs steccaP;

    private Coin coin;
    Collision c=new Collision();
    JDialog jd=new JDialog();
    JLabel jl=new JLabel();
    int whiteBall_state=1;

    public static PallaBianca whiteBall; //palla bianca che il giocatore colpisce
    public static List<Ball> palleInGioco=new ArrayList<Ball>(15);

    private static int DELAY = 1;

    private int dispose1=15; //aumenta se aumenti raggio palline, serve per disporr le palline in buca
    private int dispose2=15;


    public static Point[] pit = new Point[6]; //array per le buche

    public static String[][] pack = new String[4][5];

    public static BufferedImage background;
    public static BufferedImage prov;
    public static Image BilFrame;

    int pit_cont=0;

    public static BufferedImage wood;
    public static BufferedImage field;
    public static BufferedImage whiteDot;
    double angle;
    boolean ballClick=false;
    JButton restart=new JButton();
    int ball_num;

    JLabel shoot_label=new JLabel();
    int num=0;

    int turno=0;

    Point initialPos=new Point(x_board+50,BOARD_HEIGHT/2);

    int control=0;
    int cont=0; //se è pari aumenta il delay
    int coin_trigger=0;
    double angle_shoot;
    CommandPaint paintSchedule=new ConcreteCompaint();

    public Table() {
        initBoard();
    }


    public void initBoard() {


        addMouseMotionListener(new Adapt());
        addMouseListener(new Adapt());
        addKeyListener(new Adapt());
        pack= ImagePackage.getPack();

        Command initialSchedule=new ConcreteCommand();
        initialSchedule.execute();


        shoot_label.setText("total shoot "+num);
        add(shoot_label);


        //provo a mettere le palline piu lontane tra loro
        //cambio 10 con 15

        whiteBall = new PallaBianca(initialPos.x, initialPos.y,0);
        Ball.setBallStop(palleInGioco);
        whiteBall.movimentoRimanente=0;

        //poolCue = new PoolCue();

        //-----------------------------------------------------------------------------------------------------------
        steccaP = cueFactory.getCue(String.valueOf(cueChooser.set_cue));


        timer = new Timer(DELAY, this);
        timer.start();
        setVisible(true);
    }

    private void moveCue(){
        //poolCue.move();
        steccaP.move();

        whiteBall.MoveBall();
        for(Ball bilie:palleInGioco){
            bilie.MoveBall();
        }
        repaint();

    }


    public void checkPit() {

        for(int i=0;i<pit.length;i++){

            for (Ball b : palleInGioco) {
                if (b.getXposition() <= 25 + pit[i].x && b.getXposition() >= pit[i].x - 8) {
                    if (b.getYposition() <= 25 + pit[i].y && b.getYposition() >= pit[i].y - 8) {
                        try {
                            shootSound.holeSound();
                        } catch (UnsupportedAudioFileException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (LineUnavailableException e) {
                            e.printStackTrace();
                        }
                        System.out.println("buca ok");
                        if(turno%2==0){
                            b.setXposition(1050);
                            b.setYposition(485 - dispose1);
                            dispose1+=30;
                        }
                        else{
                            b.setXposition(1080);
                            b.setYposition(485 - dispose2);
                            dispose2+=30;
                        }
                        b.dx = 0;
                        b.dy = 0;
                        b.setComponenteVelocitaX(0);
                        b.setComponenteVelocitaY(0);
                        b.movimentoRimanente = 0;
                        pit_cont++;
                    }
                }
            }

            if(whiteBall.getXposition()<=22+pit[i].x && whiteBall.getXposition()>=pit[i].x-4){
                if(whiteBall.getYposition()<=22+pit[i].y && whiteBall.getYposition()>=pit[i].y-4){
                    JDialog jj=new JDialog();
                    jj.setLocationRelativeTo(null);
                    jj.setSize(400,80);
                    JLabel jjl=new JLabel("foul: white ball in pit click inside the field to dispose the ball");
                    jj.add(jjl);
                    jj.setVisible(true);
                    jj.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    whiteBall_state=0;
                    whiteBall.setComponenteVelocitaX(0);
                    whiteBall.setComponenteVelocitaY(0);
                    whiteBall.setMovimentoRimanente(0);
                    whiteBall.setYposition(-20);
                    whiteBall.setXposition(-20);
                }
            }

        }



    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        shoot_label.setText("total shoot: "+num);

        /*cont++;
        //System.out.println(cont);
        if(cont%2==0)  //aumenta %1 per rallentare !!!!!!!!!!!!!!!!!!!!!!!!!!!!
            timer.setDelay(DELAY++);
        */
        if(whiteBall.movimentoRimanente<=0) {
            if(Ball.checkMove(palleInGioco))
                PaintTable.pain(g2d);
        }
        if(control==1){
           PaintTable.pain(g2d);

            control=0;
        }


        paintSchedule.execute(g2d);








        Ball.setColore(Color.white);
        ball_num=0;
        whiteBall.MYpaintComponents(g2d,Color.white,ball_num++);
        if(ColorChooser.selected==1) {
            for ( int i=0;i<palleInGioco.size();i++){
                if(i%2==0){
                    palleInGioco.get(i).MYpaintComponents(g2d, Board.colorBall1,ball_num++);
                }else {
                    palleInGioco.get(i).MYpaintComponents(g2d,Board.colorBall2,ball_num++);
                }
            }
        }
        else {
            for ( Ball bilie : palleInGioco){
                bilie.MYpaintComponents(g2d, Color.black,ball_num++);
            }

        }
        if(whiteBall.movimentoRimanente<=0){
            if (Ball.checkMove(palleInGioco)) {
                //System.out.println("entrat");
                AffineTransform old = g2d.getTransform();
                angle = getAngle(new Point(steccaP.getX(), steccaP.getY()), new Point(whiteBall.posizioneX, whiteBall.posizioneY));

                if(Board.game_mode==0 && num%2!=0){
                    //non disegna
                }
                else{
                    g2d.rotate(angle, steccaP.getX(), steccaP.getY());
                    try {
                        g2d.drawImage(steccaP.getImg(), steccaP.getX() - 150, steccaP.getY() - 15, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    g2d.setTransform(old);
                    AffineTransform old2 = g2d.getTransform();
                    g2d.setColor(Color.white);

                    angle = Math.toDegrees(angle) + 360;
                    angle = Math.toRadians(angle);
                    angle_shoot=angle;
                    g2d.rotate(angle, whiteBall.posizioneX, whiteBall.posizioneY);
                    g2d.setStroke(new BasicStroke(2));


                    g2d.drawLine(whiteBall.posizioneX, whiteBall.posizioneY, (int) (whiteBall.posizioneX + steccaP.getAim()*20), whiteBall.posizioneY);
                    System.out.println(steccaP.getAim());
                    g2d.setTransform(old2);
                }


            }
        }





    }


    int pot=0;

    public void shoot() {
        int permit=1;
        num++;
        if (whiteBall.movimentoRimanente <= 0 && permit==1) {
            if (num % 2 == 0 && Board.game_mode==0) {
                ShootBall.shootRandomb();
            } else {
                if(cueChooser.set_cue==1){
                    pot=500;
                }
               ShootBall.shootb(steccaP.getX(),steccaP.getY());
            }
        }
    }

    int msg_index=0;




    private class Adapt implements MouseMotionListener,MouseListener,KeyListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            //poolCue.mouseDragged(e);
        }

        @Override
        public void mouseClicked(MouseEvent e){
            if(whiteBall_state==1){
            DELAY=10;
            cont=0;
            control=1;
            coin_trigger=1;
            turno++;



            c.stopBall(palleInGioco);

            if(Board.game_mode==3){
                jd.setVisible(false);
                TutorialmODE.helper(msg_index);
                msg_index++;
                control=1;
            }

            try {
                shootSound.shSound();
            } catch (UnsupportedAudioFileException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (LineUnavailableException ex) {
                ex.printStackTrace();
            }
            }else{

                whiteBall.setXposition(e.getX());
                whiteBall.setYposition(e.getY());

                whiteBall_state=1;

            }


            shoot();
            //
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            steccaP.mouseMoved(e);

        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                DELAY=1;
                timer.setDelay(1);
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveCue();
        repaint();
        checkPit();

        c.checkCollision(palleInGioco,whiteBall);
    }
}