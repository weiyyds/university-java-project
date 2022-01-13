package com.kuang.controller;

import com.kuang.entity.register;
import com.kuang.service.loginServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import util.md5;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
public class loginController {
    @Resource
    private loginServiceImpl loginServiceImpl;
    @RequestMapping("/login")
    public int goSuccess_login(register register, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int result=0;
        String telNumber=request.getParameter("telNumber");
        String password=request.getParameter("password");
        md5 md5=new md5();
        String tel=md5.md5password(telNumber);
        String pwd=md5.md5password(password);
        register.setTelNumber(tel);
        register.setPassword(pwd);
        String input_code=request.getParameter("input_code").toUpperCase();
        HttpSession session=request.getSession();
        Object value=session.getAttribute("piccode");
        if (input_code.equals(value)&&telNumber!=""&&password!=""){
            result=loginServiceImpl.selectAll(register);
            //System.out.println("result=="+result);
        }
        if (telNumber==""||password==""){
            result=-1;
        }
        if (input_code.equals(value)==false){
            result=-2;
        }
        return result;

    }
}
