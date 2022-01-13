package com.kuang.demo01;

import java.util.Scanner;

public class add {
    public static void main(String[] args) {
        //输入a和b，输出结果
        //自动补全变量ctrl+alt+v
         Scanner sc = new Scanner(System.in);
        System.out.println("请输入a b");
        int a = sc.nextInt();
        int b=sc.nextInt();
        getadd(a,b);


    }
    public static void getadd(int a,int b){
        int c=a+b;
        System.out.println(c);
    }
}
