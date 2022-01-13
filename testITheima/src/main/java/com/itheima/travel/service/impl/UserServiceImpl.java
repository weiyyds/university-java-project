package com.itheima.travel.service.impl;

import com.itheima.travel.dao.UserDao;
import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.UserService;
import com.itheima.travel.utils.Md5Utils;
import com.itheima.travel.utils.SmsUtils;
import com.itheima.travel.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  //将当前对象创建出来，放到Spring容器中
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;  //业务层依赖于dao层

    /**
     * 注册功能
     * @param user
     */
    @Override
    public ResultInfo register(User user) {
        //1.判断用户名是否存在
        User user1 = userDao.findByUsername(user.getUsername());
        if (user1 != null) {
            return new ResultInfo(false, "用户名已经存在");
        }
        //2.判断手机是否存在
        User user2 = userDao.findByTelephone(user.getTelephone());
        if (user2 != null) {
            return new ResultInfo(false, "手机号已经被注册");
        }
        //3.如果不存在，对密码进行md5加密加盐
        //得到盐
        String salt = UuidUtils.simpleUuid();
        //密码 = md5(用户名+密码+盐)
        String md5 = Md5Utils.getMd5(user.getUsername() + user.getPassword() + salt);
        user.setPassword(md5);
        user.setSalt(salt);
        //4.把用户保存返回结果
        userDao.save(user);
        return new ResultInfo(true, "注册成功");
    }

    /**
     * 通过用户名查询一个用户
     * @param username
     */
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 通过手机号查询一个用户
     * @param telephone
     */
    @Override
    public User findByTelephone(String telephone) {
        return userDao.findByTelephone(telephone);
    }

    /**
     * 发送手机短信的功能
     * @param telephone
     * @param smsCode
     */
    @Override
    public ResultInfo sendSms(String telephone, String smsCode) {
        //1.调用工具类发送短信
        // String result = SmsUtils.send(telephone, "黑马旅游", "SMS_195723031", smsCode);
        //模拟发送成功
        String result = "OK";
        //2.判断是否是OK，如果是OK表示发送成功
        if ("OK".equals(result)) {
            return new ResultInfo(true, "短信发送成功");
        } else {
            return new ResultInfo(false, "短信发送失败");
        }
    }
}
