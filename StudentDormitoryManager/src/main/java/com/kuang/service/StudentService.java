package com.kuang.service;

import com.kuang.pojo.Pagination;
import com.kuang.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    //添加学生信息
    public boolean addStudent(Student student);
    //查询学生信息
    public List<Student> selectStudent();

    //查询条数信息
    Pagination selByPage(int pageSize, int pageNumber);
    //查询总条数
    int selCount();
    //删除一条信息
    void delete_student(String id);
    //根据学生id查询信息
    Student edit_student(String id);
    //修改学生信息
    public void edit_studentByForm(Student student);

    //模糊查询
    //根据学生姓名查询学生信息
    public List<Student> searchByName(Student Sname);
}
