package cn.sm1234.dao;

import cn.sm1234.domain.Blog;

import java.util.List;

public interface BlogMapper {
//    保存一条博客信息
    public void save(Blog blog);

    List<Blog> findAll();

    Blog findById(Integer id);

    int update(Blog blog);

    void delete(Integer id);
}
