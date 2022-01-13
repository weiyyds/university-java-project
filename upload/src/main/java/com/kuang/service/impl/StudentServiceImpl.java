package com.kuang.service.impl;

import com.kuang.pojo.Student;
import com.kuang.service.StudentService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void readExcel(List<Student> students) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (Student student:students ) {
            String date = simpleDateFormat.format(student.getBirthday());
            System.out.println(student.getName()+","+student.getGender()+","+date);
        }
    }
}
