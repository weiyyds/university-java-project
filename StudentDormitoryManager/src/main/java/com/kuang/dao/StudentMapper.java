package com.kuang.dao;

import com.kuang.pojo.Pagination;
import com.kuang.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    //添加学生信息
    public boolean addStudent(Student student);
    //查询学生信息
    public List<Student> selectStudent();
    //根据学生姓名模糊查询学生信息
    public List<Student> searchByName(Student Sname);

    //查询条数信息
    List<Student> selByPage(@Param("pageStart")int pageStart, @Param("rows")int pageSize);
    //查询总条数
    int selCount();
    //删除一条信息
    void delete_student(String id);
    //根据学生id查询信息
    Student edit_student(String id);
    //修改学生信息
    public void edit_studentByForm(Student student);
}
