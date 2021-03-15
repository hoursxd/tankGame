package com.shunyu.tankGame;

import java.awt.*;

import static com.shunyu.util.Constans.*;

public class Menu {


    /**
     * 游戏菜单显示
     * @param gOffScreen
     */
    public static void showMenu(Graphics gOffScreen){

        int selector = Control.selector;
        int gameState = Control.gameState;

        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        Image bgImage = Toolkit.getDefaultToolkit().getImage("src/images/tank_bg_gray.jpg");
        gOffScreen.drawImage(bgImage, 0, 0, null);

        gOffScreen.setColor(Color.WHITE);
        gOffScreen.setFont(new Font("宋体", Font.BOLD, 28));

        for (int i = 0; i < MENUS.length; i++) {
            if (i == selector) {
                gOffScreen.setColor(Color.RED);
            } else {
                gOffScreen.setColor(Color.WHITE);
            }
            gOffScreen.drawString(MENUS[i], 480, i * 50 + 300);
        }
    }

}
