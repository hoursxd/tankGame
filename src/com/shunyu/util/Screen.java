package com.shunyu.util;

import java.awt.*;

public class Screen {

    /**
     * 屏幕尺寸工具类
     * @return Pair格式的宽和高
     */
    public static int[] getScreenSize() {

        int[] sizes = new int[2];
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

//        System.out.println("屏幕宽度：" + screenWidth + "，屏幕高度：" + screenHeight);
        sizes[0] = screenWidth;
        sizes[1] = screenHeight;

        return sizes;
    }

}
