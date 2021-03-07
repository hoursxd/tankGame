package com.shunyu.tankGame;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {
	public static BufferedImage tankL, tankU, tankR, tankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	 
	static {
		try {
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			tankL = ImageUtil.rotateImage(tankU, -90);
			tankR = ImageUtil.rotateImage(tankU, 90);
			tankD = ImageUtil.rotateImage(tankU, 180);
			
			
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
			bulletL = ImageUtil.rotateImage(bulletU, -90);
			bulletR = ImageUtil.rotateImage(bulletU, 90);
			bulletD = ImageUtil.rotateImage(bulletU, 180);
			
			
			for(int i =1;i<=explodes.length;i++) {
				explodes[i-1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+i+".gif"));
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
