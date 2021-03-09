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
	
	Rectangle rect = new Rectangle();
	
	
	private boolean living = true;
	
	
	

	public Bullet(int x, int y, Dir dir,TankFrame tf,Group group) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
		this.group = group;
		
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
		
		tf.bs.add(this);
		
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
		
		rect.x = x;
		rect.y = y;
		
		
		if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) {
			living = false;
		}
	}
	
	public void collideWith(Tank t) {
		if(this.group == t.getGroup()) return;
		
		if(this.rect.intersects(t.rect)) {
			t.die();
			this.die();
			
			int eX = t.getX() + t.WIDTH/2 - Explode.WIDTH/2;
			int eY = t.getY() + t.HEIGHT/2 - Explode.HEIGHT/2;
			
			
			tf.explodes.add(new Explode(eX,eY,this.tf));
			
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
