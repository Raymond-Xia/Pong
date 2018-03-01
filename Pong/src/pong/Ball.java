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
    private int speed;
    private double x, y;
    private boolean right;
    private boolean down;
    private double direction;
    
    public Ball(int xCoord, int yCoord, boolean r, boolean d) {
        x = xCoord;
        y = yCoord;
        right = r;
        down = d;
        speed = 2;
        direction = 7*Math.PI/4;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
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
    
    public int getSpeed() {
        return speed;
    }
    
    public double getDirection() {
        return direction;
    }
    
    public void setX(double xNew) {
        x = xNew;
    }
    
    public void setY(double yNew) {
        y = yNew;
    }
    
    public void setRight(boolean r) {
        right = r;
    }
    
    public void setDown(boolean d) {
        down = d;
    }
    
    public void setSpeed(int s) {
        speed = s;
    }
    
    public void setDirection(double d) {
        direction = d;
    }
    
}
