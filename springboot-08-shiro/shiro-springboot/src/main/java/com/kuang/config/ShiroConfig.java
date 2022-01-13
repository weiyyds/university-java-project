package com.kuang.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //1.创建Realm对象，需要自定义
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    //2.DefaultWebSecurityManager
    @Bean(name = "securityManager2")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //3.ShiroFilterFactoryBean
    //shiroFilterFactoryBean
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager2") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        /**
         * 添加Shiro的内置过滤器
         * anno 无需认证就可以访问
         * authc 必须认证了才能访问
         * user 必须拥有  记住我 功能才能使用
         * perms 拥有对某个资源的权限才能访问
         * role 拥有某个角色权限才能访问
         */
        Map<String, String> filterMap=new LinkedHashMap<>();

        //授权
        //带了这个字符串的用户user:add
        /**
         * There was an unexpected error (type=Unauthorized, status=401).
         * 正常情况下：未授权会跳转到未授权页面
         */
        filterMap.put("/user/add","perms[user:add]");
        filterMap.put("/user/update","perms[user:update]");
//        filterMap.put("/user/add","authc");
//        filterMap.put("/user/update","authc");
        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);


        //设置登录的请求
        bean.setLoginUrl("/toLogin");
        //未授权的页面请求
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }
    //整合ShiroDialect 用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
