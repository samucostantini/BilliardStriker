package Biliardo.GraphicPosition;

import Biliardo.Ball;

import java.util.ArrayList;

public class InitialBallState {
        public static int ball_startX=700;
        public static int ball_startY=395;
       public static ArrayList<Ball> init_ball_pos(){
           ArrayList<Ball> palleInGioco = new ArrayList<>();
           palleInGioco.add(new Ball(ball_startX, ball_startY,1));                   //1
           palleInGioco.add(new Ball(ball_startX+25,ball_startY+15,14));
           palleInGioco.add(new Ball(ball_startX+25,ball_startY-15,3));

           palleInGioco.add(new Ball(ball_startX+50,ball_startY+30,5));      //4
           palleInGioco.add(new Ball(ball_startX+50,ball_startY,8));              //5
           palleInGioco.add(new Ball(ball_startX+50,ball_startY-30,12));      //6
           palleInGioco.add(new Ball(ball_startX+75,ball_startY+45,10));
           palleInGioco.add(new Ball(ball_startX+75,ball_startY+15,6));
           palleInGioco.add(new Ball(ball_startX+75,ball_startY-15,9));
           palleInGioco.add(new Ball(ball_startX+75,ball_startY-45,7));
           palleInGioco.add(new Ball(ball_startX+100,ball_startY+60,4));
           palleInGioco.add(new Ball(ball_startX+100,ball_startY+30,15));
           palleInGioco.add(new Ball(ball_startX+100,ball_startY,11));
           palleInGioco.add(new Ball(ball_startX+100,ball_startY-30,2));
           palleInGioco.add(new Ball(ball_startX+100,ball_startY-60,13));
           return palleInGioco;

       }
}
