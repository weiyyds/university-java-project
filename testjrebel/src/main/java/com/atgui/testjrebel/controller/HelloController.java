package com.atgui.testjrebel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/test")
    public  String test(){
        System.out.println("test1112333333 ok");
        return "hello word123";
    }
}

