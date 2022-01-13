package com.itheima.travel.utils;

import com.itheima.travel.domain.Cart;
import com.itheima.travel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * 购物车工具类
 */
@Component
public class CartUtils {
    @Autowired
    private RedisTemplate<String,Cart> redisTemplate;
    //设置购物车对象
    public void setCartToRedis(User user, Cart cart){
        ValueOperations<String, Cart> ops = redisTemplate.opsForValue();
        ops.set("cart_"+user.getUsername(),cart);
    }
    //根据用户名获取购物车对象
    public Cart getCartFromRedis(User user){
        ValueOperations<String, Cart> ops = redisTemplate.opsForValue();
        Cart cart = ops.get("cart_" + user.getUsername());
        //判断如果购物车为空，就new一个购物车对象
        if (cart==null){
            cart=new Cart();
        }
        return cart;
    }
    //删除购物车对象
    public void removeCart(User user){
    redisTemplate.delete("cart_"+user.getUsername());
    }
}
