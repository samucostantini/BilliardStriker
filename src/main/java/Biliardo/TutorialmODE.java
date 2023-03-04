package Biliardo;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class TutorialmODE extends Table {

    public static void helper(int msg_index){
        JDialog j=new JDialog();
        j.setTitle("helper");
        Random r=new Random();
        String [] msg=new String[10];
        msg[0]="ball initial velocity is calculated between the distance of the cue and the ball";
        msg[1]="click when the cue is far from the white ball to increase shoot strength";
        msg[2]="click when the cue is near the white ball for a weak shot";
        msg[3]="try to hit the side of a coloured ball to give it direction";
        msg[4]="hit the wall if the white ball is clutched";
        msg[5]="don't pool the white ball";
        msg[6]="before the shoot you can see the preview of the direction";
        msg[7]="sometimes you need to shoot stronger";
        msg[8]="take your time to take the perfect direction";
        msg[9]="now you know everything about this game";
        JLabel jl=new JLabel();
        jl.setText(msg[msg_index]);

        JButton b=new JButton();
        b.setText("ok I understand");
        b.addActionListener(e -> {
            j.dispose();
        });
        b.setSize(new Dimension(20,60));
        j.add(b);


        j.add(jl);
        j.setVisible(true);
        j.setLocation(170,40);


        j.setSize(new Dimension(500,100));



        j.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }
}
