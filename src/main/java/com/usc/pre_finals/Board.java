package com.usc.pre_finals;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class Board{
    
    private static JFrame frame;
    private static String title;
    
    public Board(int width, int height, int gridSize, String title, Game game, Handler handler) {
        Board.title = title;
        Dimension size = new Dimension(width, height);

        frame = new JFrame(title);
        frame.setPreferredSize(size);
        frame.setMinimumSize(size);
        frame.setMaximumSize(size);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new Grid(new GridLayout(gridSize, gridSize), handler);
        frame.setContentPane(panel);
        frame.pack();
        
        frame.setVisible(true);
    }
     public static void update(int flagged) {
        frame.setTitle( title + "Mines: " + Game.MINECOUNT + " - Flags: " + flagged);
    }
}
