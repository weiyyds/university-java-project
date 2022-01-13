package com.kuang.easyExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.Date;

//实体类
@Data
public class Student {
    @ExcelProperty("id")
    private  String id;

    @ExcelProperty("学生姓名")
    @ColumnWidth(20)
    private String name;

    @ExcelProperty("学生性别")
    @ColumnWidth(20)
    private String gender;

    @ExcelProperty("出生日期")
    @ColumnWidth(20)
    private Date birthday;

}