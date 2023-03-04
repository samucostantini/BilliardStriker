package Biliardo.stecche;

public interface CueAbstract {
    String cue_img = null;
    int strength = 0;
    int aim = 0;
    public void loadImage();
    public void move();
    public int getX();
    public int getY();

}
