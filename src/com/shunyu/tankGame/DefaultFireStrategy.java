package com.shunyu.tankGame;

public class DefaultFireStrategy implements FireStrategy{

	@Override
	public void fire(Tank t) {
		// TODO Auto-generated method stub
		
		int bx = t.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
		int by = t.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
		
		new Bullet(bx,by,t.dir,t.tf,t.group);
		
	
		
	}

}
