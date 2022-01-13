package com.atguigu.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 用户太多的异常
 */
//HttpStatus.FORBIDDEN  403
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException{
    //无参构造器
    public UserTooManyException(){

    }
    //有参构造器
    public UserTooManyException(String message){
        super(message);
    }
}
