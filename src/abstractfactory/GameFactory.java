package abstractfactory;

import com.shunyu.tankGame.Dir;
import com.shunyu.tankGame.Group;
import com.shunyu.tankGame.TankFrame;

public abstract class GameFactory {

	public abstract BaseTank createTank(int x, int y, Dir dir , Group group);
	public abstract BaseExplode createExplode(int x, int y, TankFrame dir );
	public abstract BaseBullet createBullet(int x, int y, TankFrame dir );
}
