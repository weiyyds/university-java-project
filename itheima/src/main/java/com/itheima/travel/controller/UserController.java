package com.itheima.travel.controller;
import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@RestController
//produces 指定返回的数据类型和编码
@Slf4j
@RequestMapping(path = "/user",produces = "application/json;charset=utf-8")
public class UserController extends BaseController{


    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;
    /**
     * 注册功能
     */
    @PostMapping("/register")
    public ResultInfo register(@RequestBody Map<String,Object> params) throws InvocationTargetException, IllegalAccessException {
        //{
        // user={username=admin,
        // telephone=15678909888,
        // password=123},
        // smsCode=
        // }
        System.out.println("用户注册参数是=================="+params);
        Map<String,String> userMap = (Map<String, String>) params.get("user");
        //将userMap里面的属性复制到user对象中
        // 使用工具类进行拷贝
        User user = new User();
        BeanUtils.populate(user,userMap);
        //获取验证码
        String smsCode = (String) params.get("smsCode");
        return userService.register(user,smsCode);
    }

    /**
     * 通过用户名判断用户是否存在
     */
    @RequestMapping("/findByUserName")
    public ResultInfo findByUserName(String username){
        log.info("查询用户名:"+username);
        //调用业务层查询一个用户
        User user = userService.findByUserName(username);
        //如果user为空，表示可以注册
        if (user==null){
            return new ResultInfo(true);
        }
        //如果不为空，表示已经存在
        else{
            return new ResultInfo(false,"用户名已经注册");
        }
    }
    /**
     * 通过手机号判断用户是否存在
     */
    @RequestMapping("/findByTelephone")
    public ResultInfo findByTelephone(String telephone){
        log.info("查询手机号:"+telephone);
        //调用业务层查询一个用户
        User user = userService.findByTelephone(telephone);
        //如果user为空，表示可以注册
        if (user==null){
            return new ResultInfo(true);
        }
        //如果不为空，表示已经存在
        else{
            return new ResultInfo(false,"手机号已被注册");
        }
    }
    /**
     * 发送短信
     */
    @RequestMapping("/sendSms")
    public ResultInfo sendSms(String telephone){
        //生成随机6个数字
        String code = RandomStringUtils.randomNumeric(6);
        System.out.println("=================验证码："+code);
        //发送短信
        ResultInfo resultInfo = userService.sendSms(telephone, code);
        return resultInfo;
    }
    /**
     * 登录发送手机验证码
     */
    @RequestMapping("/loginSendMessage")
    public ResultInfo loginSendMessage(String username){
        //通过用户名查询对象
        User user = userService.findByUserName(username);
        if (user==null){
            return new ResultInfo(false,"用户名不存在");
        }
        //用户存在，获取手机号
        String telephone = user.getTelephone();
        //发送验证码,随机产生6位数
        String code = RandomStringUtils.randomNumeric(6);
        System.out.println("登录的验证码"+code);
        //调用业务层，发送短信
        ResultInfo resultInfo = userService.sendSms(telephone, code);
        return resultInfo;
    }
    /**
     * 登录
     */
    @RequestMapping("/login")
    public ResultInfo login(@RequestBody Map<String,String> param){
        ResultInfo resultInfo = userService.login(param);
        if (resultInfo.getSuccess()){
            session.setAttribute("user",resultInfo.getData());
        }
        return resultInfo;
    }
    /**
     * 判断用户是否登录
     */
    @RequestMapping("/isLogged")
    public ResultInfo isLogged(){
        User user = getUserFromSession();
        if (user!=null){
            return new ResultInfo(true,"用户已登录",user.getUsername());
        }else {
            return new ResultInfo(false,"用户未登录");
        }
    }
    /**
     * 用户退出
     */
    @RequestMapping("/logout")
    public void logout(){
        //销毁会话
        session.invalidate();
    }
}

