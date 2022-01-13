package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.exception.UserTooManyException;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    UserService userService;
    /**
     * 不带请求参数，或者参数类型不对都是400
     * type=Bad Request, status=400
     * @param a
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int i=10/0;
        return "table/basic_table";
    }

    //删除用户的方法
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        boolean b = userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }





    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("张三", "123456"),
//                new User("李四", "lisi"),
//                new User("haha", "aaa"),
//                new User("hehe", "bbb"));
//        model.addAttribute("users",users);
//        //自定义异常
//        if(users.size()>3){
//            throw new UserTooManyException();
//        }
        //从数据库中查询user表中数据进行页面展示
        //List<User> list = userService.list();
       // model.addAttribute("users",list);
        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);
        long current = page.getCurrent();
        //当前分页的总页数
        long pages = page.getPages();
        //总记录数
        long total = page.getTotal();
        final List<User> records = page.getRecords();
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
