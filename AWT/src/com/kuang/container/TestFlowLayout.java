package com.kuang.container;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //组件
        Button button1 = new Button("button1");
        Button button2 = new Button("button1");
        Button button3 = new Button("button1");
        //设置为流式布局
        //frame.setLayout(new FlowLayout());
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setSize(200,200);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);
    }
}
