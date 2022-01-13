package com.kuang.dao;

import com.kuang.entity.register;
import org.springframework.stereotype.Repository;

@Repository
public interface registerMapper {
//    增加一个用户的信息
    int addUser(register user);
}
