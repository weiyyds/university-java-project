package com.kuang.service;

import com.kuang.pojo.Pagination;
import com.kuang.pojo.Repaired;

import java.util.List;

public interface RepairedService {
    //查询所有报修表信息
    List<Repaired> select_repaired();
    //删除一条信息
    void delete_repaired(String id);
    //添加维修信息
    public boolean addRepaired(Repaired repaired);
    //修改维修信息
    public void edit_repairedMessage2(Repaired repaired);
    //查询条数信息
    Pagination selByPage(int pageSize, int pageNumber);
    //查询总条数
    int selCount();
}
