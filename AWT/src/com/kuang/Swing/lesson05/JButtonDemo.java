package com.kuang.Swing.lesson05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo extends JFrame {
    public JButtonDemo(){
        Container contentPane = this.getContentPane();
        URL url = JButtonDemo.class.getResource("tx.jpg");
        ImageIcon imageIcon = new ImageIcon(url);
        JButton jButton = new JButton();
        jButton.setIcon(imageIcon);
        jButton.setToolTipText("图片按钮");
        contentPane.add(jButton);
        setVisible(true);
        setSize(500,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JButtonDemo();
    }
}
