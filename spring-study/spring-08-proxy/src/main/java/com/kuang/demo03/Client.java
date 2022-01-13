package com.kuang.demo03;

public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host=new Host();
        //代理角色
        ProxyInvacationHandler prh=new ProxyInvacationHandler();
        prh.setRent(host);
        Rent proxy= (Rent) prh.getProxy();
        proxy.test();
    }
}
