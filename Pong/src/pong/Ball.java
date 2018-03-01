/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 *
 * @author raymondxia
 */
public class Ball {
    private static final int radius = 10;
    private int x, y;
    private boolean right;
    private boolean down;
    
    public Ball(int xCoord, int yCoord, boolean r, boolean d) {
        x = xCoord;
        y = yCoord;
        right = r;
        down = d;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public boolean getRight() {
        return right;
    }
    
    public boolean getDown() {
        return down;
    }
    
    public void setX(int xNew) {
        x = xNew;
    }
    
    public void setY(int yNew) {
        y = yNew;
    }
    
    public void setRight(boolean r) {
        right = r;
    }
    
    public void setDown(boolean d) {
        down = d;
    }
    
}
