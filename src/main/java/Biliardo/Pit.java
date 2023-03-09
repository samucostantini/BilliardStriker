package Biliardo;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;

public class Pit {
    /*
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
    }*/
}
