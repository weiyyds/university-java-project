package com.kuang.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 定时业务服务层
 */
@Service
public class ScheduledService {
    //在一个特定的时间执行这个方法
    //秒 分 时 日 月 周几

    /**
     * 分钟　（0-59）
     * 小时　（0-23）
     * 日期　（1-31）
     * 月份　（1-12）
     * 星期　（0-7）// 0和7均代表星期天
     */
    //每天的15时41分15秒执行一次
    @Scheduled(cron = "15 41 15 * * ?")
    public void hello(){
        System.out.println("helllo,你被执行了！！");
    }
    /**
     * "-"代表在指定的范围内触发，比如"25-45"代表从25秒开始触发到45秒结束触发
     * "/"代表触发步进(step)，"/"前面的值代表初始值("*"等同"0")，后面的值代表偏移量，比如"0/25"或者"
     * 25"代表从0分钟开始，每隔25分钟触发1次，即0分钟触发1次，第25分钟触发1次，
     * ","代表在指定的分钟触发，比如"10,20,40"代表10分钟、20分钟和40分钟时触发任务
     */
}
