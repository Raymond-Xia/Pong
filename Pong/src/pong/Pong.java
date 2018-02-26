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
        g2d.fillOval(ball.getX(), ball.getY(), ball.getLength(), ball.getWidth());
        
        g2d.setColor(Color.black);
        g2d.fillRect(pad.getX(), pad.getY(), pad.getWidth(), pad.getHeight());
        System.out.println(pad.getX());
        
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {    
        checkAndMove();
        repaint();
    }
    
    public void checkAndMove() {
        int x = ball.getX();
        int y = ball.getY();
        
        if (ball.getRight()) {
            if (x+ball.getWidth() >= super.getWidth() /*|| (y>r2.getY() && y<r2.getY()+50 || y+50>r2.getY() && y+50<r2.getY()+50) && x+50 >= r2.getX()*/) {
                ball.setRight(false);
            } else {
                ball.setX(x+2);
            }   
        } else {
            if (x <= 0 /*|| (y>r2.getY() && y<r2.getY()+50 || y+50>r2.getY() && y+50<r2.getY()+50) && x+50 <= r2.getX()*/) {
                ball.setRight(true);
            } else {
                ball.setX(x-2);
            }
        }
        
        if (y+25 >= 260 && x+12>=pad.getX() && x+12<=pad.getX()+pad.getWidth()) {
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
            pad.setX(pad.getX()-3);
        } 
        if (pad.getRight() && pad.getX()<300) {
            pad.setX(pad.getX()+3);
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

