package com.shunyu.cor;

import com.shunyu.entity.GameObject;
import com.shunyu.tankGame.Bullet;
import com.shunyu.tankGame.Tank;

public class BulletTankCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank)o2;
            if(b.collideWith(t)){
                return false;
            }

        }else if(o2 instanceof Bullet && o1 instanceof Tank){
            Bullet b = (Bullet) o2;
            Tank t = (Tank)o1;
            if(b.collideWith(t)){
                return false;
            }
        }else {
            return true;
        }
        return true;
    }
}
