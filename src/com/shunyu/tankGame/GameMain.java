package com.shunyu.tankGame;

public class GameMain {

    public static void gameLaunch() throws InterruptedException{
        GameFrame gameFrame = new GameFrame();

//        new Thread(() -> new Audio("audio/war1.wav").loop()).start();

        while(true) {
            Thread.sleep(50);
            gameFrame.repaint();
        }
    }


}
