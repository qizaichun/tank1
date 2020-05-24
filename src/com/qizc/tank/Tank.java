package com.qizc.tank;

import java.awt.*;

/**
 * @Auther: qizaichun
 * @Date: 2020/5/24
 * @Description: com.qizc.tank
 * @version: 1.0
 */
public class Tank {
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;
    private boolean moving = false;
    private TankFrame tankFrame = null;

    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,50,50);
        g.setColor(color);
        move();
    }

    private void move(){
        if (!moving) return;
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
    }

    public void fire() {
        tankFrame.bulletList.add(new Bullet(x,y,dir,tankFrame));
    }
}
