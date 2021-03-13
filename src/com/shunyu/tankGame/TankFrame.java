package com.shunyu.tankGame;

import com.shunyu.GameModel.GameModel;

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

	GameModel gm = GameModel.getInstance();

	static final int GAME_WIDTH = 1080;
	static final int GAME_HEIGHT = 720;

	DefaultFireStrategy ds = new DefaultFireStrategy(); 



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
		gm.paint(g);
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
				gm.getMainTank().fire();
			default:
				break;
			}
			
			setMainTankDir();
		}

		private void setMainTankDir() {
			if(!bR && !bU && !bD && !bL) {
				gm.getMainTank().setMoving(false);
			}else{
				gm.getMainTank().setMoving(true);
				if(bR) gm.getMainTank().setDir(Dir.RIGHT);
				if(bL) gm.getMainTank().setDir(Dir.LEFT);
				if(bD) gm.getMainTank().setDir(Dir.DOWN);
				if(bU) gm.getMainTank().setDir(Dir.UP);
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
