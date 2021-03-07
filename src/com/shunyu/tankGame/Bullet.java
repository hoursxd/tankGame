package com.shunyu.tankGame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Frame{
	private static final int SPEED = 10;

	 static final int WIDTH = ResourceMgr.bulletD.getWidth();

	 static final int HEIGHT = ResourceMgr.bulletD.getHeight();
	
	private int x,y;
	private Dir dir;
	private TankFrame tf;
	private Group group;
	
	private boolean living = true;
	
	
	

	public Bullet(int x, int y, Dir dir,TankFrame tf,Group group) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
	}



	@Override
	public void paint(Graphics g) {
		if(!living) tf.bs.remove(this);
		
		
		switch(dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x,y,null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x,y,null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x,y,null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x,y,null);
			break;
		default:
			break;
		}
		
		move();
	}

	private void move() {
		switch(dir) {
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		default:
			break;
		}
		
		if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) {
			living = false;
		}
	}
	
	public void collideWith(Tank t) {
		if(this.group == t.getGroup()) return;
		
		Rectangle rect = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rectTank = new Rectangle(t.getX(),t.getY(),Tank.WIDTH,Tank.HEIGHT);
		
		if(rect.intersects(rectTank)) {
			t.die();
			this.die();
			Explode e = new Explode(t.getX(),t.getY(),this.tf);
			
			new Thread( new Runnable() {
				@Override
				public void run() {
					new Audio("audio/explode.wav").run();
					
				}
			}).start();
			
			
		}
		
	}
	
	private void die() {
		this.living = false;
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
