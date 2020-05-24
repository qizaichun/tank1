package com.qizc.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: qizaichun
 * @Date: 2020/5/24
 * @Description: com.qizc.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {
    int x = 200;
    int y = 200;
    public TankFrame(){
        setSize(500,600);
        setBackground(Color.RED);
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
        g.fillRect(x,y,50,50);
        x += 10;
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
