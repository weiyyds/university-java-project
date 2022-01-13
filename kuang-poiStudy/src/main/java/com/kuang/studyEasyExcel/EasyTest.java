package com.kuang.studyEasyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyTest {
    String path="F:\\ideaworkspace\\kuang-poiStudy\\student.xlsx";
    @Test
    public void test001(){
        //读取Excel文件
        //获得工作簿对象
        /**
         * pathName:读取文件路径
         * head:文件中每一行数据要存储到的实体的类型的class
         * 读监听器 ：每读取完一行数据就会回调该对象的invoke方法
         */
        ExcelReaderBuilder readWorkBook = EasyExcel.read(path, Student.class, new StudentListener());
        //获得工作表对象
        //sheet方法默认去读第一个工作表
        ExcelReaderSheetBuilder sheet = readWorkBook.sheet();
        //获得工作表单内容
        sheet.doRead();
    }
    //写入数据到easyExcel
    @Test
    public void test002(){
        //工作簿对象
        /**
         * param pathname:要写入的文件存放位置
         * param head:封装写入的数据的实体的类型
         */
        ExcelWriterBuilder workbook = EasyExcel.write("F:\\ideaworkspace\\kuang-poiStudy\\student-writer.xlsx", Student.class);
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
