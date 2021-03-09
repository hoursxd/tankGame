package com.shunyu.tankGame;

import java.awt.Frame;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		TankFrame f = new TankFrame();
		
		
		for(int i = 0; i<10 ;++i) {
			f.tanks.add(new Tank(50+80*i,50,Dir.DOWN, f,Group.RED));
			
		}
		
		new Thread(() -> new Audio("audio/war1.wav").loop()).start();
		
		while(true) {
			Thread.sleep(50);
			f.repaint();
		}
 
	}

}
