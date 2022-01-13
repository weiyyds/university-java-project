package com.kuang.config;

import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * @Configuration
 * 这个也会被spring容器托管，注册到容器中，因为它本身就是一个@Component
 * @Component代表这是一个配置类，这和我们之前看的beans。xml是一样的
 *
 * @ComponentScan("com.kuang.pojo")
 * 扫描指定的包，让包下面的注解生效
 */

@Configuration
@ComponentScan("com.kuang.pojo")
public class KuangConfig {
    /**
     *
     * @Bean代表注册一个bean标签
     * 这个方法的名字相当于bean标签的id属性
     * 这个方法的返回值就相当于bean标签中的class属性
     */
    @Bean
    public User getUser(){
        return new User();//就是返回要注入到bean的对象
    }

}
