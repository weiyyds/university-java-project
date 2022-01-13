package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功");
        request.setAttribute("code",200);
        return "forward:/success";//转发到/success请求
    }
    @ResponseBody
    @GetMapping("/success")
    public Map success(@RequestAttribute(value = "msg",required = false) String msg,
                       @RequestAttribute(value = "code",required = false)Integer code,
                       HttpServletRequest request){
        Object hello = request.getAttribute("hello");
        Object word = request.getAttribute("word");
        Object message = request.getAttribute("message");

        Map<Object, Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("code",code);
        map.put("hello",hello);
        map.put("word",word);
        map.put("message",message);
        return map;
    }
    /**
     * 测试复杂参数Map,model
     */
    @RequestMapping("/param")
    public String testParam(Map<String,Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response){
        map.put("hello","word666");
        model.addAttribute("word","hello6666");
        request.setAttribute("message","helloword");
        Cookie cookie = new Cookie("c1","v1");
        //cookie.setDomain("localhost");//作用域范围localhost
        response.addCookie(cookie);
        return "forward:/success";
    }
}
