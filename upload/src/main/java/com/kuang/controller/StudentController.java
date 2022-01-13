package com.kuang.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.kuang.listener.StudentListener;
import com.kuang.pojo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//多例模式
@Scope("prototype")
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentListener studentListener;
    @RequestMapping("read")
    @ResponseBody
    public String readExcel(MultipartFile uoloadExcel){
        try {
            ExcelReaderBuilder readWorkbook = EasyExcel.read(uoloadExcel.getInputStream(), Student.class, studentListener);
            readWorkbook.sheet().doRead();

            return "scuuess";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @RequestMapping("write")
    @ResponseBody
    public void writeExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //防止中文乱码
        String fileName= URLEncoder.encode("测试","utf-8");
        response.setHeader("Content-Disposition","attachment;filename*=UTF-8''"+fileName+".xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        //工作簿对象
        /**
         * param pathname:要写入的文件存放位置
         * param head:封装写入的数据的实体的类型
         */
        ExcelWriterBuilder workbook = EasyExcel.write(outputStream, Student.class);
        //工作表对象
        ExcelWriterSheetBuilder sheet = workbook.sheet();
        //写
        List<Student> students = initData();
        sheet.doWrite(students);
    }
    //准备数据
    public static List<Student> initData(){
        ArrayList<Student> students = new ArrayList<>();
        Student student = new Student();
        for (int i = 0; i < 10; i++) {
            student.setName("黑马"+i);
            student.setGender("男");
            student.setBirthday(new Date());
            students.add(student);
        }
        return students;
    }
}

