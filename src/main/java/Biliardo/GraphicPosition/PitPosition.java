package Biliardo.GraphicPosition;

import java.awt.*;

import static Biliardo.Constants.*;


public class PitPosition {
    public static Point[] setPit(){
        Point[] pit=new Point[6];
        pit[0]=(new Point(x_board-pit_dim/2 +10, y_board-pit_dim/2 +10));
        pit[1]=(new Point(BOARD_WIDTH/2 -pit_dim/2,y_board -pit_dim/2 +10 ));
        pit[2]=(new Point(BOARD_WIDTH-x_board -pit_dim/2 -10,y_board-pit_dim/2 +10));
        pit[3]=(new Point(x_board-pit_dim/2 +10,BOARD_HEIGHT-y_board-pit_dim/2 ));
        pit[4]=(new Point(BOARD_WIDTH/2 -pit_dim/2,BOARD_HEIGHT-y_board-pit_dim/2));
        pit[5]=(new Point(BOARD_WIDTH-x_board -pit_dim/2 -10,BOARD_HEIGHT-y_board-pit_dim/2));
        return pit;
    }
}
