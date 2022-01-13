package com.kuang.Swing.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JRadioButtonDemo extends JFrame {
    public JRadioButtonDemo(){
        Container contentPane = this.getContentPane();
        URL url = JButtonDemo.class.getResource("tx.jpg");
        ImageIcon imageIcon = new ImageIcon(url);
        //单选框
        JRadioButton radio1 = new JRadioButton("radio1");
        JRadioButton radio2 = new JRadioButton("radio2");
        JRadioButton radio3 = new JRadioButton("radio3");
        //由于单选框只能选择一个，所以将他们分在一个组
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        contentPane.add(radio1,BorderLayout.CENTER);
        contentPane.add(radio2,BorderLayout.NORTH);
        contentPane.add(radio3,BorderLayout.SOUTH);

        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JRadioButtonDemo();
    }
}
