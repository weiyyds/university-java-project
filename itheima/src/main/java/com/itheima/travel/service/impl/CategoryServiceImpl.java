package com.itheima.travel.service.impl;

import com.itheima.travel.dao.CategoryDao;
import com.itheima.travel.domain.Category;
import com.itheima.travel.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    //注入dao对象和redisTemplate
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private RedisTemplate<String,List<Category>> redisTemplate;
    public List<Category> findAll() {
        //1.从redis中获取集合
        ValueOperations<String, List<Category>> ops = redisTemplate.opsForValue();
        List<Category> category = ops.get("category");
        //判断是否为空
        if (category==null){
            System.out.println("从mysql中读取分类数据");
            category = categoryDao.findAll();
            //如果为空，则调用dao
            //查询数据库，向redis中存储一份
            ops.set("category",category);
        }else{
            System.out.println("从redis中读取分类数据");
        }
        return category;
    }
}
