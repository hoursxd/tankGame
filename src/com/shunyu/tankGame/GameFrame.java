package com.shunyu.tankGame;

import com.shunyu.GameModel.GameModel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static com.shunyu.util.Constans.*;

public class GameFrame extends Frame{

	GameModel gm = GameModel.getInstance();
	DefaultFireStrategy ds = new DefaultFireStrategy();
	Image offScreenImage = null;


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
		int gameState = Control.gameState;
		if(gameState==1){
			gm.paint(g);
		}

	}

	@Override
	public void update(Graphics g) {

		//根据gameState绘制不同的页面
		int gameState = Control.gameState;
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();

		switch (gameState){
			case 0:
			case 2:
			case 3:
				gameMenu(g, gOffScreen);
				break;

			case 1:
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

	private void gameMenu(Graphics g, Graphics gOffScreen) {
		Menu.showMenu(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);

	}

}
