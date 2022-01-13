package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加一本书
    int addBook(Books books);
    //删除一本书
    int deleteBookById(@Param("bookId") int id);

    //更新一本书
    int updateBook(Books books);

    //根据id查询一本书
    Books queryBookById(@Param("bookID") int id);

    //查询所有书
    List<Books> queryAllBook();

//    模糊查询
    Books queryBookByName(@Param("bookName") String bookName);
}
