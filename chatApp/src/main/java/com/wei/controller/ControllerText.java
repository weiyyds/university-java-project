package com.wei.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ControllerText {
    @RequestMapping("/getUser")
    public Map<String,Object> getUser(){
        System.out.println("微信小程序正在调用。。。。");
        Map<String, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        map.put("list",list);
        System.out.println("微信小程序调用完成");
        return map;
    }
    //获取数据
    @RequestMapping("/getWord")
    public Map<String,Object> getText(String word){
        Map<String, Object> map = new HashMap<>();
        String message="学不死就往死里学";
        if("后来".equals(word)){
            message="正在热映的后来的我们是刘若英的处女座";
        }else if ("微信小程序".equals(word)){
            message="想获取更多微信小程序的相关知识，请更多的阅读微信官方文档，还有其他更多微信开发相关的内容，学无止境";
        }else if("西安工业大学".equals(word)){
            message="西安工业大学(Xi an Technological University) 简称西安工大 ,位于世界历史名城古都西安，" +
                    "是中国西北地区唯一一所兵工为特色，以工为主，理、文、经、管、法协调发展的教学研究型大学";
        }
        map.put("message",message);
        return map;
    }
}
