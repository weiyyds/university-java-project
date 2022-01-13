package cn.sm1234.service;

import cn.sm1234.entity.Users;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
    Users selByUsers(Users users);
}
