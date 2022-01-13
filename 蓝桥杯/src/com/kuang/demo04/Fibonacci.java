package com.kuang.demo04;

import java.util.Scanner;

public class Fibonacci {
   static int sum=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入n的值");
        int n = sc.nextInt();
        System.out.println( getFibonacci(n));

    }
    public static  int getFibonacci(int n){
       if (n==1){
           //System.out.println(sum=1);
           sum=1;
       }
       if (n==2){
           //System.out.println(sum=1);
           sum=1;
       }
       if(n>=3&&n<1000000000){
           sum=getFibonacci(n-1)+getFibonacci(n-2);
          // System.out.println(sum);

       }
       return sum;
    }
}
