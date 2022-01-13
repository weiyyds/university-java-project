package com.kuang.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//测试动作事件
public class TestActionEvent {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //按下一个按钮，触发一些事件
        Button button = new Button();
        //匿名内部类
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aaaa");
            }
        });
        frame.add(button,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        windowClose(frame);
    }
    //关闭窗体事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
              System.exit(0);
            }
        });
    }
}
