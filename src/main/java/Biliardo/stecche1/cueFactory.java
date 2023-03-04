package Biliardo.stecche1;

public class cueFactory {

    double aim;
    double strength;

    public static cueAbs getCue(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("1")) {
            return new cue1(10, 2);

        } else if (type.equalsIgnoreCase("2")) {
            return new cue2(1, 2);
        } else if (type.equalsIgnoreCase("3")) {
            return new cue3(1, 3);
        }
        return null;
    }

}
