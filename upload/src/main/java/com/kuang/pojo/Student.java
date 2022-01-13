package com.kuang.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.Date;
@Data
public class Student {

    @ExcelIgnore
    private  String id;

    @ExcelProperty("学生姓名")
    @ColumnWidth(20)
    private String name;

    @ExcelProperty("学生性别")
    @ColumnWidth(20)
    private String gender;

    @ExcelProperty("出生日期")
    @ColumnWidth(20)
    @DateTimeFormat("yyyy-MM-dd")
    private Date birthday;
}
