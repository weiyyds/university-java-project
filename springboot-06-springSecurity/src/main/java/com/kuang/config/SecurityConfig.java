package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人都可以访问，但是功能页只有对应权限的人才可以访问
        //请求授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //没有权限设置回到登录页
        //http://localhost:8080/login
        http.formLogin()
                .loginPage("/toLogin")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginProcessingUrl("/login");
        // .defaultSuccessUrl("/index")//登录认证成功后默认转跳的路径
        //注销
        //http://localhost:8080/logout
        /*
        logout().deleteCookies("remove").invalidateHttpSession(false)
                .logoutUrl("/custom-logout").logoutSuccessUrl("/logout-success");

                http.logout().deleteCookies("remove").invalidateHttpSession(true).logoutUrl("/");
         */

        //http://localhost:8080/logout
        //There was an unexpected error (type=Not Found, status=404).
        //防止网站攻击，crsf  get\post
        http.csrf().disable();//关闭crsf功能，默认开启
        http.logout().logoutSuccessUrl("/");

        //记住我功能（保存用户的登录状态） 基于cookie实现
        //默认保存两周
        http.rememberMe().rememberMeParameter("remember");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //定制认证规则
        //这些数据正常是从数据库中读取
        //inMemory在内存中创建
        /**
         * There is no PasswordEncoder mapped for the id "null"
         * 需要对密码加密操作
         */
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("狂神").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and()
                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
