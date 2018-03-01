    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/*
 *
 * @author raymondxia
 */
public class Pong extends JPanel implements ActionListener, KeyListener {
    Timer updater;
    Ball ball;
    Paddle pad;
    Random r;
    
    public Pong() {
        
        ball = new Ball(0,0, true, true);
        pad = new Paddle();
                
        r = new Random();
        
        updater = new Timer(15, this);
        updater.start();
        
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        super.setBackground(Color.darkGray);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.ORANGE);
        g2d.fillOval(ball.getX(), ball.getY(), ball.getRadius()*2, ball.getRadius()*2);
        
        g2d.setColor(Color.black);
        g2d.fillRect(pad.getX(), pad.getY(), pad.getLength(), pad.getWidth());
        
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {    
        checkAndMove();
        repaint();
    }
    
    public void checkAndMove() {
        int x = ball.getX();
        int y = ball.getY();
        int r = ball.getRadius();
        
        /* Ball X-Movement */
        if (ball.getRight()) {
            if (x+r*2 >= super.getWidth()) {
                ball.setRight(false);
            } else if (x+r*2 >= pad.getX() && x+r*2 <= pad.getX()+pad.getLength() && y+r >= pad.getY() && y+r <= pad.getY()+pad.getWidth()) {
                ball.setRight(false);
            } else {
                ball.setX(x+2);
            }   
        } else {
            if (x <= 0) {
                ball.setRight(true);
            } else if (x <= pad.getX()+pad.getLength() && x >= pad.getX() && y+r >= pad.getY() && y+r <= pad.getY()+pad.getWidth()) {
                ball.setRight(true);
            } else {
                ball.setX(x-2);
            }
        }
        
        /* Ball Y-Movement */
        System.out.println(y+r);
        if (y+r*2 >= super.getHeight() || x+r>=pad.getX() && x+r<= pad.getX()+pad.getLength() && y+r*2>=pad.getY()) {
            ball.setDown(false);
        } else if (y <= 0) {
            ball.setDown(true);
        } 
        if (ball.getDown()) {
            ball.setY(y+2);
        } else {
            ball.setY(y-2);
        }
        
        /* Paddle Movement */
        if (pad.getLeft() && pad.getX()>0) {
            pad.setX(pad.getX()-2);
        } 
        if (pad.getRight() && pad.getX()<300) {
            pad.setX(pad.getX()+2);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            pad.setLeft(true);
        } else if (key == KeyEvent.VK_RIGHT) {
            pad.setRight(true);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT) {
            pad.setLeft(false);
        } else if (key == KeyEvent.VK_RIGHT) {
            pad.setRight(false);
        }
    }    
    
    @Override
    public void keyTyped(KeyEvent e) {
        //auto-generated method
    }    
    
    private static void runGUI() {
        Pong pong = new Pong();
        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(pong);
        frame.setSize(360, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runGUI();
            }
        });
    }
}

