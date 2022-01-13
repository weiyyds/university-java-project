package com.itheima.travel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.travel.dao.RouteDao;
import com.itheima.travel.domain.Category;
import com.itheima.travel.domain.Route;
import com.itheima.travel.domain.RouteImg;
import com.itheima.travel.domain.Seller;
import com.itheima.travel.service.RouteService;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteDao routeDao;
    public PageInfo<Route> findRouteByCid(int cid, int pageNum,String rname) {
        //调用分页组件
        PageHelper.startPage(pageNum,3);
        //调用数据库查询线路
        List<Route> list = routeDao.findRouteByCid(cid,rname);
        //把list封装到PageInfo
        return new PageInfo<>(list);


    }

    @Override
    public List<Route> findMostFavoriteRouteByCid(int cid, int num) {
        return routeDao.findMostFavoriteRouteBiCid(cid,num);
    }
    /**
     * 通过rid，查询一条线路，封装四张表的数据到Route类中
     */
    @SneakyThrows
    @Override
    public Route findRouteByRid(int rid) {
        //调用dao层，获取三张表的数据
        Map<String, Object> routeMap = routeDao.findRouteByRid(rid);
        //创建一个route对象,并且复制map中与route类中同名的属性值
        Route route = new Route();
        BeanUtils.populate(route,routeMap);
        //拷贝分类对象
        Category category = new Category();
        BeanUtils.populate(category,routeMap);
        //拷贝商家对象
        Seller seller = new Seller();
        BeanUtils.populate(seller,routeMap);
        route.setCategory(category);
        route.setSeller(seller);
        //调用dao层，获取一条线路的所有图片
        List<RouteImg> imgList = routeDao.findRouteImgByRid(rid);
        route.setRouteImgList(imgList);
        //返回对象
        return route;
    }
    /**
     * 通过rid查询一条线路
     */
    @Override
    public Route findRouteById(int rid) {
        return routeDao.findRouteById(rid);
    }
}
