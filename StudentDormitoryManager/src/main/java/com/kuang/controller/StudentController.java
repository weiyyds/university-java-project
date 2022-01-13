package com.kuang.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.kuang.pojo.Pagination;
import com.kuang.pojo.Student;
import com.kuang.service.StudentServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class StudentController {
    List<Student> students = new ArrayList<>();
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @RequestMapping("/add")
    public Boolean addStudent(Student student){
        Boolean flag=studentServiceImpl.addStudent(student);
        System.out.println(flag);
        return flag;
    }
    @RequestMapping("/select")
    public Pagination selectStudent(int page,int rows){
//        students=studentServiceImpl.selectStudent();
        return studentServiceImpl.selByPage(page,rows);
    }

    @RequestMapping("/export_message")
    public void export_message(HttpServletResponse response) throws IOException {
        List<Student> students = studentServiceImpl.selectStudent();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        //防止中文乱码
        String fileName= URLEncoder.encode("学生信息管理表","utf-8");
        response.setHeader("Content-Disposition","attachment;filename*=UTF-8''"+fileName+".xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        ExcelWriterBuilder workbook = EasyExcel.write(outputStream, Student.class);
        //工作表对象
        ExcelWriterSheetBuilder sheet = workbook.sheet();
        sheet.doWrite(students);
    }
    //删除一条信息
    @RequestMapping("/delete_student")
    public Object delete_student(String id){
        studentServiceImpl.delete_student(id);
        Map<String, String> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","信息删除成功！");
        return map;
    }
    //根据id修改学生信息
    @RequestMapping("/edit_student")
    public Student edit_student(String id){
        Student student = new Student();
        student= studentServiceImpl.edit_student(id);
        return student;
    }
    //修改学生信息
    @RequestMapping("/edit")
    @ResponseBody
    public Object edit(Student student){
        System.out.println(student);
        //调用service方法
        studentServiceImpl.edit_studentByForm(student);
        //返回结果信息
        HashMap<String, String> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","修改成功");
        return map;

    }
    //模糊查询
    @RequestMapping("/searchByName")
    public List<Student> searchByName(Student Sname){
        students=studentServiceImpl.searchByName(Sname);
        return students;
    }

}
