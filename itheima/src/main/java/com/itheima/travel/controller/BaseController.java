package com.itheima.travel.controller;

import com.itheima.travel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class BaseController {
    @Autowired
    protected HttpSession session;
    /**
     * 从会话域中获取用户对象
     */
    protected User getUserFromSession(){
        User user = (User) session.getAttribute("user");
        return user;
    }
}
