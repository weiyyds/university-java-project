package com.kuang.service;

import com.kuang.dao.RepairedMapper;
import com.kuang.pojo.Pagination;
import com.kuang.pojo.Repaired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RepairedServiceImpl implements RepairedService{
    @Autowired
    RepairedMapper repairedMapper;
    @Override
    public List<Repaired> select_repaired() {
        List<Repaired> list = new ArrayList<>();
        list = repairedMapper.select_repaired();
        return list;
    }

    @Override
    public void delete_repaired(String id) {
        repairedMapper.delete_repaired(id);
    }

    @Override
    public boolean addRepaired(Repaired repaired) {
        Boolean flag=repairedMapper.addRepaired(repaired);
        return flag;
    }

    @Override
    public void edit_repairedMessage2(Repaired repaired) {
        repairedMapper.edit_repairedMessage2(repaired);
    }

    @Override
    public Pagination selByPage(int pageStart, int pageSize) {
        Pagination pagination = new Pagination();
        pagination.setRows(repairedMapper.selByPage((pageStart-1)*pageSize,pageSize));
        pagination.setTotal(repairedMapper.selCount());
        return pagination;
    }

    @Override
    public int selCount() {
        return 0;
    }


}
