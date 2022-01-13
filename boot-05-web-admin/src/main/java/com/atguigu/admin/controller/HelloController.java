package com.atguigu.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/test")
    public  String test(){
        System.out.println("测试123");
        return "hello 123456";
    }
}
