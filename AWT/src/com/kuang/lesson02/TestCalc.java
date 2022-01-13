package com.kuang.lesson02;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCalc {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }
}
//计算器类
class Calculator extends Frame{
    private TextField num1;
    private TextField num2;
    private TextField num3;
    public Calculator(){
        ///3个文本框
        num1 = new TextField(10);
        num2 = new TextField(10);
        num3 = new TextField(20);

        //1个按钮
        Button button = new Button("=");
        //1个标签
        Label label = new Label("+");
        //布局
        setLayout(new FlowLayout());
        add(num1);
        add(label);
        add(num2);
        add(button);
        add(num3);
        pack();
        setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n1 = Integer.parseInt(num1.getText());
                int n2 = Integer.parseInt(num2.getText());
                num3.setText(""+(n1+n2));
                //清除前两个空格
                num1.setText("");
                num2.setText("");
            }
        });
    }

}
