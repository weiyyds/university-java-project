package cn.sm1234.controller;

import cn.sm1234.entity.Menu;
import cn.sm1234.service.MenuServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
    @Resource
    private MenuServiceImpl menuServiceImpl;
    @RequestMapping("/showMenu")
    @ResponseBody
    public List<Menu> show(){
        return menuServiceImpl.selAll();
    }
}
