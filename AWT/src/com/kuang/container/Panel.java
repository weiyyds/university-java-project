package com.kuang.container;

import java.awt.*;

public class Panel {
    public static void main(String[] args) {
        //1.创建window对象，因为Panel以及其他容器必须依附于window存在
        Frame frame = new Frame("这里演示Panel");
        //2.创建一个Panel对象
        java.awt.Panel p=new java.awt.Panel();
        //3.创建一个文本框和按钮，并且把它们放到Panel
        p.add(new TextField("这是文本框"));
        p.add(new Button("这里是一个测试按钮"));
        //4.把Panel放到Window中
        frame.add(p);
        //5.设置Window的位置大小
        frame.setBounds(100,100,500,300);
        //6.设置Window可见
        frame.setVisible(true);


    }
}
