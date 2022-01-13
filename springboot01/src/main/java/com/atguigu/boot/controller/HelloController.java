package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller+@ResponseBody返回浏览器
//@RestController==@Controller+@ResponseBody
@Slf4j
@RestController
public class HelloController {
    @Autowired
    Car car;
    @RequestMapping("/abc")
    public String hande01(@RequestParam("name") String name){
        log.info("请求进来了。。。。");
        return "hello springboot"+"你好"+name;
    }
    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
