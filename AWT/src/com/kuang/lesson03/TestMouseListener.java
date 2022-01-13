package com.kuang.lesson03;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

//鼠标监听测试
public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画图");
    }
}
//鼠标类
class MyFrame extends Frame{
    ArrayList poits;
    public MyFrame(String title){
        super(title);
        setBounds(200,200,400,300);
        //存点
        poits = new ArrayList<>();
        //鼠标监听器，针对这个窗口
        this.addMouseListener(new MyMouseListener());
        //设置窗口可见
        setVisible(true);
    }
//添加一个点到界面上
    public void  addPaint(Point point){
        poits.add(point);
    }
    @Override
    public void paint(Graphics g) {
        //画画，监听鼠标的事件
        Iterator iterator = poits.iterator();
        while (iterator.hasNext()){
           Point point=(Point) iterator.next();
           g.setColor(Color.BLUE);
           g.fillOval(point.x,point.y,10,10);
        }
    }
    //适配器模式
    private class MyMouseListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            MyFrame myFrame=(MyFrame)e.getSource();
            myFrame.addPaint(new Point(e.getX(),e.getY()));
            //画点
            //每次点击鼠标都需要重新绘画一遍
            myFrame.repaint();

        }
    }
}
