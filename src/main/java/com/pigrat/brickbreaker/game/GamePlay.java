package com.pigrat.brickbreaker.game;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 0;
    private int playerX =310;
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballXDir =-1;
    private int ballYDir = -2;
    private MapGenerator map;

    public GamePlay(){
        map = new MapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
        timer.start();
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(1,1,692,592);
        map.draw((Graphics2D) g);
        g.setColor(Color.yellow);
        g.fillRect(0,0,3,592);
        g.fillRect(0,0,692,3);
        g.fillRect(691,0,3,592);

        g.setColor(Color.white);
        g.setFont(new Font("serif",Font.BOLD,25));
        g.drawString(""+score,590,30);

        g.setColor(Color.yellow);
        g.fillRect(playerX, 550, 100, 0);

        g.setColor(Color.GREEN);
        g.fillOval(ballPosX, ballPosY, 20, 20);

        if (ballPosY>570){
            play=false;
            ballXDir=0;
            ballYDir=0;
            g.setColor(Color.red);
            g.setFont(new Font("serif",Font.BOLD,20));
            g.drawString("Game Over Score; "+score,190,300);

            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Press Enter to Restart ",190,340);
        }

        if (totalBricks==0){
            play=false;
            ballYDir=-2;
            ballXDir=-1;
            g.setColor(Color.red);
            g.setFont(new Font("serif", Font.BOLD,30));
            g.drawString("Game Over Score; "+score,190,300);

            g.setFont(new Font("serif",Font.BOLD,30));
            g.drawString("Press Enter to Restart ",190,340);

        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    public void moveRight(){
        play=true;
        playerX+=20;
    }

    public void moveLeft(){
        play=true;
        playerX-=20;
    }
}
