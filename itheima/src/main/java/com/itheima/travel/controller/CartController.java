package com.itheima.travel.controller;

import com.itheima.travel.domain.*;
import com.itheima.travel.service.RouteService;
import com.itheima.travel.utils.CartUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/cart",produces = "application/json;charset=utf-8")
public class CartController extends BaseController{
    @Autowired
    private CartUtils cartUtils;
    @Autowired
    private RouteService routeService;
    /**
     * 添加线路到购物车，并且返回添加的结果
     * @param num 购买的数量
     * @param rid 线路的主键
     */
    @RequestMapping("/addCart")
    public ResultInfo addCart(Integer num, String rid){
        //获取购物车对象，首先需要传入用户对象
        //从会话域中获取对象
        User user = getUserFromSession();
        Cart cart = cartUtils.getCartFromRedis(user);
        //获取购物车项集合
        HashMap<String, CartItem> cartItemMap = cart.getCartItemMap();
        //通过rid获取购物车项
        CartItem cartItem = cartItemMap.get(rid);
        if (cartItem==null){
            cartItem = new CartItem();
            //从数据库中查询线路
            Route route = routeService.findRouteById(Integer.parseInt(rid));
            cartItem.setRoute(route);
            //设置购物车项的数量
            cartItem.setNum(num);
            cartItemMap.put(rid,cartItem);
        }else{
            //不为空，就进行累加操作
            cartItem.setNum(cartItem.getNum()+num);
        }
        //将购物车更新到redis中
        cartUtils.setCartToRedis(user,cart);
        //将刚刚添加的购物项添加到会话域中，用于显示添加结果
        session.setAttribute("cartItem",cartItem);
        //返回操作结果
        return new ResultInfo(true,"添加线路到购物车成功");
    }
    /**
     * 显示刚刚添加的购物车项
     * 从会话域中获取
     */
    @RequestMapping("/showCartItem")
    public ResultInfo showCartItem(){
        CartItem cartItem = (CartItem)session.getAttribute("cartItem");
        return new ResultInfo(true,cartItem);
    }
    /**
     * 显示整个购物车
     */
    @RequestMapping("/findAll")
    public ResultInfo findAll(){
        User user = getUserFromSession();
        Cart cart = cartUtils.getCartFromRedis(user);
        return new ResultInfo(true,cart);
    }
    /**
     * 删除购物车的一项
     */
    @RequestMapping("/deleteCartItem")
    public Cart deleteCartItem(String rid){
        User user = getUserFromSession();
        Cart cart = cartUtils.getCartFromRedis(user);
        HashMap<String, CartItem> cartItemMap = cart.getCartItemMap();
        cartItemMap.remove(rid);
        //重新更新redis
        cartUtils.setCartToRedis(user,cart);
        return cart;
    }
}
