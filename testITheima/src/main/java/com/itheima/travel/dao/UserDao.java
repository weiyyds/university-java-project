package com.itheima.travel.dao;

import com.itheima.travel.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * 用户模块持久层
 */
public interface UserDao {

    /**
     * 通过用户名查询一个用户
     */
    @Select("SELECT * FROM tab_user WHERE username=#{username}")
    User findByUsername(String username);

    /**
     * 通过手机号查询一个用户
     */
    @Select("SELECT * FROM tab_user WHERE telephone=#{telephone}")
    User findByTelephone(String telephone);

    /**
     * 添加用户
     */
    @Insert("insert into tab_user values(null,#{username},#{password},#{telephone},#{salt})")
    void save(User user);
}
