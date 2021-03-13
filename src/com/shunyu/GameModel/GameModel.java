package com.shunyu.GameModel;

import com.shunyu.cor.BulletTankCollider;
import com.shunyu.cor.Collider;
import com.shunyu.cor.ColliderChain;
import com.shunyu.cor.TankTankCollider;
import com.shunyu.entity.GameObject;
import com.shunyu.entity.Wall;
import com.shunyu.tankGame.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private static final GameModel INSTANCE = new GameModel();
//    public ArrayList<Bullet> bs = new ArrayList<>();
//    public ArrayList<Tank> tanks = new ArrayList<>();
//    public ArrayList<Explode> explodes = new ArrayList<>();
    public static GameModel getInstance(){
        return INSTANCE;
    }

    static {
        INSTANCE.init();
    }

    ColliderChain colliderChain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    private GameModel() {
    }
    Tank t ;
    public void init() {
         t = new Tank(200,200, Dir.DOWN, Group.BLUE);
        for(int i = 0; i<10 ;++i) {
            add(new Tank(50+80*i,50,Dir.DOWN,Group.RED));
        }

        add(new Wall(150,150,200, 50));
        add(new Wall(550,150,200, 50));
        add(new Wall(300,300,50, 200));
        add(new Wall(550,300,50, 200));
    }

    public void  add(GameObject go){
        this.objects.add(go);
    }

    public void  remove(GameObject go){
        this.objects.remove(go);
    }

    public void paint(Graphics g){
        t.paint(g);

        for(int i = 0; i<objects.size();i++) {
            objects.get(i).paint(g);
        }

//        for(int i = 0; i<tanks.size();i++) {
//            tanks.get(i).paint(g);
//        }
//
//        for(int i = 0; i<explodes.size();i++) {
//            explodes.get(i).paint(g);
//        }

        for(int i = 0; i<objects.size() ; i++) {
            for(int j = i+1; j<objects.size() ; j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                colliderChain.collide(o1,o2);
            }


        }
    }

    public Tank getMainTank() {
        return t;
    }
}
