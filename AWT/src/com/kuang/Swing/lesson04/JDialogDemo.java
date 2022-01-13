package com.kuang.Swing.lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogDemo extends JFrame {
    public JDialogDemo(){
        this.setVisible(true);
        this.setSize(700,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //JFrame 放东西、容器
        Container contentPane = this.getContentPane();
        //绝对定位
        contentPane.setLayout(null);
       //按钮
        JButton button = new JButton("点出一个对话框");
        button.setBounds(30,30,200,50);
        contentPane.add(button);
        //点击这个按钮的时候，弹出一个弹出一个弹窗
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDialog();
            }
        });
    }
    public static void main(String[] args) {
        new JDialogDemo();
    }
}
//弹窗的窗口
class MyDialog extends JDialog{
    public MyDialog() {
        this.setVisible(true);
        this.setBounds(100,100,500,500);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        JLabel label = new JLabel("秦老师带你学习GUI");
        label.setBounds(100,100,200,100);
        contentPane.add(label);
    }
}
