package com.kuang.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

//学生实体类
public class Student {
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("性别")
    private String sex;//性别
    @ExcelProperty("年龄")
    private String age;//年龄
    @ExcelProperty("班级")
    @ColumnWidth(20)
    private String course;//班级
    @ExcelProperty("宿舍楼")
    @ColumnWidth(20)
    private String dormitoryid;//宿舍楼
    @ExcelProperty("学号")
    @ColumnWidth(30)
    private String sno;//学号
    @ExcelProperty("学生姓名")
    @ColumnWidth(30)
    private String sname;//学生姓名
    @ColumnWidth(40)
    @ExcelProperty("手机号")
    private String sphone;//学生手机号
    public Student() {
    }

    public Student(int id, String sex, String age, String course, String dormitoryid, String sno, String sname, String sphone) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.dormitoryid = dormitoryid;
        this.sno = sno;
        this.sname = sname;
        this.sphone = sphone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDormitoryid() {
        return dormitoryid;
    }

    public void setDormitoryid(String dormitoryid) {
        this.dormitoryid = dormitoryid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", course='" + course + '\'' +
                ", dormitoryid='" + dormitoryid + '\'' +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sphone='" + sphone + '\'' +
                '}';
    }
}