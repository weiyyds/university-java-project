package com.kuang.entity;
import java.io.Serializable;
import java.util.List;
import java.io.Serializable;

public class Item implements Serializable {
    private Integer iid;
    private String name;
    private String note;
    private List<Books> Book;//表示一个类别下有多本书

    public Item() {
    }

    public Item(Integer iid, String name, String note, List<Books> book) {
        this.iid = iid;
        this.name = name;
        this.note = note;
        Book = book;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Books> getBook() {
        return Book;
    }

    public void setBook(List<Books> book) {
        Book = book;
    }

    @Override
    public String toString() {
        return "Item{" +
                "iid=" + iid +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", Book=" + Book +
                '}';
    }
}
