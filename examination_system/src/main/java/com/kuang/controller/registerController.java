package com.kuang.controller;
import com.kuang.entity.register;
import com.kuang.service.registerServiceImpl;
import org.springframework.web.bind.annotation.*;
import util.md5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class registerController {
    @Resource
    private registerServiceImpl registerServiceImpl;
@RequestMapping(value = "/adduser",method= RequestMethod.POST)
    public String addUser(register user1,HttpServletRequest request){
        System.out.println(user1.toString());
//        进行md5加密：手机号和密码
        md5 md5=new md5();
        String telNumber=request.getParameter("telNumber");
        String password=request.getParameter("password");
        String tel=md5.md5password(telNumber);
        String pwd=md5.md5password(password);
        user1.setTelNumber(tel);
        user1.setPassword(pwd);
        int result=registerServiceImpl.addUser(user1);
        String code="";
        if (result==1){
          code="1";
        }else{
           code="0";
        }
    return code;
    }



}
