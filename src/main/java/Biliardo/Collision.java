package Biliardo;

import java.awt.*;
import java.util.List;

import static Biliardo.Constants.*;
import static Biliardo.MenuAvvio.Alg.Algorithms.getAngleC;

public class Collision {

    int velx;
    int vely;
    int mov;
    int sign1y;
    int sign1x;
    int sign2y;
    int sign2x;
    double vris;
    public void hitWall(Ball b,int direction){
        if (direction == 0) {
            b.setComponenteVelocitaX(- b.getComponenteVelocitaX());
        } else {
            b.setComponenteVelocitaY(- b.getComponenteVelocitaY());
        }
    }

    public void stopBall(List<Ball>ball){
        for(Ball b : ball){
            b.movimentoRimanente=0;
            b.setComponenteVelocitaY(0);
            b.setComponenteVelocitaX(0);
            b.setMovimentoRimanente(0);
        }
    }

    public void checkCollision(List<Ball> b,Ball whiteBall){

        for(int i=0;i<b.size();i++){
            checkCol2(b.get(i),whiteBall);
            for(int j=0;j<b.size();j++){
                if(i==j) {
                }
                else{
                    checkCol2(b.get(j),b.get(i));

                }
            }
        }


    }
    public void checkCol2(Ball b,Ball b2){
        double distX=b.getXposition()-b2.getXposition();
        double distY=b.getYposition()- b2.getYposition();
        double radSum=b.getRadius()*2 ;
        double dist=Math.sqrt((distX*distX)+(distY*distY));
        if(dist<=radSum +2){
                collision(b,b2);
        }
    }

