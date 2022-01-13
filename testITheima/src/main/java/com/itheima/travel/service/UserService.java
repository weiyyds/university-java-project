package com.itheima.travel.service;

import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;

/**
 * 用户业务层
 */
public interface UserService {

    /**
     * 注册功能
     */
    ResultInfo register(User user);

    /**
     * 通过用户名查询一个用户
     */
    User findByUsername(String username);

    /**
     * 通过手机号查询一个用户
     */
    User findByTelephone(String telephone);

    /**
     * 发送手机短信的功能
     */
    ResultInfo sendSms(String telephone, String smsCode);
}
