package com.itheima.travel.service;

import com.itheima.travel.domain.Address;

import java.util.List;

public interface AddressService {
    /**
     * 查询一个用户的所有收货地址
     */
    List<Address> fingAddressByUid(int uid);
}
