package com.usc.pre_finals;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Handler {
    private ArrayList<Cell> current = new ArrayList<Cell>();
    private ArrayList<Cell> queue = new ArrayList<Cell>();

    private static int flaggedCells = 0;
    
    private ImageIcon flagIcon = new ImageIcon("C:\\Users\\colla\\Documents\\NetBeansProjects\\pre_finals\\src\\main\\java\\resources\\11.png");
    private ImageIcon bombIcon = new ImageIcon("C:\\Users\\colla\\Documents\\NetBeansProjects\\pre_finals\\src\\main\\java\\resources\\bomb.png");
    private ImageIcon yayIcon = new ImageIcon("C:\\Users\\colla\\Documents\\NetBeansProjects\\pre_finals\\src\\main\\java\\resources\\yay.png");
    private ImageIcon clearIcon = new ImageIcon("C:\\Users\\colla\\Documents\\NetBeansProjects\\pre_finals\\src\\main\\java\\resources\\0.png");
    private ImageIcon blockIcon = new ImageIcon("C:\\Users\\colla\\Documents\\NetBeansProjects\\pre_finals\\src\\main\\java\\resources\\10.png");
    private int resize = Game.WIDTH / Game.GRIDSIZE;
    
    public void click(Cell cell) {
        int discoveredCells = 0;
        if(!cell.isFlagged()) {
            cell.setEnabled(false);
            cell.setDiscovered(true);

            int position = cell.getPosition();
            if(cell.getType() == 0) {
                if(position < Game.GRIDSIZE) {
                    if(position % Game.GRIDSIZE == 0) {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                    } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    } else {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    }
                } else if(position >= (Game.GRIDSIZE * (Game.GRIDSIZE - 1))) {
                    if(position % Game.GRIDSIZE == 0) {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                    } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    } else {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    }
                } else if(position % Game.GRIDSIZE == 0) {
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + 1)));
                } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position - 1)));
                } else {
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position - 1)));
                    queue.add(Grid.cellGrid.get((position + 1)));
                }
            } else if(cell.getType() == 2) {
                int dangerCount = 0;
                if(position < Game.GRIDSIZE) {
                    if(position % Game.GRIDSIZE == 0) {
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) dangerCount++; 
                        if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                    } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - 1).getType() == 1) dangerCount++;
                    } else {
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - 1).getType() == 1) dangerCount++;
                        System.out.println(dangerCount);
                    }
                } else if(position >= (Game.GRIDSIZE * (Game.GRIDSIZE - 1))) {
                    if(position % Game.GRIDSIZE == 0) {
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                    } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - 1).getType() == 1) dangerCount++;
                    } else {
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - Game.GRIDSIZE - 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                        if(Grid.cellGrid.get(position - 1).getType() == 1) dangerCount++;
                    }
                } else if(position % Game.GRIDSIZE == 0) {
                    if(Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get(position + 1).getType() == 1) dangerCount++;
                } else if(position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - 1)).getType() == 1) dangerCount++;
                } else {
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position - 1)).getType() == 1) dangerCount++;
                    if(Grid.cellGrid.get((position + 1)).getType() == 1) dangerCount++;
                }
                cell.setText(String.valueOf(dangerCount));
            } else if(cell.getType() == 1) {
                for(int x = 0; x < Grid.cellGrid.size(); x++) {
                    Grid.cellGrid.get(x).setEnabled(false);
                    if(Grid.cellGrid.get(x).getType() == 1) {Grid.cellGrid.get(x).setIcon(resizeIcon(bombIcon, resize, resize));}
                    else {
                        Grid.cellGrid.get(x).setIcon(null);
                    }
                }
            }  

            for(int x = 0; x < queue.size(); x++) {
                if(!queue.get(x).isDiscovered()) {
                    current.add(queue.get(x));
                    queue.get(x).setDiscovered(true);
                }
            }
            queue.clear();
            while(!current.isEmpty()) {
                Cell temp = current.get(0);
                current.remove(0);
                temp.clickButton();
            }

            for(int x = 0; x < Grid.cellGrid.size(); x++) {
                if(Grid.cellGrid.get(x).isDiscovered()) {
                    if(Grid.cellGrid.get(x).getType() != 1) 
                        Grid.cellGrid.get(x).setIcon(null);

                    discoveredCells++;
                }
            }

            if(discoveredCells == Grid.cellGrid.size() - Game.MINECOUNT) {
                //Win Game
                for(int x = 0; x < Grid.cellGrid.size(); x++) {
                    if(Grid.cellGrid.get(x).getType() == 1) {
                        Grid.cellGrid.get(x).setEnabled(false);
                        Grid.cellGrid.get(x).setIcon(resizeIcon(bombIcon, resize, resize));
                    } else {
                        Grid.cellGrid.get(x).setEnabled(false);
                        Grid.cellGrid.get(x).setText("");
                        Grid.cellGrid.get(x).setIcon(resizeIcon(yayIcon, resize, resize));;
                    }
                }
            }
        }   
    }

    public void rightClick(Cell cell) {
        if(!cell.isDiscovered()) {
            if(!cell.isFlagged()) {
                cell.setFlagged(true);
                flaggedCells++;
                   
                cell.setIcon(resizeIcon(flagIcon, resize, resize));
                
                Board.update(flaggedCells);
            } else {
                cell.setFlagged(false);
                flaggedCells--;
                
                cell.setIcon(resizeIcon(blockIcon, resize, resize));
                
                Board.update(flaggedCells);
            }
        }
    }
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }
}
