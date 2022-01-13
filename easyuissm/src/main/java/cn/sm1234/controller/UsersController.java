package cn.sm1234.controller;

import cn.sm1234.entity.Users;

import cn.sm1234.service.UsersService;
import cn.sm1234.service.UsersServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/main")
public class UsersController {
    @Resource
    private UsersService usersServiceImpl;
    @ResponseBody
    @RequestMapping("/login")
    public String login(Users users, HttpSession session){
        Users user = usersServiceImpl.selByUsers(users);
        if(user!=null){
            session.setAttribute("user",user);
            return "1";
        }else{
            return "0";
        }
    }
}
