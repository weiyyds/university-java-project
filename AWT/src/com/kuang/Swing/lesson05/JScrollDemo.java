package com.kuang.Swing.lesson05;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo(){
        Container contentPane = this.getContentPane();
        //文本域
        JTextArea text = new JTextArea(20,20);
        text.setText("欢迎学习狂神说java");
        //Scroll面板
        JScrollPane jScrollPane = new JScrollPane(text);
        contentPane.add(jScrollPane);
        this.setVisible(true);
        this.setBounds(100,100,300,350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
