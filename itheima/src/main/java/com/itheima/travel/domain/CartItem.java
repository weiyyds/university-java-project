package com.itheima.travel.domain;

import lombok.Data;

/**
 * 购物车的某一项
 */
@Data
public class CartItem {
    private Route route;//线路对象
    private int num;//购买的数量
    private double subTotal;//小计

    public double getSubTotal() {
        subTotal=num*route.getPrice();
        return subTotal;
    }
}