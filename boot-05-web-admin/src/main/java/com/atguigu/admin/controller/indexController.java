package com.atguigu.admin.controller;


import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.AccountService;
import com.atguigu.admin.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountService accountService;

   // @Autowired
    StringRedisTemplate redisTemplate;

    //测试mybatis的保存数据
    @PostMapping("/savecity/save")
    @ResponseBody
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    //测试mybatis发请求

    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id){
        return accountService.getAcctById(id);
    }


    //测试mybatis纯注解方式
    @Autowired
    CityService cityService;
    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
       return cityService.getById(id);
    }


    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong =jdbcTemplate.queryForObject("SELECT count(*) FROM tb_user", Long.class);
        return aLong.toString();
    }
    /**
     * 来到登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (!ObjectUtils.isEmpty(user.getUserName()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }
        //这里默认是请求转发，所以点击刷新会重复提交表单
        //使用重定向
        else{
            model.addAttribute("msg","账号密码错误");
            //账号密码错误，回到登录页面
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        //判断是否登录，拦截器，过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser!=null){
//            return "main";
//        }else {
//            model.addAttribute("msg","该账号未登录，请重新登录");
//            return "login";
//        }

        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String s = opsForValue.get("/main.html");
        String s1 = opsForValue.get("/sql");
        model.addAttribute("mainCount",s);
        model.addAttribute("sqlCount",s1);

        return "main";

    }
}
