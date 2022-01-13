package com.atguigu.boot;

import com.atguigu.boot.bean.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Conditional;

/**
 * @SpringBootApplication告诉springboot这是一个springboot应用
 *
 */
//@SpringBootApplication(scanBasePackages="com.atguigu")
@SpringBootApplication
public class MainApplication {
    //主入口
    public static void main(String[] args) {
        //返回我们的ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //获得容器内的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println(name);
        }
        //从容器中获取组件
//        Pet tomcat = run.getBean("tomcat", Pet.class);
//        System.out.println(tomcat);
        boolean user01 = run.containsBean("user01");
        System.out.println("user01"+user01);
        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha"+haha);
        System.out.println("hehe"+hehe);

    }
}
