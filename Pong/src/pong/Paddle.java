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
public class Paddle {
    private final int WIDTH, LENGTH;
    private int x, y;
    private boolean left, right;
    
    public Paddle() {
        WIDTH = 30;
        LENGTH = 60;
        x = 120;
        y = 260;
        left = false;
        right = false;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return WIDTH;
    }
    
    public int getLength() {
        return LENGTH;
    }
    
    public boolean getLeft() {
        return left;
    }
    
    public boolean getRight() {
        return right;
    }
    
    public void setX(int xNew) {
        x = xNew;
    }
    
    public void setY(int yNew) {
        y = yNew;
    }
    
    public void setLeft(boolean l) {
        left = l;
    }
    
    public void setRight(boolean r) {
        right = r;
    }
    
}
