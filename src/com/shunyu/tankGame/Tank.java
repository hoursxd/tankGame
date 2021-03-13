package com.shunyu.tankGame;

import com.shunyu.GameModel.GameModel;
import com.shunyu.entity.GameObject;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
	
	private static final int SPEED = 5;
	
	static final int WIDTH = ResourceMgr.redTankU.getWidth();
	static final int HEIGHT = ResourceMgr.redTankU.getHeight();
	
	int x;

	int y;

	int oldX , oldY;

	public Rectangle rect = new Rectangle();
	public Group group;
	Dir dir = Dir.DOWN;
	TankFrame tf;

	private Random random = new Random();

	FireStrategy ds = new FourDirFireStrategy(); 
	
	private boolean moving = true;
	private boolean living = true;
	GameModel gm= GameModel.getInstance();;
	
	public Tank(int x, int y, Dir dir, Group group) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		
		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;

	}


	@Override
	public void paint(Graphics g) {
		if(!living) gm.remove(this);
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
		oldX = x;
		oldY = y;

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
		
		ds.fire(this);
		
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


	public void die() {
		this.living = false;

	}

	public void back() {
		x = oldX ;
		y = oldY ;

	}


}
