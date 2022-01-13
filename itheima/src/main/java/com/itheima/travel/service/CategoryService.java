package com.itheima.travel.service;

import com.itheima.travel.domain.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 从redis或mysql获取所有分类数据
     */
    List<Category> findAll();
}
