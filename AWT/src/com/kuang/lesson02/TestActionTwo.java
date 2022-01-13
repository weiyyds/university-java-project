package com.kuang.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionTwo {
    public static void main(String[] args) {
        //两个按钮，实现同一个监听
        //开始  停止
        Frame frame = new Frame("开始-停止");
        Button start = new Button("start");
        Button stop = new Button("stop");
        stop.setActionCommand("button-stop");
        MyMonitor myMonitor = new MyMonitor();
        start.addActionListener(myMonitor);
        stop.addActionListener(myMonitor);

        frame.add(start,BorderLayout.NORTH);
        frame.add(stop,BorderLayout.SOUTH);
        frame.pack();//自适应
        frame.setVisible(true);
    }
}
class MyMonitor implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了:msg"+e.getActionCommand());

    }
}
