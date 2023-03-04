package progetto;



import javax.swing.*;

public class startBounce extends JFrame {
    public startBounce(){
        add(new bounce());

        setResizable(false);
        pack();

        setTitle("pool");
        //mod
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new startBounce();
    }
}
