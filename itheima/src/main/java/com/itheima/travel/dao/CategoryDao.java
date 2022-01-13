package com.itheima.travel.dao;

import com.itheima.travel.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 分类的持久层
 */
public interface CategoryDao {
    /**
     * 查询所有的分类，并且按cid升序排序
     */
    @Select("SELECT * FROM tab_category ORDER BY cid")
    List<Category> findAll();
}
