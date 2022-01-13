package com.kuang.entity;
import java.io.Serializable;
import java.util.Date;
public class Lenbook implements Serializable {
    private Integer leid;
    private Books books;//表示图书编号
    private Member member;//表示用户id
    private Date credate;//借书日期

    public Lenbook() {
    }

    public Lenbook(Integer leid, Books books, Member member, Date credate) {
        this.leid = leid;
        this.books = books;
        this.member = member;
        this.credate = credate;
    }

    public Integer getLeid() {
        return leid;
    }

    public void setLeid(Integer leid) {
        this.leid = leid;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    @Override
    public String toString() {
        return "Lenbook{" +
                "leid=" + leid +
                ", books=" + books +
                ", member=" + member +
                ", credate=" + credate +
                '}';
    }
}
