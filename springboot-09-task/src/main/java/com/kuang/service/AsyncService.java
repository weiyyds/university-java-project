package com.kuang.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 使用多线程模拟异步任务
 */
@Service
public class AsyncService {
    @Async  //异步方法注解，会自动打开线程池
    public void hello(){
        try {
            Thread.sleep(3000);//休眠3s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理！!!!!请稍等片刻");
    }
}
