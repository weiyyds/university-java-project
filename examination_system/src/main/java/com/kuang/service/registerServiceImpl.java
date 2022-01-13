package com.kuang.service;

import com.kuang.dao.registerMapper;
import com.kuang.entity.register;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class registerServiceImpl implements registerService{
    @Resource
     private registerMapper registerMapper;
    @Override
    public int addUser(register user) {
        return registerMapper.addUser(user);
    }
}
