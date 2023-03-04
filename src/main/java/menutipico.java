import javax.swing.*;
import java.awt.*;

public class menutipico extends JFrame {
    private JPanel panel1;
    private JButton settingButton;
    private JButton pvpButton;
    private JButton infoButton;
    private JButton customButton;
    private JButton tutorialButton;
    private JButton pveButton;

    public menutipico(){
        setSize(new Dimension(400,400));
        setTitle("oke");
        setContentPane(panel1);
        setVisible(true);
    }

    public static void main(String[] args) {
        new menutipico();
    }
}
