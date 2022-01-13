package com.itheima.travel.dao;

import com.itheima.travel.domain.Route;
import com.itheima.travel.domain.RouteImg;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 线路的持久层
 */
public interface RouteDao {
    /**
     * 查询某个分类下所有的线路信息
     * @param cid
     * @return
     * 在mybatis的sql环境中两个以上的参数必须要加上(@Param注解，否则会爆异常，找不到对象
     */
    List<Route> findRouteByCid(@Param("cid") int cid,@Param("rname") String rname);
    /**
     * 显示首页6条记录
     */
    @Select("SELECT * FROM tab_route WHERE cid=#{cid} ORDER BY NUM DESC LIMIT #{num} ")
    List<Route> findMostFavoriteRouteBiCid(@Param("cid") int cid,@Param("num") int num);
    /**
     * 查询一条线路，包括三张表的信息：分类、线路、商家
     *
     */
    @Select("SELECT * FROM tab_category c INNER JOIN tab_route r ON c.cid=r.cid INNER JOIN tab_seller s ON r.sid=s.sid WHERE rid=#{rid}")
    Map<String,Object> findRouteByRid(int rid);
    /**
     * 查询一条线路对应得所有图片
     */
    @Select("SELECT * FROM tab_route_img WHERE rid=#{rid}")
    List<RouteImg> findRouteImgByRid(int rid);
    /**
     * 通过rid查询一条线路
     */
    @Select("select * from tab_route where rid=#{rid}")
    Route findRouteById(int rid);
}
