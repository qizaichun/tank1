package com.qizc.tank;

import java.awt.*;

/**
 * @Auther: qizaichun
 * @Date: 2020/5/24
 * @Description: com.qizc.tank
 * @version: 1.0
 */
public class Bullet {
    private int x;
    private int y;
    private Dir dir;
    private static final int SPEED = 1;
    private static final int WEITH = 30;
    private static final int HEIGHT = 30;
    private boolean live = true;
    private TankFrame tankFrame= null;

    public Bullet(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        if (!live)
            tankFrame.bulletList.remove(this);
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y, WEITH,HEIGHT);
        g.setColor(color);
        move();

    }

    private void move() {
        switch (dir){
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }

        if (x <0 || y < 0 || x > TankFrame.GAME_HEIGHT || y > TankFrame.GAME_HEIGHT) live = false;
    }
}
