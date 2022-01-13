package cn.sm1234.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*@RequestMapping("/")*/
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/info")
    public String info(){
        return "info";
    }
    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/menu")
    public String menu(){
        return "menu";
    }
    @RequestMapping("/top")
    public String top(){
        return "top";
    }
}
