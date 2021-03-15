package com.shunyu.tankGame;

import java.awt.*;

import static com.shunyu.util.Constans.*;

public class Menu {


    /**
     * 游戏菜单显示
     * @param g
     */
    public static void showMenu(Graphics g){

        int selector = Control.selector;
        int gameState = Control.gameState;

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        Image bgImage = Toolkit.getDefaultToolkit().getImage("src/images/tank_bg_gray.jpg");
        g.drawImage(bgImage, 0, 0, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("宋体", Font.BOLD, 28));

        for (int i = 0; i < MENUS.length; i++) {
            if (i == selector) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.WHITE);
            }
            g.drawString(MENUS[i], 480, i * 50 + 300);
        }
    }

}
