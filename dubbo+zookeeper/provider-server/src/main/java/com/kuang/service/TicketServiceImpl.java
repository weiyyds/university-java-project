package com.kuang.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;
//zookeeper  服务注册与发现
@DubboService //可以被扫描到 在项目一启动时自动注册到注册中心
@Component //使用了dubbo后尽量不要使用@Service 因为dubbo也有一个同名的@service注解
public class TicketServiceImpl implements TicketService{
    @Override
    public String getTicket() {
        return "《狂神说java》";
    }
}
