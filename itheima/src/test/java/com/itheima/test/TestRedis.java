package com.itheima.test;

import com.github.pagehelper.PageInfo;
import com.itheima.travel.domain.Cart;
import com.itheima.travel.domain.CartItem;
import com.itheima.travel.domain.Route;
import com.itheima.travel.domain.User;
import com.itheima.travel.service.RouteService;
import com.itheima.travel.utils.CartUtils;
import com.itheima.travel.utils.UuidUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestRedis {
    @Autowired
    private RedisTemplate<String, User> redisTemplate;
    @Autowired
    private RouteService routeService;
    @Autowired
    private CartUtils cartUtils;    //购物车工具类
    @Test
    public void testRedisTemplate(){
        //往redis中存储string
        ValueOperations<String, User> ops = redisTemplate.opsForValue();
        User user = new User();
        user.setUid(1111);
        user.setUsername("孙悟空");
        user.setPassword("helloword");
        user.setSalt(UuidUtils.simpleUuid());
        ops.set("user",user);
        //从redis中获取值
        User user1 = ops.get("user");
        System.out.println(user);
    }
    //测试分页
    @Test
    public void testFindPage(){
        PageInfo<Route> pageinfo = routeService.findRouteByCid(5, 1,"");
        List<Route> list = pageinfo.getList();
        for (Route pageinoMessage:list) {
            System.out.println(pageinoMessage);
        }
        System.out.println("总记录数："+pageinfo.getTotal());
        System.out.println("总页数："+pageinfo.getPages());
    }
    //测试购物车工具类
    @Test
    public void testCartUtils() {
        User user = new User();
        user.setUsername("NewBoy");

        //获取
        Cart cart = cartUtils.getCartFromRedis(user);
        System.out.println("获取到购物车对象：" + cart);

        Route route = routeService.findRouteById(2);

        CartItem cartItem = new CartItem();
        cartItem.setNum(3);
        cartItem.setRoute(route);
        cart.getCartItemMap().put("2", cartItem);

        //添加购物车
        cartUtils.setCartToRedis(user, cart);
    }
}
