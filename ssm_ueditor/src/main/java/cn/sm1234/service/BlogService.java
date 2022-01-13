package cn.sm1234.service;

import cn.sm1234.domain.Blog;

import java.util.List;

public interface BlogService {
    public void save(Blog blog);

    List<Blog> findall();

    Blog findById(Integer id);

    int update(Blog blog);

    void delete(Integer id);
}
