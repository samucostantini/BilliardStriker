package Biliardo;

import java.util.Random;

import static Biliardo.Table.whiteBall;

public class ShootBall {

    public static void shootb(int x,int y) {
                whiteBall.setComponenteVelocitaX((whiteBall.getXposition() - x) *3);
                whiteBall.setComponenteVelocitaY((whiteBall.getYposition() - y) *3);
                System.out.println("tiro x "+whiteBall.getComponenteVelocitaX());
                System.out.println("tiro y "+whiteBall.getComponenteVelocitaY());
                whiteBall.dx = 0;
                whiteBall.dy = 0;
                whiteBall.MoveBall();
    }

    public static void shootRandomb(){
        Random random=new Random();
        int xr= random.nextInt(-1500,1500);
        int yr= random.nextInt(-1500,1500);
        System.out.println(xr+" "+yr);
        if(xr<100 && xr>-100)
            xr=100;
        if(yr<100 && yr>-100)
            yr=100;
        whiteBall.movimentoRimanente = 3000;

        whiteBall.setComponenteVelocitaX(xr);
        whiteBall.setComponenteVelocitaY(yr);

        whiteBall.dx = 0;
        whiteBall.dy = 0;
        whiteBall.MoveBall();
    }
}


