package com.kuang.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.kuang.pojo.Student;
import com.kuang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StudentListener extends AnalysisEventListener <Student>{
    @Autowired
    StudentService studentService;
    ArrayList<Student> students=new ArrayList<Student>();

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        students.add(student);
        if(students.size()%5==0){
            studentService.readExcel(students);
            //清空集合
            students.clear();
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
