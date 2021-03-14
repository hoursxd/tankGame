package com.shunyu.tankGame;

import java.awt.Graphics;

import com.shunyu.GameModel.GameModel;
import com.shunyu.entity.GameObject;

public class Explode extends GameObject {

	static final int WIDTH = ResourceMgr.explodes[0].getWidth();

	static final int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	private int x,y;
	private boolean living = true;
	GameFrame tf = null;
	
	private int step = 0;

	GameModel gm;
	public Explode(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.gm = GameModel.getInstance();
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(ResourceMgr.explodes[step++],x,y,null);
		
		if(step >= ResourceMgr.explodes.length) {
			gm.remove(this);
		}
		
	}
	
	

}
