package com.kuang.container;

import java.awt.*;

public class Window {
    public static void main(String[] args) {
        //创建一个窗口对象
        Frame frame=new Frame("这是测试window窗口");
        //设置窗口位置，大小
        frame.setLocation(100,100);
        frame.setSize(500,300);
        //设置窗口可见
        frame.setVisible(true);

    }
}
