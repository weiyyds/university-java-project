package com.kuang.lesson02;

import jdk.nashorn.internal.ir.CallNode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText01 {
    public static void main(String[] args) {
        //启动
        MyFrame myFrame = new MyFrame();
    }
}
class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        //省略this.
        add(textField);
        //设置替换编码格式
        textField.setEchoChar('*');
        //监听这个文本框输入的内容
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextField field=(TextField)e.getSource();
                String text = field.getText();//获得输入框中的文本
                System.out.println(text);
                field.setText("");
            }
        });
        setVisible(true);
        pack();
    }

}
