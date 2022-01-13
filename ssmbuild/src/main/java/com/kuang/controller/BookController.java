package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
//    controller调service层
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookServiceImpl bookService;

    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }
//    跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
//    添加书籍请求
@RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBooks"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook ";
    }
//    跳转到修改页面
@RequestMapping("/toUpdate")
    public String toUpdatePaper(int id,Model model){
    Books books = bookService.queryBookById(id);
    model.addAttribute("QBbooks",books);
    return "updateBook";
    }

//    修改书籍
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("====="+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }
//    删除书籍
    @RequestMapping("/deleteBook")
    public String deleteBook(int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
//    查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        System.out.println("books"+books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if (books==null){
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
