package com.itheima.travel.controller;

import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")  //指定访问地址
@Slf4j  //输出日志
public class UserController {

    @Autowired  //依赖于业务层
    private UserService userService;

    @Autowired
    private HttpSession session;  //会话域

    /**
     * 注册的方法
     */
    @SneakyThrows  //在生成的字节码中创建捕获异常代码
    @RequestMapping("/register")
    public ResultInfo register(@RequestBody Map<String,Object> params) {  //获取请求体中数据
        //用户注册参数是：{user={username=孙悟空, telephone=16723451234, password=123}, smsCode=520571}
        log.info("用户注册参数是：{}", params);
        //需要将用户对象和验证码从map中取出来
        Map<String, String> userMap = (Map<String, String>) params.get("user");
        //将userMap的所有的属性复制到user对象中
        User user = new User();
        //使用工具类复制对象的属性值
        BeanUtils.populate(user, userMap);
        //判断验证码是否正确
        //从会话域中获取发送的手机验证码
        String code = (String) session.getAttribute("smsCode_" + user.getTelephone());
        //获取验证码
        String smsCode = (String) params.get("smsCode");
        //比较验证码是否相等
        if (!smsCode.equals(code)) {
            return new ResultInfo(false, "验证码错误");
        }
        //验证码正确，调用业务层注册
        return userService.register(user);
    }

    /**
     * 通过用户名判断用户是否存在
     */
    @RequestMapping("/findByUserName")
    public ResultInfo findByUserName(String username) {
        log.info("查询用户名：" + username);
        //调用业务层查询一个用户
        User user = userService.findByUsername(username);
        //如果user为空，表示可以注册
        if (user == null) {
            return new ResultInfo(true);
        }
        //如果不为空，表示已经存在
        else {
            return new ResultInfo(false, "用户名已经注册");
        }
    }


    /**
     * 通过手机号判断用户是否存在
     */
    @RequestMapping("/findByTelephone")
    public ResultInfo findByTelephone(String telephone) {
        log.info("查询手机号：" + telephone);
        //调用业务层查询一个用户
        User user = userService.findByTelephone(telephone);
        //如果user为空，表示可以注册
        if (user == null) {
            return new ResultInfo(true);
        }
        //如果不为空，表示已经存在
        else {
            return new ResultInfo(false, "手机号已被注册");
        }
    }

    /**
     * 发送短信
     */
    @RequestMapping("/sendSms")
    public ResultInfo sendSms(String telephone) {
        //随机生成6个数字
        String code = RandomStringUtils.randomNumeric(6);
        //输出到控制台
        log.info("验证码：{}", code);
        //发送短信
        ResultInfo resultInfo = userService.sendSms(telephone, code);
        //因为后期要判断短信是否正确，需要将验证码放在会话域中
        if (resultInfo.getSuccess()) {
            session.setAttribute("smsCode_" + telephone, code);
        }
        //返回发送的结果
        return resultInfo;
    }
}
