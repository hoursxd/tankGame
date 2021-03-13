package com.shunyu.cor;

import com.shunyu.entity.GameObject;
import com.shunyu.entity.Wall;
import com.shunyu.tankGame.Bullet;
import com.shunyu.tankGame.Tank;

public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Wall && o2 instanceof Tank){
            Wall b = (Wall) o1;
            Tank t = (Tank) o2;
            if(b.rect.intersects(t.rect)){
                t.back();
            }
        }else if(o2 instanceof Wall && o1 instanceof Tank){
            return collide(o2,o1);
        }
        return true;
    }
}
