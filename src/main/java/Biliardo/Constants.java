package Biliardo;

public class Constants {
    public static final int BOARD_WIDTH = 1200; //ottimale 1200x800 ma poi è troppo lento
    public static final int BOARD_HEIGHT = 800;
    public static final int standard_width = 190; //standard dimension of billiard board
    public static final int standard_height = 110;
    public static final int size_const = 3;
    public static final int x_board = (BOARD_WIDTH / 2) - (standard_width * size_const) / 2; //285 per centrare
    public static final int y_board = (BOARD_HEIGHT / 2) - (standard_height * size_const) / 2; //
    public static final int pit_dim = 30;

}
