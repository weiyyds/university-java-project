package com.kuang.reflection;

public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}
class A{
    //静态代码块
    static {
        System.out.println("A类静态代码块初始化");
        m=300;
    }
    static int m=100;
//无参构造器
    public A() {
        System.out.println("A类的无参构造初始化");
    }

}
