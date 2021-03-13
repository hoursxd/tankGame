//package com.shunyu.abstractfactory;
//
//import com.shunyu.GameModel.GameModel;
//import com.shunyu.tankGame.Bullet;
//import com.shunyu.tankGame.Dir;
//import com.shunyu.tankGame.Explode;
//import com.shunyu.tankGame.Group;
//import com.shunyu.tankGame.Tank;
//import com.shunyu.tankGame.TankFrame;
//
//public class DefaultFactory extends GameFactory	{
//
//	@Override
//	public BaseTank createTank(int x, int y, Dir dir, Group group , GameModel gm) {
//		// TODO Auto-generated method stub
//		return new Tank(x,y,dir,gm,group);
//	}
//
//	@Override
//	public BaseExplode createExplode(int x, int y, GameModel gm) {
//		// TODO Auto-generated method stub
//		return new Explode(x,y,gm);
//	}
//
//	@Override
//	public BaseBullet createBullet(int x, int y, Dir dir, GameModel gm, Group group ) {
//		// TODO Auto-generated method stub
//		return new Bullet(x,y,dir,gm,group);
//	}
//
//}
