package com.shunyu.cor;

import com.shunyu.entity.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider{
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void add(Collider c){
        colliders.add(c);
    }


    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (Collider c:colliders){
            if(!c.collide(o1,o2)){
                return false;
            }
        }
        return true;
    }

}
