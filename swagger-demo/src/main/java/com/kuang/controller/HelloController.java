package com.kuang.controller;

import com.kuang.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello word";
    }
    @PostMapping("/user")
    public User user(){
        return new User();
    }
    //作用在方法上
    @ApiOperation("Hello2控制方法")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    @ApiOperation("Post测试类")
    @PostMapping("/postt")
    public User postt(@ApiParam("用户") User user){
        return user;
    }
}
