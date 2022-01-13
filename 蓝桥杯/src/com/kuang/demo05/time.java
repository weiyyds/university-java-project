package com.kuang.demo05;

import java.util.Scanner;

public class time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int h=0,m=0;
        String s;
        h=i/3600;
       m=(i/60)-60;
        String gewei= new String(String.valueOf(i%10));
        System.out.println("======个位："+gewei);
        String shiwei=new String(String.valueOf((i/10%10)));
        System.out.println("======十位："+shiwei);
        s=shiwei+gewei;
        System.out.println(h+":"+m+":"+s);


    }
   /* public static void test2(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int ge=i%10;
        int shi=i/10%10;
        System.out.println("个位："+ge+"十位："+shi);
    }*/
}
