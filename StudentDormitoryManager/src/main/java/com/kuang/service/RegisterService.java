package com.kuang.service;

import com.kuang.pojo.Register;

public interface RegisterService {
    //注册学生信息
    public void register(Register register);
    //登录
    public int login(String sno,String password);
    //登录2
    public Register logn2(Register register);
}
