package com.kuang.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//游戏的面板
public class GamePanel extends JPanel implements KeyListener {
    //定义蛇的数据结构
    int length;//蛇的长度
    int[] snakeX=new int[600];//蛇的x坐标25*25
    int[] snakeY=new int[500];//蛇的y坐标25*25
    String fx;//初始化方法
    //游戏当前的状态  开始  停止
    boolean isStart=false;

    public GamePanel() {
        init();
        this.setFocusable(true);//获得焦点事件
        this.addKeyListener(this);
    }

    public void init(){
        length=3;
        snakeX[0] =100;snakeY[0]=100;//脑袋的坐标
        snakeX[1] =75;snakeY[1]=100;//第一个身体的坐标
        snakeX[2] =50;snakeY[2]=100;//第二个身体的坐标
        fx="R";

    }
    //绘制面板
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.white);
        //绘制静态的面板
        Data.header.paintIcon(this,g,25,11);//头部广告栏
        g.fillRect(25,75,850,600);//默认的游戏界面
        //把小蛇画上去
        if (fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else  if (fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else  if (fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else  if (fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }


        for (int i = 1; i <length ; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //游戏状态
        if (isStart==false){
            //画笔默认是黑色
            g.setColor(Color.white);
            //设置字体
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏",300,300);
        }

    }


//键盘监听事件
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();//获得键盘按键是哪一个
        if(keyCode==KeyEvent.VK_SPACE){
            //如果按下空格键就动起来
            isStart=!isStart;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
