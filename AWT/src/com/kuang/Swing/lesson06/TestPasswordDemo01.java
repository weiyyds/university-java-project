package com.kuang.Swing.lesson06;

import javax.swing.*;
import java.awt.*;

//测试下拉框
public class TestPasswordDemo01 extends JFrame {
    public TestPasswordDemo01(){
        Container contentPane = this.getContentPane();
        JPasswordField passwordField = new JPasswordField();
        contentPane.add(passwordField);

        setVisible(true);
        setSize(500,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestPasswordDemo01();
    }
}
