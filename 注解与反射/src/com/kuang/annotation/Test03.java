package com.kuang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    @MyAnnotation2(schools = {"西北大学","西工大"})
    public  void test(){}
    @MyAnnatation3("哈哈")
    public void test2(){}
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数 参数类型 参数名称 ()
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1代表不存在
    String [] schools();
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnatation3{
    String value();
}