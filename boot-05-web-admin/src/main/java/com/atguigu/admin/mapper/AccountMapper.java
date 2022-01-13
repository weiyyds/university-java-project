package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * 操作test数据库下的account表
 */
//@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}
