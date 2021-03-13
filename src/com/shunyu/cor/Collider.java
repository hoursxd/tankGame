package com.shunyu.cor;

import com.shunyu.entity.GameObject;

public interface Collider {

    boolean  collide(GameObject o1,GameObject o2);
}
