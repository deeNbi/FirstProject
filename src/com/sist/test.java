package com.sist;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class test {

    public int x, y;
    private Image img;

    public int time = 0;
    public int timer = 100;
    public boolean remove;

    public float alpha = 1f;

    public test(int x, int y) {
        this.x = x;
        this.y = y;

        alpha = 1f;
    }

    public void tick() {
        if (time >= timer) {
            time = 0;
            // remove = true;
        } else {
            time++;
        }
        if (alpha > 2) {
            // alpha--;
        } else {
            // remove = true;
        }

    }

    public void render(Graphics g) {

        ImageIcon i2 = new ImageIcon("res/items/poo.png");
        img = i2.getImage();

        g.drawImage(img, x, y,6,8, null);


    }
}




