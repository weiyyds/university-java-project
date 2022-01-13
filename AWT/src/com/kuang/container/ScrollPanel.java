package com.kuang.container;

import java.awt.*;

public class ScrollPanel {
    public static void main(String[] args) {
        //创建一个窗口对象
        Frame frame=new Frame("这是测试ScrollPanel窗口");
        //2.创建ScrollPanel对象
        ScrollPane scrollPane = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
        //3.往ScrollPanel添加文本框和按钮
        scrollPane.add(new TextField("这是文本"));
        scrollPane.add(new Button("这是按钮"));
        //4.把ScrollPanel加入到Window中
        frame.add(scrollPane);
        //5.设置Window的位置大小
        frame.setBounds(100,100,500,300);
        //设置窗口可见
        frame.setVisible(true);
    }
}
