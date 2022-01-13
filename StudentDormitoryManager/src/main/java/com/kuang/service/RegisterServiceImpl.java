package com.kuang.service;

import com.kuang.dao.RegisterMapper;
import com.kuang.pojo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    RegisterMapper registerMapper;
    @Override
    public void register(Register register) {
        registerMapper.register(register);
    }

    @Override
    public int login(String sno, String password) {
        return  registerMapper.login(sno,password);
    }

    @Override
    public Register logn2(Register register) {
        Register reg = new Register();
        reg=registerMapper.logn2(register);
        return reg;
    }
}
