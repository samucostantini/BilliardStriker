package Biliardo.Template;

import Biliardo.Ball;
import Biliardo.MenuAvvio.backgroundChooser;
import Biliardo.MenuAvvio.carpetChooser;
import Biliardo.MenuAvvio.fieldChooser;
import Biliardo.Table;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static Biliardo.Constants.*;
import static Biliardo.Table.pack;
import static Biliardo.Table.pit;

public class ConcreteCommand implements Command {
    @Override
    public void execute() {
        step1_LoadImg();
        step2_SetPit();
        step3_SetBall();
    }

    protected void step1_LoadImg() {
        try {
            Table.prov = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/campoInter.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Table.BilFrame = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/bordoCampoR2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Table.background = ImageIO.read(new File(pack[1][backgroundChooser.set_background]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Table.wood = ImageIO.read(new File(pack[0][fieldChooser.set_board]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Table.field = ImageIO.read(new File(pack[2][carpetChooser.set_carpet]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Table.whiteDot = ImageIO.read(new File("C:/Users/samuele/IdeaProjects/EsameING/src/main/resources/images/white.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    protected void step2_SetPit() {

        pit[0]=(new Point(x_board-pit_dim/2 +10, y_board-pit_dim/2 +10));
        pit[1]=(new Point(BOARD_WIDTH/2 -pit_dim/2,y_board -pit_dim/2 +10 ));
        pit[2]=(new Point(BOARD_WIDTH-x_board -pit_dim/2 -10,y_board-pit_dim/2 +10));
        pit[3]=(new Point(x_board-pit_dim/2 +10,BOARD_HEIGHT-y_board-pit_dim/2 ));
        pit[4]=(new Point(BOARD_WIDTH/2 -pit_dim/2,BOARD_HEIGHT-y_board-pit_dim/2));
        pit[5]=(new Point(BOARD_WIDTH-x_board -pit_dim/2 -10,BOARD_HEIGHT-y_board-pit_dim/2));

    }


    protected void step3_SetBall() {
        int ball_startX=700;
        int ball_startY=395;
        Table.palleInGioco.add(new Ball(ball_startX, ball_startY,1));                   //1
        Table.palleInGioco.add(new Ball(ball_startX+25,ball_startY+15,14));
        Table.palleInGioco.add(new Ball(ball_startX+25,ball_startY-15,3));
        Table.palleInGioco.add(new Ball(ball_startX+50,ball_startY+30,5));      //4
        Table.palleInGioco.add(new Ball(ball_startX+50,ball_startY,8));              //5
        Table.palleInGioco.add(new Ball(ball_startX+50,ball_startY-30,12));      //6
        Table.palleInGioco.add(new Ball(ball_startX+75,ball_startY+45,10));
        Table.palleInGioco.add(new Ball(ball_startX+75,ball_startY+15,6));
        Table.palleInGioco.add(new Ball(ball_startX+75,ball_startY-15,9));
        Table.palleInGioco.add(new Ball(ball_startX+75,ball_startY-45,7));
        Table.palleInGioco.add(new Ball(ball_startX+100,ball_startY+60,4));
        Table.palleInGioco.add(new Ball(ball_startX+100,ball_startY+30,15));
        Table.palleInGioco.add(new Ball(ball_startX+100,ball_startY,11));
        Table.palleInGioco.add(new Ball(ball_startX+100,ball_startY-30,2));
        Table.palleInGioco.add(new Ball(ball_startX+100,ball_startY-60,13));

    }


}
