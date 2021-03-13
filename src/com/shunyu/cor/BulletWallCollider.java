package com.shunyu.cor;

import com.shunyu.entity.GameObject;
import com.shunyu.entity.Wall;
import com.shunyu.tankGame.Bullet;
import com.shunyu.tankGame.Tank;

public class BulletWallCollider implements Collider{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet b = (Bullet) o1;
            Wall t = (Wall)o2;
            if(b.rect.intersects(t.rect)){
                b.die();
            }
        }else if(o2 instanceof Bullet && o1 instanceof Wall){
            return collide(o2,o1);
        }
        return true;
    }
}
