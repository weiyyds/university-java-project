package com.kuang.dao;

import com.kuang.pojo.Register;
import org.apache.ibatis.annotations.Param;

public interface RegisterMapper {
    //注册学生信息
    public void register(Register register);
    //登录
    public int login(@Param("sno")String sno,@Param("password")String password);
    //登录2
    public Register logn2(Register register);
}
