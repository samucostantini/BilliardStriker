package progetto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class bounce extends JPanel implements MouseMotionListener
{
    public static final int WIDTH = 30;
    public static final int HEIGHT = 10;
    private int x;
    private int y=320;

    public bounce() {
        addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX()-WIDTH/2;

        repaint();
    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame f = new JFrame("Move rectangle");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new bounce());
                f.pack();
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });
    }
}