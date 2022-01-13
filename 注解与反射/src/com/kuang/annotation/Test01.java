package com.kuang.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

//什么是注解

public class Test01 extends Object{
//    @Override重写的注解
    @Override
    public  String toString() {
        return "zhujie";
    }
//   @Deprecated 不推荐程序猿使用，但可以使用，或者有更好的方式选择
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }
//    @SuppressWarnings("all") 抑制警告
    @SuppressWarnings("all")
    public static  void test02(){
        List list=new ArrayList();
    }

    public static void main(String[] args) {
        Test01 test01=new Test01();
//        System.out.println(test01.toString());
        test();
    }
}
