package com.kuang.demo03;

import javafx.scene.SceneAntialiasing;

import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        //求圆的面积，输入半径r
        System.out.println("请输入r的值");
        Scanner sc = new Scanner(System.in);
        double r = sc.nextDouble();
        getArea(r);

    }
    public static void getArea(double r){
        double s=0;
        double pi = Math.PI;
        s=pi*(r*r);
        System.out.println("s的面积=="+String.format("%.7f",s));

    }
}
