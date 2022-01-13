package com.kuang.Swing.lesson06;

import javax.swing.*;
import java.awt.*;
import java.security.PublicKey;

//测试下拉框
public class TestComboxDemo01 extends JFrame {
    public TestComboxDemo01(){
        Container contentPane = this.getContentPane();
        JComboBox status = new JComboBox();
        status.addItem(null);
        status.addItem("正在上映");
        status.addItem("已下架");
        status.addItem("即将上映");
        contentPane.add(status);

        setVisible(true);
        setSize(500,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestComboxDemo01();
    }
}
