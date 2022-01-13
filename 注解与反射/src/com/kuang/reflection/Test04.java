package com.kuang.reflection;

import java.lang.annotation.ElementType;

//所有类型的Class对象
public class Test04 {
    public static void main(String[] args) {
        Class c1 = Object.class;
        Class c2 = Comparable.class;//接口
        Class c3=String[].class;
        Class c4=int[][].class;
        Class c5=Override.class;//注解
        Class c6= ElementType.class;//枚举
        Class c7=Integer.class;//基本数据类型
        Class c8=void.class;//空类型
        Class c9=Class.class;
        System.out.println(c1);//ctrl+d复制一行,按alt键选择多个，再cv,快速复制
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);
        System.out.println(c8);
        System.out.println(c9);

    }
}
