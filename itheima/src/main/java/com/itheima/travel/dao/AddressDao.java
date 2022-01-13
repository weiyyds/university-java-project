package com.itheima.travel.dao;

import com.itheima.travel.domain.Address;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 收货地址的持久层
 */
public interface AddressDao {
    /**
     * 通过uid查询
     */
    @Select("SELECT * FROM tab_address WHERE uid=#{uid}")
    List<Address> findByUid(int uid);
}
