package com.itheima.travel.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.travel.domain.Route;
import com.itheima.travel.service.RouteService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/route",produces = "application/json;charset=utf-8")
public class RouteController {
    @Autowired
    private RouteService routeService;
    @RequestMapping("/findRouteListByCid")
    public PageInfo<Route> findRouteListByCid(Integer cid,Integer pageNum,String rname){
        return routeService.findRouteByCid(cid,pageNum,rname);
    }
    /**
     * 显示首页num条记录
     */
    @RequestMapping("/findMostFavoriteRouteByCid")
    public List<Route> findMostFavoriteRouteByCid(int cid,int num){
        return routeService.findMostFavoriteRouteByCid(cid,num);
    }
    /**
     * 通过rid查询一条线路的详情，封装了四张表的数据
     */
    @SneakyThrows
    @RequestMapping("/findRouteByRid")
    public Route findRouteByRid(int rid){
        return routeService.findRouteByRid(rid);
    }

}
