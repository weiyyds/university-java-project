package com.kuang.Swing.lesson06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

//测试下拉框
public class TestTextDemo01 extends JFrame {
    public TestTextDemo01(){
        Container contentPane = this.getContentPane();
        JTextField textField1 = new JTextField("hello");
        JTextField textField2= new JTextField("word",20);
        contentPane.add(textField1,BorderLayout.NORTH);
        contentPane.add(textField2,BorderLayout.SOUTH);

        setVisible(true);
        setSize(500,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
