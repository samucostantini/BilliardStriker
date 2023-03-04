package Biliardo.stecche;

public class PoolCueGen {
    int strength;
    int aim;
    String imgFile;

    public PoolCueGen(int strength, int aim, String imgFile) {
        this.strength = strength;
        this.aim = aim;
        this.imgFile = imgFile;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAim() {
        return aim;
    }

    public void setAim(int aim) {
        this.aim = aim;
    }

    public String getImgFile() {
        return imgFile;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

}
