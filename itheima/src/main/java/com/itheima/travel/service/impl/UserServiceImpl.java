package com.itheima.travel.service.impl;

import com.itheima.travel.dao.UserDao;
import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.UserService;
import com.itheima.travel.utils.Md5Utils;
import com.itheima.travel.utils.SmsUtils;
import com.itheima.travel.utils.UuidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    /**
     * 用户注册
     * @param user
     */

    public ResultInfo register(User user,String smsCode) {
        //1.判断用户名是否存在
        User byUserName = userDao.findByUserName(user.getUsername());
        if (byUserName != null) {
            return new ResultInfo(false, "用户名已经存在");
        }
        //2.判断电话号码是否存在
        User byTelephone = userDao.findByTelephone(user.getTelephone());
        if (byTelephone != null) {
            return new ResultInfo(false, "手机号已经被注册了");
        }
        //=============================================================
        //判断验证码是否正确
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //获取redis中的验证码
        String code = ops.get("smsCode_" + user.getTelephone());
        if(code==null){
            return new ResultInfo(false,"验证码已经过期了");
        }
        //判断验证码是否一样
        if(!code.equals(smsCode)){
            return new ResultInfo(false,"验证码错误");
        }
        System.out.println(code);
        System.out.println(smsCode);
        //如果验证码正确的，删除验证码
        redisTemplate.delete("smsCode_"+user.getTelephone());
        //3.对密码使用md5加密：md5(用户名+密码+盐)
        //产生盐
        String salt = UuidUtils.simpleUuid();
        //使用md5进行加密
        String md5 = Md5Utils.getMd5(user.getUsername() + user.getPassword() + salt);
        //替换原来密码字段
        user.setPassword(md5);
        //设置盐
        user.setSalt(salt);
        //4.调用dao添加用户方法
        userDao.save(user);
        return new ResultInfo(true, "用户注册成功");
    }

    /**
     * 通过用户名查询一个用户
     * @param username
     */

    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    /**
     * 通过手机号查询一个用户
     * @param telephone
     * @return
     */

    public User findByTelephone(String telephone) {
        return userDao.findByTelephone(telephone);
    }

    /**
     * 发送手机短信的功能
     */
    public ResultInfo sendSms(String telephone, String smsCode) {
       //调用发送短信工具类
       // String result = SmsUtils.send(telephone, "黑马旅游", "SMS_195723031", smsCode);
       // System.out.println("result==========="+result);
        String result ="OK";
        //equals区分英文大小写，在判断的时候注意一下
        //判断是否ok，如果ok表示发送短信成功
        if ("OK".equals(result)){
            //发送成功，将验证码存放到redis中，并设置过期时间30s
            ValueOperations<String, String> ops = redisTemplate.opsForValue();
            ops.set("smsCode_"+telephone,smsCode,30, TimeUnit.SECONDS);
            return new ResultInfo(true,"短信发送成功");
        }else{
            return new ResultInfo(false,"短信发送失败");
        }

    }

    public ResultInfo login(Map<String, String> param) {
        //通过用户名查找用户
        String username = param.get("username");
        String password = param.get("password");
        String smsCode = param.get("smsCode");
        User user = userDao.findByUserName(username);
        if(user==null){
            new ResultInfo(false,"用户名不存在");
        }
        //用户存在，判断密码是否正确
        //数据库密码=用户名+密码+盐
        //再MD5加密
        String pwd = user.getUsername() + password + user.getSalt();
        String md5 = Md5Utils.getMd5(pwd);
        //判断密码是否相等
        if(!md5.equals(user.getPassword())){
            return new ResultInfo(false,"密码错误");
        }
        //获取redis中的验证码
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String code = ops.get("smsCode_" + user.getTelephone());
        //如果验证码为空，则表示验证码过期了
        if (code==null){
            return new ResultInfo(false,"验证码过期");
        }
        //如果验证码不为空，需要判断验证码是否正确
        if(!code.equals(smsCode)){
            return new ResultInfo(false,"验证码错误");
        }
        //登录成功
        //删除redis的验证码
        redisTemplate.delete("smsCode_"+user.getTelephone());
        return new ResultInfo(true,"用户登录成功",user);
    }
}

