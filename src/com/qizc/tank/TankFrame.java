package com.qizc.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * @Auther: qizaichun
 * @Date: 2020/5/24
 * @Description: com.qizc.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,200,Dir.DOWN,this);
    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    public static final int GAME_WIDTH = 500,GAME_HEIGHT = 600;

    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("起在春");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量："+bulletList.size(),10,60);
        g.setColor(color);
        myTank.paint(g);
        for (int i=0;i<bulletList.size();i++){
            bulletList.get(i).paint(g);
        }
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(color);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case  KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case  KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                default:
                    break;
            }
            setMainDir();
        }

        private void setMainDir() {
            if (!bL && !bR && !bD && !bU){
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
                if (bU) myTank.setDir(Dir.UP);
                if (bD) myTank.setDir(Dir.DOWN);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bL) myTank.setDir(Dir.LEFT);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case  KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case  KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                default:
                    break;
            }
            myTank.fire();
            setMainDir();
        }
    }
}
