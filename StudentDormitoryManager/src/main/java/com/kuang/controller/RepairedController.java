package com.kuang.controller;

import com.kuang.pojo.Pagination;
import com.kuang.pojo.Repaired;
import com.kuang.pojo.Student;
import com.kuang.service.RepairedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class RepairedController {
    @Autowired
    RepairedServiceImpl repairedServiceImpl;
    @RequestMapping("/select_repaired")
    public List<Repaired> select_repaired(){
        return  repairedServiceImpl.select_repaired();
    }

    //删除一条信息
    @RequestMapping("/delete_repaired")
    public Object delete_student(String id){
        repairedServiceImpl.delete_repaired(id);
        Map<String, String> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","信息删除成功！");
        return map;
    }
    //添加维修信息
    @RequestMapping("/add_repaired")
    public Boolean addStudent(String dormitoryid, String reason,@DateTimeFormat(pattern="yyyy-MM-dd") Date submit_time){
     Repaired repaired = new Repaired();
     repaired.setDormitoryid(dormitoryid);
     repaired.setReason(reason);
     repaired.setSubmit_time(submit_time);
        System.out.println(repaired);
        Boolean flag=repairedServiceImpl.addRepaired(repaired);
        System.out.println(flag);
        return flag;
    }
    //修改维修信息
    @RequestMapping("/edit_repairedMessage2")
    public Object edit_repairedMessage2(int id,String dormitoryid, String reason,@DateTimeFormat(pattern="yyyy-MM-dd") Date submit_time){

        Repaired repaired = new Repaired();
        repaired.setId(id);
        repaired.setDormitoryid(dormitoryid);
        repaired.setReason(reason);
        repaired.setSubmit_time(submit_time);
        System.out.println("========"+repaired);
        //调用service方法
        repairedServiceImpl.edit_repairedMessage2(repaired);
        //返回结果信息
        HashMap<String, String> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","修改成功");
        return map;

    }
    //分页查询
    @RequestMapping("/select_repaired_page")
    public Pagination select_repaired(int page, int rows){
        return repairedServiceImpl.selByPage(page,rows);
    }
}
