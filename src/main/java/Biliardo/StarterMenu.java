package Biliardo;

import Biliardo.MenuAvvio.cueChooser;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

public class StarterMenu extends JFrame{
    private JPanel panel1;
    private JButton PVPButton;
    private JButton settingsButton;
    private JButton customButton;
    private JButton TUTORIALButton;
    private JButton PVEButton;


    public StarterMenu(){
        setContentPane(panel1);

        setSize(new Dimension(600,500));
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        SwingUtilities.invokeLater(StarterMenu::new);
    }

}
