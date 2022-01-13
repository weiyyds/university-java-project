package com.itheima.travel.service;

import com.github.pagehelper.PageInfo;
import com.itheima.travel.domain.Route;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 线路的业务层
 */
public interface RouteService {
    /**
     * 分页查询
     * @param cid 分类id
     * @param pageNum 第几页
     * @return 封装好的整个页面信息
     */
    PageInfo<Route> findRouteByCid(int cid,int pageNum,String rname);
    /**
     * 显示首页的6条记录
     */
    List<Route> findMostFavoriteRouteByCid(int cid,int num);
    /**
     * 通过rid，查询一条线路，封装四张表的数据到Route类中
     */
    Route findRouteByRid(int rid) throws InvocationTargetException, IllegalAccessException;
    /**
     * 通过rid查询一条线路
     */
    Route findRouteById(int rid);
}
