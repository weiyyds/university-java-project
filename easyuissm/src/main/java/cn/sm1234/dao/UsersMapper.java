package cn.sm1234.dao;

import cn.sm1234.entity.Users;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;


public interface UsersMapper {
    Users selByUsers(Users users);
}
