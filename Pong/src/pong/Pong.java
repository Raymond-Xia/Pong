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
        
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {    
        checkAndMove(ball);
        repaint();
    }
    
    public void checkAndMove(Ball r) {
        int x = r.getX();
        int y = r.getY();
        boolean right = r.getRight();
        boolean down = r.getDown();
        
        if (right) {
            if (x+r.getWidth() >= super.getWidth() /*|| (y>r2.getY() && y<r2.getY()+50 || y+50>r2.getY() && y+50<r2.getY()+50) && x+50 >= r2.getX()*/) {
                r.setRight(false);
            } else {
                r.setX(x+2);
            }   
        } else {
            if (x <= 0 /*|| (y>r2.getY() && y<r2.getY()+50 || y+50>r2.getY() && y+50<r2.getY()+50) && x+50 <= r2.getX()*/) {
                r.setRight(true);
            } else {
                r.setX(x-2);
            }
        }
        
        if (y+25 >= super.getHeight()) {
            r.setDown(false);
        } else if (y <= 0) {
            r.setDown(true);
        } 
        if (down) {
            r.setY(y+2);
        } else {
            r.setY(y-2);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("jeffery");
        if (key == KeyEvent.VK_LEFT) {
            pad.setX(pad.getX()-1);
        } else if (key == KeyEvent.VK_RIGHT) {
            pad.setX(pad.getX()+1);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        //auto-generated method
    }    
    @Override
    public void keyTyped(KeyEvent e) {
        //auto-generated method
    }    
    
    private static void runGUI() {
        Pong pong = new Pong();
        JFrame frame = new JFrame("BouncingScreenSaver");
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

