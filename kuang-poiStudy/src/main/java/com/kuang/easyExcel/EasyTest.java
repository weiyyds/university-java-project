package com.kuang.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.enums.WriteDirectionEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class EasyTest {
    String path="F:\\ideaworkspace\\kuang-poiStudy\\";
    private List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
    //根据list写入excel

    @Test
    public void simpleWrite() {
        // 写法1
        String fileName = path + "EasyTest.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

    }
    //读excel
    @Test
    public void simpleRead() {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = path + "EasyTest.xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new DemoDataListener()).sheet().doRead();
    }
    /**
     * 单租数据填充
     */
    @Test
    public void test01(){
        //准备模板
        String template="fill_data_template01.xlsx";
        //创建一个工作簿对象
        ExcelWriterBuilder workbook = EasyExcel.write("Excel填充-单组数据.xlsx", FillData.class).withTemplate(template);
        //创建一个工作表对象
        ExcelWriterSheetBuilder sheet = workbook.sheet();
        //准备数据
//        FillData fillData = new FillData();
//        fillData.setName("杭州黑马程序员001");
//        fillData.setAge(22);
        //准备map
        HashMap<String, String> map = new HashMap<>();
        map.put("name","战神");
        map.put("age","30");
        //填充数据
        sheet.doFill(map);
    }
    /**
     * 多组数据填充
     */
    @Test
    public void test02(){
        //准备模板
        String template="fill_data_template02.xlsx";
        //创建一个工作簿对象
        ExcelWriterBuilder workbook = EasyExcel.write("Excel填充-多组数据.xlsx", FillData.class).withTemplate(template);
        //创建一个工作表对象
        ExcelWriterSheetBuilder sheet = workbook.sheet();
        //准备数据
        List<FillData> data = initFillData();
        //填充数据
        sheet.doFill(data);
    }
    /**
     * 生成多组数据代码
     */
    private static List<FillData> initFillData(){
        ArrayList<FillData> fillData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            FillData fillData1 = new FillData();
            fillData1.setName("杭州黑马0"+i);
            fillData1.setAge(10+i);
            fillData.add(fillData1);
        }
        return fillData;
    }
    /**
     * 组合填充
     */
    @Test
    public void test03(){
        //准备模板
        String template="fill_data_template03.xlsx";
        //创建一个工作簿对象
        //build方法加上之后就可以反复使用工作簿
        //但是需要我们手动关闭io流
        ExcelWriter workbook = EasyExcel.write("Excel组合填充-数据.xlsx", FillData.class).withTemplate(template).build();
        //创建一个工作表对象
        WriteSheet sheet = EasyExcel.writerSheet().build();
        //组合填充时，因为多组填充的数量不确定，需要在多组填充完之后另起一行
        //换行
        FillConfig fillConfig = FillConfig.builder().forceNewRow(true).build();
        //准备数据
        List<FillData> data = initFillData();
        HashMap<String, String> dateAndTotal = new HashMap<>();
        dateAndTotal.put("date","2021-9-10");
        dateAndTotal.put("total","199");
        //填充数据
       //多组填充
        workbook.fill(data,fillConfig, sheet);
        //单组填充
        workbook.fill(dateAndTotal,sheet);
        //关闭流
        workbook.finish();
    }
    /***
     * 水平填充
     */

    @Test
    public void test04(){
        //准备模板
        String template="fill_data_template04.xlsx";
        //创建一个工作簿对象
        //build方法加上之后就可以反复使用工作簿
        //但是需要我们手动关闭io流
        ExcelWriter workbook = EasyExcel.write("Excel组水平填充-数据.xlsx", FillData.class).withTemplate(template).build();
        //创建一个工作表对象
        WriteSheet sheet = EasyExcel.writerSheet().build();
        //组合填充时，因为多组填充的数量不确定，需要在多组填充完之后另起一行
        //换行
        FillConfig fillConfig = FillConfig.builder().direction(WriteDirectionEnum.HORIZONTAL).build();
        //准备数据
        List<FillData> data = initFillData();

        //填充数据
        //多组填充
        workbook.fill(data,fillConfig, sheet);

        //关闭流
        workbook.finish();
    }
    /**
     * 综合练习
     */
    @Test
    public void test05(){
        //准备模板
        String template="report_template.xlsx";
        //创建一个工作簿对象
        //build方法加上之后就可以反复使用工作簿
        //但是需要我们手动关闭io流
        ExcelWriter workbook = EasyExcel.write("综合练习-数据.xlsx", FillData.class).withTemplate(template).build();
        //创建一个工作表对象
        WriteSheet sheet = EasyExcel.writerSheet().build();

        //准备数据
        HashMap<String, String> map = new HashMap<>();
        map.put("date","2020-09-18");
        map.put("totalCount","1000");
        map.put("increaseCount","100");
        map.put("increaseCountWeek","50");
        map.put("increaseCountMonth","100");
        List<Student> students = initData();

        //填充数据
        //多组填充
        workbook.fill(map,sheet);
        workbook.fill(students,sheet);

        //关闭流
        workbook.finish();
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
