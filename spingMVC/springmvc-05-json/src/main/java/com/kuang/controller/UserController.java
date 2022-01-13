package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    //@RequestMapping(value = "/j1",produces = "application/json;charset=utf-8")
    @RequestMapping("/j1")
    @ResponseBody//加上这个注解，它就不会走视图解析器，会直接返回字符串
    public String json1() throws JsonProcessingException {
        //jackson:ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("李沁河",18,"男");
        String str = mapper.writeValueAsString(user);
        return  str;
    }
    @RequestMapping("/j2")
    @ResponseBody//加上这个注解，它就不会走视图解析器，会直接返回字符串
    public String json2() throws JsonProcessingException {
        //jackson:ObjectMapper
        //ObjectMapper mapper = new ObjectMapper();


        //创建多个对象
        User user1 = new User("李沁河1",18,"男");
        User user2 = new User("李沁河2",18,"男");
        User user3 = new User("李沁河3",18,"男");
        User user4 = new User("李沁河4",18,"男");
        User user5 = new User("李沁河5",18,"男");
        List<User> userList=new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
       //String str = mapper.writeValueAsString(userList);
        return  JsonUtils.getJson(userList);
    }


    @RequestMapping("/j3")
    @ResponseBody//加上这个注解，它就不会走视图解析器，会直接返回字符串
    public String json3() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date);
    }
    @RequestMapping("/j4")
    @ResponseBody//加上这个注解，它就不会走视图解析器，会直接返回字符串
    public String json4() throws JsonProcessingException {
        User user1 = new User("李沁河1",18,"男");
        User user2 = new User("李沁河2",18,"男");
        User user3 = new User("李沁河3",18,"男");
        User user4 = new User("李沁河4",18,"男");
        User user5 = new User("李沁河5",18,"男");
        List<User> userList=new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        String str = JSON.toJSONString(userList);
        return str;
    }
}
