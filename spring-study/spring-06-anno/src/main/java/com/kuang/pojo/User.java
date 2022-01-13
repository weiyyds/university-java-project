package com.kuang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//<bean id="user" class="com.kuang.pojo.User"></bean>等价于@Component
//@Component组件
@Component
public class User {

    public String name;
    @Value("想啥")
    public void setName(String name) {
        this.name = name;
    }
}
