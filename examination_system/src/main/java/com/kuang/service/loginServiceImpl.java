package com.kuang.service;

import com.kuang.dao.loginMapper;
import com.kuang.entity.register;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class loginServiceImpl implements loginService{
    @Resource
    private loginMapper loginMapper;
    @Override
    public int selectAll(register register) {
        return  loginMapper.selectAll(register);
    }
}
