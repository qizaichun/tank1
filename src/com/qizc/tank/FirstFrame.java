package com.qizc.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Auther: qizaichun
 * @Date: 2020/5/24
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class FirstFrame {
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new TankFrame();

        while (true){
            Thread.sleep(1000);
            frame.repaint();
        }
    }
}