    public void collision(Ball b,Ball b2){
        //b.setComponenteVelocitaX(b.getComponenteVelocitaX()/2); //provo a dargli un movimento minimo per vedere di
        //b.setComponenteVelocitaY(b.getComponenteVelocitaY()/2); //non farle fondere..
        ////MoveBall();
        ////MoveBall();
        //b.setComponenteVelocitaX( b.getComponenteVelocitaX());
        //b.setComponenteVelocitaY( b.getComponenteVelocitaY());

        //b2.dx=b.dx;
        //b2.dy=b.dy;
        /* Corretto

        velx=Math.abs(b.getComponenteVelocitaX())+Math.abs(b2.getComponenteVelocitaX());
        velx= (int) (velx/1.6);
        vely=Math.abs(b.getComponenteVelocitaY())+ Math.abs(b2.getComponenteVelocitaY());
        vely= (int) (vely/1.6);
       if(b.getMovimentoRimanente()>b2.getMovimentoRimanente())
           mov=b.getMovimentoRimanente();
       else
           mov=b2.getMovimentoRimanente();

       mov=(b.getMovimentoRimanente()+b2.getMovimentoRimanente())/2;

        while(Math.abs(velx)>5000)
            velx=velx/100;
        while(Math.abs(vely)>5000)
            vely=vely/100;

        vris=Math.sqrt(Math.pow(velx,2)+Math.pow(vely,2));
        velx= (int) (vris*Math.cos(getAngleC(new Point(b.getXposition(),b.getYposition()),new Point(b2.getXposition(),b2.getYposition()))));
        vely= (int) (vris*Math.sin(getAngleC(new Point(b.getXposition(),b.getYposition()),new Point(b2.getXposition(),b2.getYposition()))));




        if(b.getComponenteVelocitaY()>=0)
            sign1y=1;
        else
            sign1y=-1;

        if(b.getComponenteVelocitaX()>=0)
            sign1x=1;
        else
            sign1x=-1;

        if(b2.getComponenteVelocitaY()>=0)
            sign2y=1;
        else
            sign2y=-1;

        if(b2.getComponenteVelocitaX()>=0)
            sign2x=1;
        else
            sign2y=-1;

        if(b.getComponenteVelocitaX()==0){
            sign1x=sign2x;
            sign2x=-sign2x;
        }
        else if(b2.getComponenteVelocitaX()==0){
            sign2x=sign1x;
            sign1x=-sign1x;
        }
        if(b.getComponenteVelocitaY()==0){
            sign1y=sign2y;
            sign2y=-sign2y;
        }
        else if(b2.getComponenteVelocitaY()==0){
            sign2y=sign1y;
            sign1y=-sign1y;
        }
        double an=getAngleC(new Point(b.getXposition(),b.getYposition()),new Point(b2.getXposition(),b2.getYposition()));
        System.out.println("INIZIO COLLISIONE tra b1 e b2");
        System.out.println("la collisione ha un angolo di "+an);
        System.out.println("B1");
        System.out.println("movimento rimanente: "+b.movimentoRimanente);
        System.out.println("vel x: "+b.getComponenteVelocitaX());
        System.out.println("vel y: "+b.getComponenteVelocitaY());
        System.out.println("num pallina: "+b.num);
        System.out.println("---------------");
        System.out.println("B2");
        System.out.println("movimento rimanente: "+b2.movimentoRimanente);
        System.out.println("vel x: "+b2.getComponenteVelocitaX());
        System.out.println("vel y: "+b2.getComponenteVelocitaY());
        System.out.println("num pallina: "+b2.num);
        b.setComponenteVelocitaY(vely*sign1y);
        b.setComponenteVelocitaX(velx*sign1x);
        b.setMovimentoRimanente(mov);
        b2.setComponenteVelocitaY(vely*sign2y);
        b2.setComponenteVelocitaX(velx*sign2x);
        b2.setMovimentoRimanente(mov);
        System.out.println("FINE COLLISIONE");
        System.out.println("B1");
        System.out.println("movimento rimanente: "+b.movimentoRimanente);
        System.out.println("vel x: "+b.getComponenteVelocitaX());
        System.out.println("vel y: "+b.getComponenteVelocitaY());
        System.out.println("num pallina: "+b.num);
        System.out.println("---------------");
        System.out.println("B2");
        System.out.println("movimento rimanente: "+b2.movimentoRimanente);
        System.out.println("vel x: "+b2.getComponenteVelocitaX());
        System.out.println("vel y: "+b2.getComponenteVelocitaY());
        System.out.println("num pallina: "+b2.num);
        System.out.println("\n\n");
        System.out.println("++++++++++++++++++++++++++++++++++");
        b.MoveBall();
        b2.MoveBall();*/


        double dx=b.getXposition() -b2.getXposition();
        double dy=b.getYposition()-b2.getYposition();
        double d= Math.sqrt(dx*dx + dy*dy);
        double ux = dx / d;
        double uy = dy / d;
        double v1=b.getComponenteVelocitaX()* ux +b.getComponenteVelocitaY()*uy;
        double v2=b2.getComponenteVelocitaX()* ux +b2.getComponenteVelocitaY()*uy;
        double m1=1;
        double m2=1;
        double v1f = (v1 * (m1 - m2) + 2 * m2 * v2) / ( 1.6);
        double v2f = (v2 * (m2 - m1) + 2 * m1 * v1) / ( 1.6);
        b.setComponenteVelocitaX((int) (v1f*ux));
        b.setComponenteVelocitaY((int) (v1f*uy));
        b2.setComponenteVelocitaX((int) (v2f*ux));
        b2.setComponenteVelocitaY((int) (v2f*uy));
        b.MoveBall();
        b2.MoveBall();
    }


    public void checkOut(List<Ball> ball,Ball whiteB){

        for(Ball b : ball){
            if(b.getXposition()<x_board || b.getXposition()>BOARD_WIDTH-x_board){
                b.setComponenteVelocitaY(0);
                b.setComponenteVelocitaX(0);
                b.setMovimentoRimanente(0);
                b.setXposition(100);
                b.setYposition(100);

            }
        }


    }


}