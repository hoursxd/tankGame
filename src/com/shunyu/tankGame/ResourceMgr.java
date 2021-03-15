package com.shunyu.tankGame;

import com.shunyu.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ResourceMgr {
	public static BufferedImage redTankU, redTankL, redTankR, redTankD;
	public static BufferedImage blueTankU, blueTankL, blueTankR, blueTankD;
	public static BufferedImage bulletL, bulletU, bulletR, bulletD;
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	 
	static {
		try {
			redTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			redTankL = ImageUtil.rotateImage(redTankU, -90);
			redTankR = ImageUtil.rotateImage(redTankU, 90);
			redTankD = ImageUtil.rotateImage(redTankU, 180);
			
			
			blueTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			blueTankL = ImageUtil.rotateImage(blueTankU, -90);
			blueTankR = ImageUtil.rotateImage(blueTankU, 90);
			blueTankD = ImageUtil.rotateImage(blueTankU, 180);
			
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
