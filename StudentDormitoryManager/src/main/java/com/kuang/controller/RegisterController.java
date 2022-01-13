package com.kuang.controller;

import com.kuang.pojo.Register;
import com.kuang.service.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class RegisterController {
    @Autowired
    RegisterServiceImpl registerServiceImpl;
    @RequestMapping("/register")
    @ResponseBody
    public Object register(Register register,String reg_input_code,HttpSession session){
        Register reg = null;
        HashMap<String, String> map = new HashMap<>();
        String reg_input_code2=reg_input_code.toUpperCase();
        if(reg_input_code2.equals(session.getAttribute("piccode"))){
            registerServiceImpl.register(register);
            map.put("code","200");
            map.put("msg","注册成功");
        }else{
            map.put("code","200");
            map.put("msg","注册失败");
        }


        return map;
    }
    @RequestMapping("/login")
    @ResponseBody
    public Object login(Register register){
        int result=0;
        HashMap<String, String> map = new HashMap<>();
        result=registerServiceImpl.login(register.getSno(),register.getPassword());
        if(result==0){
            map.put("code","200");
            map.put("msg","该学生还未注册");

        }else{
            map.put("code","200");
            map.put("msg","登录成功");
        }
        return map;
    }
    @RequestMapping("/login2")
    @ResponseBody
    public Object login2(Register register,String input_code ,HttpSession session){
        HashMap<String, String> map = new HashMap<>();
        Register reg = null;
        String input_code2=input_code.toUpperCase();
        System.out.println(input_code2);
        System.out.println(session.getAttribute("piccode"));
        if(input_code2.equals(session.getAttribute("piccode"))){
             reg = registerServiceImpl.logn2(register);
            if (reg!=null){
                session.setAttribute("sname",reg.getSname());
                map.put("code","200");
                map.put("msg","登录成功");
            }
            else{
                map.put("code","200");
                map.put("msg","该学生还未注册");

            }
        } else{
            map.put("code","200");
            map.put("msg","验证码输入错误");
        }
        System.out.println(reg);
        System.out.println(map);
        return map;
    }
    @RequestMapping("/exit")
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("sname");
        response.sendRedirect("login.jsp");
    }


}
