package cn.sm1234.service.impl;

import cn.sm1234.dao.BlogMapper;
import cn.sm1234.domain.Blog;
import cn.sm1234.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    public BlogMapper blogMapper;
    public void save(Blog blog) {
        blogMapper.save(blog);
    }

    public List<Blog> findall() {
        return blogMapper.findAll();
    }

    public Blog findById(Integer id) {
        return blogMapper.findById(id);
    }

    public int update(Blog blog) {
        return blogMapper.update(blog);
    }

    public void delete(Integer id) {
        blogMapper.delete(id);
    }
}
