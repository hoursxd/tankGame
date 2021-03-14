package com.shunyu.util;

/**
* 常量类
*
 */
public class Constans {

    public static final int GAME_WIDTH = 1080;
    public static final int GAME_HEIGHT = 720;

    public static final String GAME_TITLE = "USYD TANK";

    public static final int SCREEN_WIDTH = Screen.getScreenSize()[0];
    public static final int SCREEN_HEIGHT = Screen.getScreenSize()[1];

    public static final int WINDOW_LOCATION_WIDTH = SCREEN_WIDTH - GAME_WIDTH >> 1;
    public static final int WINDOW_LOCATION_HEIGHT = SCREEN_HEIGHT - GAME_HEIGHT >> 1;

    /**
     * 游戏状态：
     * 0 菜单
     * 1 单人游戏
     * 2 多人游戏
     * 3 设置
     */
    public static final int GAME_STATE = 0;

    public static final String[] MENUS = { "单人游戏", "多人游戏", "设置选项", "退出游戏" };





}
