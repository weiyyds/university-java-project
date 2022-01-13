package com.kuang.Swing.lesson04;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
    public void init(){
        JFrame frame = new JFrame("JFrame窗口");
        frame.setVisible(true);
        frame.setBounds(100,100,200,200);

        //设置文字
        JLabel label = new JLabel("欢迎来到德莱联盟");
        frame.add(label);
        //让文本水平居中
        label.setHorizontalAlignment(SwingConstants.CENTER);
        //获得一个容器
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.BLUE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        //建立一个窗口
        new JFrameDemo().init();
    }
}
