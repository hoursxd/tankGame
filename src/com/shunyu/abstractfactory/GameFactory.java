package com.shunyu.abstractfactory;

import com.shunyu.GameModel.GameModel;
import com.shunyu.tankGame.Dir;
import com.shunyu.tankGame.Group;
import com.shunyu.tankGame.TankFrame;

public abstract class GameFactory {

	public abstract BaseTank createTank(int x, int y, Dir dir, Group group , GameModel gm);
	public abstract BaseExplode createExplode(int x, int y, GameModel gm );
	public abstract BaseBullet createBullet(int x, int y, Dir dir, GameModel gm, Group group);
}
