package cn.sm1234.service;

import cn.sm1234.dao.UsersMapper;
import cn.sm1234.entity.Users;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UsersServiceImpl implements UsersService{
    @Resource
    private UsersMapper usersMapper;
    @Override
    public Users selByUsers(Users users) {
        return usersMapper.selByUsers(users);
    }
}
