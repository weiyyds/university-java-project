package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
//        把用户信息存到session中
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);
        return "main";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/gologin")
    public String login(){
        return "login";
    }

//注销
    @RequestMapping("/goOut")
    public String login(HttpSession session){
            session.removeAttribute("userLoginInfo");
            return "login";
    }
}
