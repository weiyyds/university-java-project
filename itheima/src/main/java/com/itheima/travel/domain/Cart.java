package com.itheima.travel.domain;

import lombok.Data;

import java.util.HashMap;

/**
 * 购物车
 */
@Data
public class Cart {
    //创建集合对象
    private HashMap<String, CartItem> cartItemMap=new HashMap<>();
    //购物车的数量
    private int cartNum;
    //购物车总金额
    private double cartTotal;
    //获取购物车数量
    public int getCartNum() {
        cartNum=0;
        for (CartItem carItem : cartItemMap.values()) {
            cartNum+=carItem.getNum();
        }
        return cartNum;
    }

    public double getCartTotal() {
        cartTotal=0;
        for (CartItem carItem : cartItemMap.values()) {
            cartTotal+=carItem.getSubTotal();
        }
        return cartTotal;
    }
}