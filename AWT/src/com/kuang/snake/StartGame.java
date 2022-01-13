package com.kuang.snake;

import javax.swing.*;

/**游戏的主启动类*/
public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("贪吃蛇小游戏");
        frame.setResizable(false);//设置窗口不可变
        frame.setBounds(10,10,900,720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //游戏界面都应该在面板上
        frame.add(new GamePanel());

        frame.setVisible(true);
    }
}

