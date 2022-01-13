package com.kuang.container;

import java.awt.*;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Panel可以看出一个空间，但是不能单独存在
public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //布局的概念
        Panel panel = new Panel();
        //设置布局
        frame.setLayout(null);
        //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(74, 92, 146));
        //Panel设置坐标，相对于frame位置
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(106, 146, 48));
        frame.add(panel);
        frame.setVisible(true);
        //监听事件，监听窗口关闭
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
