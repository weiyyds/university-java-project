package com.kuang.demo02;

import java.util.Scanner;

public class sum {
    public static void main(String[] args) {
        //求和公式：sn=n*(1+n)/2
        System.out.println("请输入n的值");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i>0&&i<1000000000) {
            getSum(i);
        }else{
            System.out.println("请输入正确的n");
        }

    }
    public static void getSum(int i){
        int sum=0;
        sum=i*(1+i)/2;
        System.out.println(sum);

    }
}
