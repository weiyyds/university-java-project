package com.kuang;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

public class ExcelReadTest {
    String path="F:\\ideaworkspace\\kuang-poiStudy\\";
    @Test
    public void testRead13() throws Exception {
        //准备流对象
        FileInputStream fileInputStream = new FileInputStream(path+"狂神观众统计表.xls");
        //创建一个工作簿
        Workbook workbook=new HSSFWorkbook(fileInputStream);
        //得到表
        Sheet sheetAt = workbook.getSheetAt(0);
        //得到行
        Row row = sheetAt.getRow(1);
        //得到单元格
        Cell cell = row.getCell(1);
        //获得单元格数据
        //获取字符串
        //System.out.println(cell.getStringCellValue());
        //获取日期
        System.out.println(cell.getStringCellValue());
        //关闭流
        fileInputStream.close();
    }
    @Test
    public void testRead107() throws Exception {
        //准备流对象
        FileInputStream fileInputStream = new FileInputStream(path+"testWriteBigdata07.xlsx");
        //创建一个工作簿
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        //得到表
        Sheet sheetAt = workbook.getSheetAt(0);
        //得到行
        Row row = sheetAt.getRow(1);
        //得到单元格
        Cell cell = row.getCell(1);
        //获得单元格数据
        //获取字符串
        //System.out.println(cell.getStringCellValue());
       //获取数字
        System.out.println(cell.getNumericCellValue());
        //关闭流
        fileInputStream.close();
    }

    //测试读取复杂数据格式
    @Test
    public  void  testCellType() throws Exception {
        //获取文件流
        FileInputStream fileInputStream = new FileInputStream(path+"明细表.xlsx");
        Workbook workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row rowTitle = sheet.getRow(0);
        if (rowTitle!=null){
            int cellCount = rowTitle.getPhysicalNumberOfCells();
            for (int celNum = 0; celNum < cellCount; celNum++) {
                Cell cell = rowTitle.getCell(celNum);
                if (cell!=null){
                    int cellType = cell.getCellType();
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cellValue+" | ");
                }
            }
            //换行
            System.out.println();

        }
        //获取表中的内容
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 1; rowNum <rowCount ; rowNum++) {
            Row rowDta = sheet.getRow(rowNum);
            if (rowDta!=null){
                int rowDataCount = rowDta.getPhysicalNumberOfCells();
                for (int cellNum = 0; cellNum < rowDataCount; cellNum++) {
                    //获取单元格
                    Cell cell = rowDta.getCell(cellNum);
                    //匹配单元格中的数据类型
                    if (cell!=null){
                        int cellType = cell.getCellType();
                        String cellValue="";
                        switch (cellType){
                            case XSSFCell.CELL_TYPE_STRING://字符串
                                System.out.println("[String]");
                                cellValue = cell.getStringCellValue();
                                break;
                            case XSSFCell.CELL_TYPE_BOOLEAN://布尔值
                                System.out.println("[boolean]");
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case XSSFCell.CELL_TYPE_BLANK://空值null
                                System.out.println("[blank]");
                                break;
                            case XSSFCell.CELL_TYPE_NUMERIC://数字(日期、普通数字)
                                System.out.println("[numeric]");
                                if (HSSFDateUtil.isCellDateFormatted(cell)){//日期
                                    System.out.println("[日期]");
                                    Date date = cell.getDateCellValue();
                                    cellValue = new DateTime(date).toString("yyyy-MM-dd");
                                }else{//普通数字
                                    //不是日期格式，防止数字过长
                                    System.out.println("[转换为字符串输出]");
                                    cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                                    cellValue = cell.toString();
                                }
                                break;
                            case XSSFCell.CELL_TYPE_ERROR://error
                                System.out.println("[数据类型错误]");
                                break;
                        }
                        //获取值
                        System.out.println(cellValue);
                    }


                }


            }
        }
        fileInputStream.close();

    }

    //计算公式
    @Test
    public  void  testFormula() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(path+"公式表.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(4);
        Cell cell = row.getCell(0);
        //拿到计算公式 eval
        FormulaEvaluator xssfFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
        //输出单元格内容
        int cellType = cell.getCellType();
        switch (cellType){
            case Cell.CELL_TYPE_FORMULA://公式
                String cellFormula = cell.getCellFormula();
                System.out.println(cellFormula);
                //计算
                CellValue evaluate = xssfFormulaEvaluator.evaluate(cell);
                String cellValue = evaluate.formatAsString();
                System.out.println(cellValue);
                break;
        }
    }
}
