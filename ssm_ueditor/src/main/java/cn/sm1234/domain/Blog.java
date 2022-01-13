package cn.sm1234.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.security.Principal;
import java.util.Date;

public class Blog implements Serializable {
    private  Integer id;
    private String title;
    private String author;
    //声明Date类型接收的数据格式
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date addtime;
    private String content;

    public Blog() {
    }

    public Blog(Integer id, String title, String author, Date addtime, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.addtime = addtime;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", addtime=" + addtime +
                ", content='" + content + '\'' +
                '}';
    }
}
