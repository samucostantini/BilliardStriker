package Biliardo.MenuAvvio;

import javax.swing.*;
import java.awt.*;

public class ThreadAnimation extends JFrame {

    public ThreadAnimation() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("pool");
        //mod
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {


        EventQueue.invokeLater(() -> {
            JFrame ex = new ThreadAnimation();
            ex.setVisible(true);
        });
    }
}
