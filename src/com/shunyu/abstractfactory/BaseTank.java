package com.shunyu.abstractfactory;

import com.shunyu.tankGame.Group;

import java.awt.*;

public abstract class BaseTank {
    public Rectangle rect = new Rectangle();
    public Group group;

    public abstract void paint(Graphics g);

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
