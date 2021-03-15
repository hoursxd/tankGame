package com.shunyu.tankGame;

import com.shunyu.GameModel.GameModel;
import com.shunyu.util.Audio;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.shunyu.util.Constans.MENUS;

/**
 * 游戏按键控制类，根据不同的gameState使用不同的按键规则
 */
public class Control extends KeyAdapter {

    //菜单选择器
    public static int selector = 0;
    public static int gameState = 0;

    GameModel gm;

    boolean bL = false;
    boolean bU = false;
    boolean bR = false;
    boolean bD = false;

    public Control(GameModel gm) {
        this.gm = gm;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        /**
         * gameState默认是0 菜单
         * 1 单人游戏
         * 2 多人游戏
         * 根据游戏菜单的selector改变
         */

        switch (gameState) {
            case 0:
                menuControl(key);
                break;
            case 1:
                singleControl(key);
                break;
            default:
                break;
        }
    }

    /**
     * 菜单页面键盘控制
     * @param key 获取的按键
     */
    private void menuControl(int key) {

        switch (key) {
            case KeyEvent.VK_UP:

            case KeyEvent.VK_W:
                selector--;
                if (selector < 0) {
                    selector = MENUS.length - 1;
                }
                btnSound(1);
                break;

            case KeyEvent.VK_DOWN:

            case KeyEvent.VK_S:
                selector++;
                if (selector > MENUS.length - 1) {
                    selector = 0;
                }
                btnSound(1);
                break;

            case KeyEvent.VK_ENTER:
                btnSound(2);
                gameState = selector + 1;
//                menuEnter(gameState);
                break;
            default:
                break;
        }
    }

    /**
     * 单人游戏页面键盘控制
     * @param key 获取的按键
     */
    private void singleControl(int key) {
        switch (key) {
            case KeyEvent.VK_A:
//                System.out.println("-a-");
            case KeyEvent.VK_LEFT:
                bL = true;
                break;

            case KeyEvent.VK_W:
//                System.out.println("-w-");
            case KeyEvent.VK_UP:
                bU = true;
                break;

            case KeyEvent.VK_D:
//                System.out.println("-d-");
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;

            case KeyEvent.VK_S:
//                System.out.println("-s-");
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

    /**
     * 坦克方向设置 可能需要移动位置，疑似存在bug
     */
    public void setMainTankDir() {
        if (!bR && !bU && !bD && !bL) {
            gm.getMainTank().setMoving(false);
        } else {
            gm.getMainTank().setMoving(true);
            if (bR) gm.getMainTank().setDir(Dir.RIGHT);
            if (bL) gm.getMainTank().setDir(Dir.LEFT);
            if (bD) gm.getMainTank().setDir(Dir.DOWN);
            if (bU) gm.getMainTank().setDir(Dir.UP);
        }
    }

    /**
     * 按键声音播放
     * @param opt 按键的音效模式
     *            1 选择
     *            2 进入
     */
    public void btnSound(int opt) {
        switch (opt) {
            case 1:
                new Thread(() -> new Audio("audio/btn_select.wav").play()).start();
                break;
            case 2:
                new Thread(() -> new Audio("audio/btn_enter.wav").play()).start();
                break;

        }

    }


}
