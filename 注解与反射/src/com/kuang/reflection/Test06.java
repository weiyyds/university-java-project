package com.kuang.reflection;
//测试类什么时候会被初始化
public class Test06 {
    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        //Son son = new Son();

        //通过反射也会产生主动应用
        //Class.forName("com.kuang.reflection.Son");

        //不会产生类的初始化的方法
        //System.out.println(Son.b);调用子类中的父类静态属性、静态方法,子类不会初始化
        // Son[] arr=new Son[5];实例化数组，父类和子类均没有实例化
        //System.out.println(Son.M);调用子类中的常量池(final)不会引起类的初始化

    }
}
class Father{
    static int b=2;
    static {
        System.out.println("父类被加载");
    }
}
class Son extends Father{
    static {
        System.out.println("子类被加载");
        int m=300;
    }
    static int m=100;
    static final int M=100;
}
