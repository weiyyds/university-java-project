package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {
    @GetMapping("/test/person")
    @ResponseBody
    public Person getPerson(){
        Person person = new Person();
        person.setAge(45);
        person.setBirth(new Date());
        person.setUserName("隔壁老樊");
        return person;
    }
}
