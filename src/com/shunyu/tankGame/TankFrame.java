package com.shunyu.tankGame;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.Color;

public class TankFrame extends Frame{

	static final int GAME_WIDTH = 800;
	static final int GAME_HEIGHT = 600;
	ArrayList<Bullet> bs = new ArrayList<>();
	ArrayList<Tank> tanks = new ArrayList<>();
	
	Tank t = new Tank(200,200,Dir.DOWN,this,Group.BLUE);
	
	
	public TankFrame() {
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setResizable(false);
		setTitle("USYD Tank");
		setVisible(true);
		
		this.addKeyListener(new MyKeyListener());
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		t.paint(g);  
		for(int i = 0; i<bs.size();i++) {
			bs.get(i).paint(g);
		}
		
		for(int i = 0; i<tanks.size();i++) {
			tanks.get(i).paint(g);
		}
		
		for(int i = 0; i<bs.size() ; i++) {
			for(int j = 0; j<tanks.size() ; j++) {
				bs.get(i).collideWith(tanks.get(j));
			}
		}
	}
	
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class MyKeyListener extends KeyAdapter{
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;
		
		
		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;
			case KeyEvent.VK_X:
				t.fire();
			default:
				break;
			}
			
			setMainTankDir();
		}

		private void setMainTankDir() {
			if(!bR && !bU && !bD && !bL) {
				t.setMoving(false);
			}else{
				t.setMoving(true);
				if(bR) t.setDir(Dir.RIGHT);
				if(bL) t.setDir(Dir.LEFT);
				if(bD) t.setDir(Dir.DOWN);
				if(bU) t.setDir(Dir.UP);
			}
			
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;
			default:
				break;
			}
			
			setMainTankDir();
		}
		
	}

}
