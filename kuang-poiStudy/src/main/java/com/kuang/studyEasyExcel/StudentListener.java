package com.kuang.studyEasyExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

//读取文档的监听器类

/**
 * extends AnalysisEventListener
 * class AnalysisEventListener<T> implements ReadListener<T>
 */
public class StudentListener extends AnalysisEventListener <Student>{


    @Override
    /**
     * param student 每次读取到的一行数据的封装对象
     */
    public void invoke(Student student, AnalysisContext analysisContext) {
        System.out.println("student="+student);
    }

    @Override
    /**
     * 读取完整个文档后的回调函数
     */
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
