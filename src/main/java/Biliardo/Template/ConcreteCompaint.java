package Biliardo.Template;

import java.awt.*;

import static Biliardo.Constants.*;
import static Biliardo.Constants.size_const;
import static Biliardo.Table.field;
import static Biliardo.Table.pit;

public class ConcreteCompaint extends CommandPaint{

    @Override
    protected void step1(Graphics2D g2d) {
        TexturePaint tp2 = new TexturePaint(field, new Rectangle(300, 200));
        g2d.setPaint(tp2);
        g2d.fillRect(x_board+2,y_board+2,standard_width * size_const, standard_height * size_const);

    }

    @Override
    protected void step2(Graphics2D g2d) {
        g2d.setPaint(Color.darkGray);
        g2d.fillRect(x_board, y_board + 20, 10, 300);
        g2d.fillRect(BOARD_WIDTH - x_board - 8, y_board + 20, 10, 300);
        g2d.fillRect(x_board,y_board,560,10);
        g2d.fillRect(x_board,BOARD_HEIGHT-y_board,560,10);
    }

    @Override
    protected void step3(Graphics2D g2d) {
        //buche
        for (Point point : pit) {
            g2d.fillOval(point.x, point.y, pit_dim, pit_dim);
        }
        g2d.setColor(Color.white);
        g2d.fillOval(BOARD_WIDTH / 2 - 5, BOARD_HEIGHT / 2 - 5, 10, 10);

    }
}
