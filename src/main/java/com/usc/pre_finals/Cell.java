package com.usc.pre_finals;

import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class Cell extends JButton{
    
    private int type;
    private int position;
    private boolean discovered;
    private boolean flagged;
    private Handler handler;
    
    private final int NUM_IMAGES = 13;
    private Image[] img;
    
    public Cell(int type, int position, boolean discovered, boolean flagged,Handler handler) {
        this.type = type;
        // 0 = Empty, 1 = Mine, 2 = Number
        this.position = position;
        this.discovered = discovered;
        this.flagged = flagged;
        this.handler = handler;
        
        ImageIcon i = new ImageIcon("C:\\Users\\colla\\Documents\\NetBeansProjects\\pre_finals\\src\\main\\java\\resources\\10.png");
        int resize = Game.WIDTH / Game.GRIDSIZE;
        this.setIcon(resizeIcon(i, resize, resize));
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)) {
                    rightClickButton();
                } else {
                    clickButton();
                }
            }

            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
    }
    public int getType() {
        return type;
    }

    public int getPosition() {
        return position;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
    
    public void clickButton() {
        handler.click(this);
    }

    public void rightClickButton() {
        handler.rightClick(this);
    }
    
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }
}
