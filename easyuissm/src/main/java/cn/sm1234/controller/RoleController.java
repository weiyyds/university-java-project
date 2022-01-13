package cn.sm1234.controller;

import cn.sm1234.entity.EasyUIDatagrid;
import cn.sm1234.entity.Menu;
import cn.sm1234.entity.Role;
import cn.sm1234.service.RoleServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleServiceImpl roleServiceImpl;
    @RequestMapping("/showRole")
    @ResponseBody
    public EasyUIDatagrid showRole(@RequestParam(defaultValue = "2")int rows,@RequestParam(defaultValue = "1")int page){
       return roleServiceImpl.showRole(rows,page);
    }
    @RequestMapping("/update")
    @ResponseBody
    public int update(Role role){
        int index=roleServiceImpl.updateRole(role);
       return index;
    }
    @RequestMapping("/showPrivilege")
    @ResponseBody
    public List<Menu> showPrivilege(int id){
        return roleServiceImpl.showPrivilege(id);
    }
}
