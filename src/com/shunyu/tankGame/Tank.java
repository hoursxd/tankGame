package com.shunyu.tankGame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank extends Frame{
	
	private static final int SPEED = 5;
	
	static final int WIDTH = ResourceMgr.redTankU.getWidth();
	static final int HEIGHT = ResourceMgr.redTankU.getHeight();
	
	private int x,y;
	private Dir dir = Dir.DOWN;
	private TankFrame tf;
	private Group group;
	private Random random = new Random();
	Rectangle rect = new Rectangle();
	
	private boolean moving = true;
	private boolean living = true;
	
	
	public Tank(int x, int y, Dir dir,TankFrame tf,Group group) {
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
		
		this.repaint();
	}


	@Override
	public void paint(Graphics g) {
		if(!living) tf.tanks.remove(this);
		switch(dir) {
		case LEFT:
			g.drawImage(group==Group.BLUE? ResourceMgr.blueTankL : ResourceMgr.redTankL, x,y,null);
			break;
		case RIGHT:
			g.drawImage(group==Group.BLUE? ResourceMgr.blueTankR : ResourceMgr.redTankR, x,y,null);
			break;
		case UP:
			g.drawImage(group==Group.BLUE? ResourceMgr.blueTankU : ResourceMgr.redTankU, x,y,null);
			break;
		case DOWN:
			g.drawImage(group==Group.BLUE? ResourceMgr.blueTankD : ResourceMgr.redTankD, x,y,null);
			break;
		default:
			break;
		}
		
		move();
	}
	

	public Group getGroup() {
		return group;
	}


	public void setGroup(Group group) {
		this.group = group;
	}

	private void move() {
		
		if(!moving) return;
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
		
		if(this.group == Group.RED && random.nextInt(100) > 95) 
			this.fire();
		
		if(this.group == Group.RED && random.nextInt(100) > 95)
			randomDir();
		
		rect.x = x;
		rect.y = y;
		
		boundsCheck();
		
	}
	
	private void randomDir() {
		
		this.dir = Dir.values()[random.nextInt(4)];
	}


	private void boundsCheck() {
		if(this.x<0) x=0;
		if(this.y<30) y = 30;
		if(this.x>TankFrame.GAME_WIDTH - Tank.WIDTH) x=TankFrame.GAME_WIDTH- Tank.WIDTH;
		if(this.y>TankFrame.GAME_HEIGHT - Tank.HEIGHT) y=TankFrame.GAME_HEIGHT- Tank.HEIGHT;
	}


	public void fire() {
		
		int bx = this.x + WIDTH/2 - Bullet.WIDTH/2;
		int by = this.y + HEIGHT/2 - Bullet.HEIGHT/2;
		
		tf.bs.add(new Bullet(bx,by,this.dir,tf,this.group));
		
	}

	public boolean isMoving() {
		return moving;
	}


	public void setMoving(boolean moving) {
		this.moving = moving;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Dir getDir() {
		return dir;
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public void die() {
		this.living = false;
		
	}



}
