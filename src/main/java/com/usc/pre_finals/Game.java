package com.usc.pre_finals;

public class Game {
    
    public static final int WIDTH = 500, HEIGHT = 500;
    public static final int GRIDSIZE = 10;
    public static final int MINECOUNT = (int) Math.round(GRIDSIZE * GRIDSIZE * .1);;

    private Handler handler = new Handler();
    
    public Game() {
        new Board(WIDTH, HEIGHT, GRIDSIZE, "Minesweeper", this, handler);
        Board.update(0);
    }
}
