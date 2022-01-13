package com.kuang.Swing.lesson06;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

//测试下拉框
public class TestComboxDemo02 extends JFrame {
    public TestComboxDemo02(){
        Container contentPane = this.getContentPane();
       //生成列表的内容
        //String[] arr={"java","python","Linux"};
        Vector vector = new Vector();
        vector.add("张三");
        vector.add("李四");
        vector.add("王五");
        JList jList = new JList(vector);
      contentPane.add(jList);

        setVisible(true);
        setSize(500,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestComboxDemo02();
    }
}
