package com.kuang;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriterTest {
    String  path="F:\\ideaworkspace\\kuang-poiStudy\\";
    @Test
    public void testWrite03() throws Exception {
        //创建一个工作簿
        Workbook workbook=new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet=workbook.createSheet("狂神观众统计表");
        //创建一行
        Row row1=sheet.createRow(0);
        //创建单元格
        Cell cell11 = row1.createCell(0);
        Cell cell12 = row1.createCell(1);
        //填充数据
        cell11.setCellValue("今日新增观众");
        cell12.setCellValue(666);

        //第二行
        Row row2=sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        Cell cell22 = row2.createCell(1);
        cell21.setCellValue("统计日期");
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);
        //生成一张表(io流)
        //这里是03版本后缀是xls
        FileOutputStream fileOutputStream = new FileOutputStream(path + "狂神观众统计表.xls");
        workbook.write(fileOutputStream);
        //关闭流对象
        fileOutputStream.close();
        //
        System.out.println("狂神观众统计表.xls 生成完毕");

    }
    @Test
    public void testWrite07() throws Exception {
        //创建一个工作簿
        Workbook workbook=new XSSFWorkbook();
        //创建一个工作表
        Sheet sheet=workbook.createSheet("狂神观众统计表");
        //创建一行
        Row row1=sheet.createRow(0);
        //创建单元格
        Cell cell11 = row1.createCell(0);
        Cell cell12 = row1.createCell(1);
        //填充数据
        cell11.setCellValue("今日新增观众");
        cell12.setCellValue(666);

        //第二行
        Row row2=sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        Cell cell22 = row2.createCell(1);
        cell21.setCellValue("统计日期");
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);
        //生成一张表(io流)
        //这里是07版本后缀是xlsx
        FileOutputStream fileOutputStream = new FileOutputStream(path + "狂神观众统计表07.xlsx");
        workbook.write(fileOutputStream);
        //关闭流对象
        fileOutputStream.close();
        //
        System.out.println("狂神观众统计表07.xls07 生成完毕");

    }
    @Test
    public  void testWriteBigdata() throws IOException {
        long start = System.currentTimeMillis();
        Workbook workbook=new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path + "testWriteBigdata.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-start)/1000);
    }
    @Test
    public  void testWriteBigdata07() throws IOException {
        long start = System.currentTimeMillis();
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 65537; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path + "testWriteBigdata07.xlsx");
        workbook.write(fileOutputStream);
        System.out.println("over");
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double) (end-start)/1000);
    }
    @Test
    public  void testWriteBigdata0707() throws IOException {
        long start = System.currentTimeMillis();
        Workbook workbook=new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        for (int rowNum = 0; rowNum < 65537; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream(path + "testWriteBigdata07.xlsx");
        workbook.write(fileOutputStream);
        System.out.println("over");
        fileOutputStream.close();

        long end = System.currentTimeMillis();
        System.out.println((double) (end-start)/1000);
    }
}
