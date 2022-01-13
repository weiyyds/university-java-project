package com.kuang.lesson03;

import java.awt.*;

//画笔
public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}

class MyPaint extends Frame{
    public void  loadFrame(){
        setBounds(200,200,600,500);
        setVisible(true);
    }
    @Override
    public void paint(Graphics g) {
        //画笔
        g.setColor(Color.red);
        g.drawOval(100,100,100,100);
    }
}
