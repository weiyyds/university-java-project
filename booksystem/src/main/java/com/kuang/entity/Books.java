package com.kuang.entity;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class Books  implements Serializable{
    private Integer Bid;
    private String name;
    private Date credate;
    private String note;
    private Integer status;
    private Item item;//表示一本书属于一个类别 iid
    private Admin admin;//表示图书由谁增加，aid
    private List<Lenbook> Lenbook;//表示可以借多本书

    public Books() {
    }

    public Books(Integer bid, String name, Date credate, String note, Integer status, Item item, Admin admin, List<Lenbook> lenbook) {
        Bid = bid;
        this.name = name;
        this.credate = credate;
        this.note = note;
        this.status = status;
        this.item = item;
        this.admin = admin;
        Lenbook = lenbook;
    }

    public List<com.kuang.entity.Lenbook> getLenbook() {
        return Lenbook;
    }

    public void setLenbook(List<com.kuang.entity.Lenbook> lenbook) {
        Lenbook = lenbook;
    }

    public Integer getBid() {
        return Bid;
    }

    public void setBid(Integer bid) {
        Bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCredate() {
        return credate;
    }

    public void setCredate(Date credate) {
        this.credate = credate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setBid(int bid) {
        this.Bid = bid;
    }

    @Override
    public String toString() {
        return "Books{" +
                "Bid=" + Bid +
                ", name='" + name + '\'' +
                ", credate=" + credate +
                ", note='" + note + '\'' +
                ", status=" + status +
                ", item=" + item +
                ", admin=" + admin +
                ", Lenbook=" + Lenbook +
                '}';
    }
}
