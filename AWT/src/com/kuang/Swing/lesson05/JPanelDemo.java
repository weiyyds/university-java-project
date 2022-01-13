package com.kuang.Swing.lesson05;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {
    public JPanelDemo(){
        Container contentPane = this.getContentPane();
        //网格布局
        contentPane.setLayout(new GridLayout(2,1,10,10));
        JPanel panel1 = new JPanel(new GridLayout(1, 3));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("2"));
        panel1.add(new JButton("3"));
        contentPane.add(panel1);
        this.setVisible(true);
        setSize(500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
