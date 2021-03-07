package com.shunyu.tankGame;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage BulletL, BulletU, BulletR, BulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	 
	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			
			
			BulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BulletL.gif"));
			BulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BulletU.gif"));
			BulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BulletR.gif"));
			BulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BulletD.gif"));
			
			
			for(int i =1;i<=explodes.length;i++) {
				explodes[i-1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+"i"+".gif"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
