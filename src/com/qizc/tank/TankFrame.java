package com.qizc.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: qizaichun
 * @Date: 2020/5/24
 * @Description: com.qizc.tank
 * @version: 1.0
 */
public class TankFrame extends Frame {
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
    }

    @Override
    public void paint(Graphics g) {
        g.fillRect(200,200,50,50);
    }
}
