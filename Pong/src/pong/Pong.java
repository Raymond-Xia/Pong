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
    Random rand;
    
    public Pong() {
        
        ball = new Ball(1, 1, true, true);
        pad = new Paddle();
                
        rand = new Random();
        
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
        g2d.fillRect((int)ball.getX(), (int)ball.getY(), ball.getRadius()*2, ball.getRadius()*2);
        
        g2d.setColor(Color.black);
        g2d.fillRect(pad.getX(), pad.getY(), pad.getLength(), pad.getWidth());
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {    
        checkAndMove();
        repaint();
    }
    
    public void checkAndMove() {
        double x = ball.getX();
        double y = ball.getY();
        int r = ball.getRadius();
        
        /* Ball X-Movement */
        if (x+r*2 >= super.getWidth() || x <= 0 || x+r*2>=pad.getX() && x+r*2<=pad.getX()+pad.getLength() && y+r>=pad.getY() && y+r <= pad.getY()+pad.getWidth()) {
            ball.setDirection((Math.PI-ball.getDirection())%(2*Math.PI));  
            ball.setX(x+ball.getSpeed()*Math.cos(ball.getDirection()));
        }
        ball.setX(x+ball.getSpeed()*Math.cos(ball.getDirection()));
        
        /* Ball Y-Movement */
        if (y+r*2 >= super.getHeight() || y <= 0 || x+r>=pad.getX() && x+r<=pad.getX()+pad.getLength() && y+r*2>=pad.getY()) {
            ball.setDirection((2*Math.PI-ball.getDirection())%(2*Math.PI));
        }
        ball.setY(y-ball.getSpeed()*Math.sin(ball.getDirection()));
        
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

