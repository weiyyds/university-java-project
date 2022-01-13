package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParamterTestController {
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username")  String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters") List<String> inters,
                                     @RequestParam Map<String,String> params){
        Map<String, Object> map = new HashMap<>();
//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("User-Agent",userAgent);
//        map.put("header",header);
          map.put("age",age);
          map.put("inters",inters);
          map.put("param",params);
        return map;
    }
    /**
     * 测试获取请求体中的表单内容
     */
    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }
        /**
         * 测试pojo类的请求
         */
        @PostMapping("/saveuser")
        public  Person saveuser(Person person){
            return person;
        }
}
