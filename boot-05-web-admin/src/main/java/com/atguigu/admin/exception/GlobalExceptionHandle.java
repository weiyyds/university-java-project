package com.atguigu.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 * 处理整个web  controller的异常
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})  //代表异常处理器，处理异常
    public String handleArithException(Exception e){
        log.error("异常是:{}",e);

        return "login";//视图地址
    }
}
