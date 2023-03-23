package Biliardo.table;

import java.awt.*;

import static Biliardo.Constants.*;
import static Biliardo.Constants.size_const;
import static Biliardo.Table.background;
import static Biliardo.Table.wood;

public class PaintTable {
    public static void pain(Graphics2D g2d){
        TexturePaint tpb = new TexturePaint(background, new Rectangle(300, 300));
        g2d.setPaint(tpb);
        g2d.fillRect(0, 0, BOARD_WIDTH, BOARD_HEIGHT);

        TexturePaint tp = new TexturePaint(wood, new Rectangle(100, 100));
        g2d.setPaint(tp);
        g2d.setStroke(new BasicStroke(110.0f));
        g2d.drawRoundRect(x_board, y_board, standard_width * size_const, standard_height * size_const, 1, 1);
    }

}
