package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class EncodingController {
    //过滤器解决乱码

    @PostMapping("spring04/e/t1")
    public String test1(String name, Model model, HttpServletRequest request){
        try{
            //request.setCharacterEncoding("utf-8");
            System.out.println(name);
            model.addAttribute("msg",name);
            return "test";
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "error";
    }
}
