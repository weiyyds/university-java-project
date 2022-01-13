package com.kuang.studyEasyExcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

//实体类
@Data
@HeadRowHeight(20)//表头的行高
//@ContentRowHeight()内容的行高
public class Student {
    @ExcelProperty(value = "id")
    @ExcelIgnore
    private  String id;

    @ExcelProperty(value = {"学员信息表","学生姓名"})
    @ColumnWidth(20)

    private String name;

    @ExcelProperty(value = {"学员信息表","学生性别"})
    @ColumnWidth(20)
    private String gender;

    @ExcelProperty(value = {"学员信息表","出生日期"})
    @ColumnWidth(20)
    @DateTimeFormat("yyyy-MM-dd")
    private Date birthday;

}
