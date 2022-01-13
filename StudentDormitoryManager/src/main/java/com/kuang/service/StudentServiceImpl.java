package com.kuang.service;

import com.kuang.dao.StudentMapper;
import com.kuang.pojo.Student;
import com.kuang.pojo.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{
    List<Student> students = new ArrayList<>();
    @Autowired
    StudentMapper studentMapper;

    @Override
    public boolean addStudent(Student student) {
        Boolean flag=studentMapper.addStudent(student);
        return flag;
    }
    @Override
    public List<Student> selectStudent() {
        students=studentMapper.selectStudent();
        return students;

    }



    @Override
    public Pagination selByPage(int pageStart, int pageSize) {
        Pagination pagination = new Pagination();
        pagination.setRows(studentMapper.selByPage((pageStart-1)*pageSize,pageSize));
        pagination.setTotal(studentMapper.selCount());
        return pagination;
    }

    @Override
    public int selCount() {
        return 0;
    }

    @Override
    public void delete_student(String id) {
        studentMapper.delete_student(id);
    }

    @Override
    public Student edit_student(String id) {
        return studentMapper.edit_student(id);
    }

    @Override
    public void edit_studentByForm(Student student) {
        studentMapper.edit_studentByForm(student);
    }
    //模糊查询
    @Override
    public List<Student> searchByName(Student Sname) {
        students= studentMapper.searchByName(Sname);
        return students;
    }
}
