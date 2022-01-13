package cn.sm1234.controller;
import cn.sm1234.domain.Blog;
import cn.sm1234.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
//    添加方法
    @RequestMapping("/save")
    public String save(Blog blog){
        //判断当前是否有id值，如果有id值，那么就是修改操作
        if (blog.getId()!=null){
            blogService.update(blog);
        }else {
            blogService.save(blog);
        }

        return "succ";
    }
    /**
     * 跳转到blog/input.jsp
     */
    @RequestMapping("/input")
    public String input(){
        return "blog/input";
    }

    /**
     * 列表显示
     */
    @RequestMapping("/list")
    public String list(Model model){
        List<Blog> list=blogService.findall();
        //把数据存到模型中，传递给页面
        model.addAttribute("list",list);
        return "blog/list";
    }
    /**
     * 根据id查询博客信息
     */
    @RequestMapping("/findById")
    public String findById(Integer id,Model model){
        Blog blog=blogService.findById(id);
        //把blog对象传回input.jsp
        model.addAttribute("blog",blog);
        return "blog/input";
    }

    /**
     * 删除博客信息
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        blogService.delete(id);
        //跳转到列表页面
        return "redirect:/blog/list";
    }
}
