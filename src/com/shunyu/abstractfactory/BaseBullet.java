package com.shunyu.abstractfactory;

import java.awt.*;

public abstract class BaseBullet{
    public abstract void paint(Graphics g);
    public abstract void collideWith(BaseTank t);
    public abstract void die();
}
