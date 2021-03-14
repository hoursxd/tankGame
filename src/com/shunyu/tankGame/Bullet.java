package com.shunyu.tankGame;

import com.shunyu.GameModel.GameModel;
import com.shunyu.entity.GameObject;
import com.shunyu.util.Audio;
import com.shunyu.util.Constans;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject {
	private static final int SPEED = 10;

	static final int WIDTH = ResourceMgr.bulletD.getWidth();
	static final int HEIGHT = ResourceMgr.bulletD.getHeight();

	private int x,y;
	private Dir dir;
	private Group group;

	public Rectangle rect = new Rectangle();


	private boolean living = true;

	GameModel gm ;


	public Bullet(int x, int y, Dir dir, Group group) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.gm = GameModel.getInstance();
		this.group = group;


		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;

		gm.add(this);

	}



	@Override
	public void paint(Graphics g) {
		if(!living) {
			gm.remove(this);
		}


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


		if(x<0||y<0||x> Constans.GAME_WIDTH||y> Constans.GAME_HEIGHT) {
			living = false;
		}
	}

	public boolean collideWith(Tank t) {
		if(this.group == t.group) {
			return false;
		}

		if(this.rect.intersects(t.rect)) {
			t.die();
			this.die();

			int eX = t.getX() + Tank.WIDTH /2 - Explode.WIDTH/2;
			int eY = t.getY() + Tank.HEIGHT /2 - Explode.HEIGHT/2;


			gm.add(new Explode(eX,eY));


			new Thread( new Runnable() {
				@Override
				public void run() {
					new Audio("audio/explode.wav").run();

				}
			}).start();
			return true;

		}

		return false;
	}

	public void die() {
		this.living = false;

	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
