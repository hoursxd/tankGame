package com.shunyu.tankGame;

import com.shunyu.GameModel.GameModel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.shunyu.util.Constans.*;

public class GameFrame extends Frame{

	GameModel gm = GameModel.getInstance();
	DefaultFireStrategy ds = new DefaultFireStrategy();

	public GameFrame() {
		gameInit();
		gameWindowListener();
	}

	/**
	 * 游戏初始化及相关设置
	 */
	private void gameInit() {
		setSize(GAME_WIDTH, GAME_HEIGHT);
		setLocation(WINDOW_LOCATION_WIDTH, WINDOW_LOCATION_HEIGHT);
		setResizable(false);
		setTitle(GAME_TITLE);
		setVisible(true);

		int State = 0;
	}

	/**
	 * 游戏窗口事件监听
	 */
	private void gameWindowListener() {
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		//游戏按键控制
		Control control = new Control(gm);
		this.addKeyListener(control);

//		this.addKeyListener(new MyKeyListener());
	}

	@Override
	public void paint(Graphics g) {
		gm.paint(g);
	}

	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {

		//根据gameState绘制不同的页面
		int gameState = Control.gameState;

		switch (gameState){
			case 0:
			case 2:
			case 3:
				gameMenu(g);
				break;
			case 1:
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
				break;
			default:
				break;
		}

	}

	private void gameMenu(Graphics g) {
		Menu.showMenu(g);

	}

//	class MyKeyListener extends KeyAdapter{
//		boolean bL = false;
//		boolean bU = false;
//		boolean bR = false;
//		boolean bD = false;
//
//
//		@Override
//		public void keyPressed(KeyEvent e) {
//			int key = e.getKeyCode();
//			switch(key) {
////				case KeyEvent.VK_A:
//				case KeyEvent.VK_LEFT:
//					bL = true;
//					break;
////				case KeyEvent.VK_W:
//				case KeyEvent.VK_UP:
//					bU = true;
//					break;
////				case KeyEvent.VK_D:
//				case KeyEvent.VK_RIGHT:
//					bR = true;
//					break;
////				case KeyEvent.VK_S:
//				case KeyEvent.VK_DOWN:
//					bD = true;
//					break;
//				case KeyEvent.VK_X:
//					gm.getMainTank().fire();
//				default:
//					break;
//			}
//
//			setMainTankDir();
//		}
//
//		private void setMainTankDir() {
//			if(!bR && !bU && !bD && !bL) {
//				gm.getMainTank().setMoving(false);
//			}else{
//				gm.getMainTank().setMoving(true);
//				if(bR) gm.getMainTank().setDir(Dir.RIGHT);
//				if(bL) gm.getMainTank().setDir(Dir.LEFT);
//				if(bD) gm.getMainTank().setDir(Dir.DOWN);
//				if(bU) gm.getMainTank().setDir(Dir.UP);
//			}
//
//
//		}
//
//		@Override
//		public void keyReleased(KeyEvent e) {
//			int key = e.getKeyCode();
//			switch(key) {
//			case KeyEvent.VK_LEFT:
//				bL = false;
//				break;
//			case KeyEvent.VK_UP:
//				bU = false;
//				break;
//			case KeyEvent.VK_RIGHT:
//				bR = false;
//				break;
//			case KeyEvent.VK_DOWN:
//				bD = false;
//				break;
//			default:
//				break;
//			}
//
//			setMainTankDir();
//		}
//
//	}

}
