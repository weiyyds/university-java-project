package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录的用户信息
 */
//@TableName("user_tb1")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    /**
     * 所有属性都应该在数据库中存在
     */
    //以下是登录时用户名密码
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

//以下是数据库字段
    private Long id;
    private String name;
    private Integer age;
    private String email;


}
