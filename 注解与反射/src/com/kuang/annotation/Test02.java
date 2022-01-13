package com.kuang.annotation;

import java.lang.annotation.*;

//测试元注解
@myannotation
public class Test02 {
    @myannotation
    public void test(){

    }
}
//自定义有个注解
//@Target 表示我们可以用在哪些地方（比如方法\类）
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//@Retention 表示我们的注解在什么地方还有效（即生命周期：源码<类<运行）
@Retention(value = RetentionPolicy.RUNTIME)
//@Documented 表示是否将我们的注解生成在javadoc中
@Documented
//@Inherited 子类可以继承父类的注解
@Inherited
@interface myannotation{

}