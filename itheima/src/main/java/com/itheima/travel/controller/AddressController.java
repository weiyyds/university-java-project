package com.itheima.travel.controller;

import com.itheima.travel.domain.Address;
import com.itheima.travel.domain.Cart;
import com.itheima.travel.domain.ResultInfo;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.AddressService;
import com.itheima.travel.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * 订单控制器
 */
@RestController
@RequestMapping(value = "/order",produces = "application/json;charset=utf-8")
public class AddressController extends BaseController{
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartUtils cartUtils;
    @RequestMapping("/prepareOrder")
    public ResultInfo prepareOrder(){
        User user = getUserFromSession();
        //获取当前用户的所有地址
        List<Address> addressList = addressService.fingAddressByUid(user.getUid());
        for (Address address:  addressList ) {
            System.out.println("============"+address);
        }
        //获得当前用户的购物车
        Cart cart = cartUtils.getCartFromRedis(user);
        //将地址和购物车封装到map中
        HashMap<String, Object> map = new HashMap<>();
        map.put("addressList",addressList);
        map.put("cart",cart);
        return new ResultInfo(true,map);
    }
}
