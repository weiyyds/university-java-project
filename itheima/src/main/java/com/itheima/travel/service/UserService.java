package com.itheima.travel.service;

import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;

import java.util.Map;

public interface UserService {
    /**
     * 用户注册
     */
    ResultInfo register(User user,String smsCode);

    /**
     * 通过用户名查询一个用户
     */
    User findByUserName(String username);

    /**
     * 通过手机号查询一个用户
     */
    User findByTelephone(String telephone);

    /**
     * 发送手机短信的功能
     */
    ResultInfo sendSms(String telephone,String smsCode);

    /**
     * 登录
     */
    ResultInfo login(Map<String,String> param);
}
