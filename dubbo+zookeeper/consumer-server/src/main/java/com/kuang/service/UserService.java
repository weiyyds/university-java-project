package com.kuang.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;


@Service //加入到spring 的ioc容器中
public class UserService {
    //想拿到provider-server 提供的票 http或Rpc通信技术
    //要到注册中心拿
    @DubboReference  //引用 使用pom坐标或定义相同路径的接口名
    TicketService ticketService;

    //买票
    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心拿到了=》"+ticket);

    }
}
