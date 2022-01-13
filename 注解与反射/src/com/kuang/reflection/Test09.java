package com.kuang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        /*Class c1 = Class.forName("com.kuang.reflection.User");
        构造一个对象
        User user = (User) c1.newInstance();//本质上是调用了无参构造
        System.out.println(user);

        //通过构造器创建对象
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user1 = (User) declaredConstructor.newInstance("少伟", 001, 21);
        System.out.println(user1);
        */

        //通过反射调用普通方法
        Class c1 = Class.forName("com.kuang.reflection.User");
        User user = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getMethod("setName", String.class);
        setName.invoke(user,"狂神");//激活、执行方法
        System.out.println(user.getName());

        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性，需要关闭程序的安全监测,属性或者方法的etAccessible(true);
        name.setAccessible(true);
        /**
         * setAccessible
         * Method和Field,Constructor对象都有setAccessible（）方法
         * setAccessible作用是启动和禁用访问安全检查的开关
         * 默认为false，是开启的，
         * 参数为true则表示反射的对象在使用时取消java语言访问检查
         * 参数为false则表示反射的对象应该实施java语言访问检查
         */

        name.set(user4,"少伟");
        System.out.println(user4.getName());

    }
}
