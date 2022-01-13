package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.StringTokenizer;

@Controller
public class formController {
    @RequestMapping("/add")
    public String add(Model model,String name){

        model.addAttribute("msg",name);
        return "test";
    }
}
