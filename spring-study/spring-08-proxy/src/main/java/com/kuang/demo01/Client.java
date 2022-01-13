package com.kuang.demo01;

import java.util.Properties;

/**
 * 顾客要租房子
 */
public class Client {
    public static void main(String[] args) {
       Host host= new Host();
        Proxy proxy=new Proxy(host);
       proxy.rent();

    }

}
