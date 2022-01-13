package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Import({User.class, DBHelper.class})
 * 导入到容器中会自动调用无参构造创建出实例对象
 */
//@Import({User.class, DBHelper.class})

//@Configuration//告诉springboot这是一个配置类==配置文件
//@ImportResource("classpath:beans.xml")
;
//@EnableConfigurationProperties(Car.class)
//会自动把Car这个类注入到容器中
public class MyConfig {
    @ConditionalOnBean(name="tomcat")
    @Bean   //@Bean给容器中添加组件，以方法名作为组件的id
    public User user01(){
        return new User("张三",18);
    }
//    @Bean
    public Pet tomcat(){
        return new Pet("tomcat");
    }
}
