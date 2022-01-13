package com.kuang.controller;


import com.kuang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController//自动返回字符串
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }
    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:param=>"+name);
        if ("kuangshen".equals(name)){
            response.getWriter().println("true");
        }else{
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();
        //添加数据
        userList.add(new User("狂神说java",20,"男"));
        userList.add(new User("狂神说jquery",18,"女"));
        userList.add(new User("狂神说运维",22,"男"));
        return userList;
    }
    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        String msg="";
        if (name!=null){
            if ("admin".equals(name)){
                msg="ok";
            }else {
                msg="用户名有误";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg="ok";
            }else {
                msg="密码输入有误";
            }
        }
        return msg;
    }
}
